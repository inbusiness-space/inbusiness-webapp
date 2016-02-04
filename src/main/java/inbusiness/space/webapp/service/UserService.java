package inbusiness.space.webapp.service;


import inbusiness.space.webapp.domain.Authority;
import inbusiness.space.webapp.domain.Sites;
import inbusiness.space.webapp.domain.User;
import inbusiness.space.webapp.domain.UserRole;
import inbusiness.space.webapp.dto.UsersDto;
import inbusiness.space.webapp.mapper.RespondMapper;
import inbusiness.space.webapp.repository.UserSearchRepository;
import inbusiness.space.webapp.security.SecurityUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private UserSearchRepository userSearchRepository;

    @Inject
    private SiteService siteService;

    @Inject
    private RespondMapper respondMapper;

    public Optional<User> activateRegistration(String key) {
        log.debug("Activating user for activation key {}", key);
        Pageable pageSpecification = new PageRequest(0, 1000);
        userSearchRepository.findByActivationKey(key, pageSpecification).stream()
            .map(user -> {
                // activate given user for the registration key.
                user.setActivated(true);
                user.setActivationKey(null);
                userSearchRepository.save(user);
                log.debug("Activated user: {}", user);
                return user;
            });
        return Optional.empty();
    }

    public Optional<User> completePasswordReset(String newPassword, String key) {
       log.debug("Reset user password for reset key {}", key);

       return userSearchRepository.findByResetKey(key)
           .filter(user -> {
               DateTime oneDayAgo = DateTime.now().minusHours(24);
               return user.getResetDate().isAfter(oneDayAgo.toInstant().getMillis());
           })
           .map(user -> {
               user.setPassword(passwordEncoder.encode(newPassword));
               user.setResetKey(null);
               user.setResetDate(null);
               userSearchRepository.save(user);
               return user;
           });
    }

    public Optional<User> requestPasswordReset(String mail) {
       return userSearchRepository.findByEmail(mail)
           .filter(user -> user.getActivated() == true)
           .map(user -> {
               user.setResetKey(RandomUtil.generateResetKey());
               user.setResetDate(DateTime.now());
               userSearchRepository.save(user);
               return user;
           });
    }

    public User createUserInformation(String login, String password, String firstName, String lastName, String email,
                                      String langKey, boolean activated) {

        User newUser = new User();
        Authority authority = new Authority();
        authority.setName("ROLE_USER");
        Set<Authority> authorities = new HashSet<>();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(login);
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setLangKey(langKey);
        if (activated) {
            newUser.setActivated(true);
        } else {
            // new user is not active
            newUser.setActivated(false);
            // new user gets registration key
            newUser.setActivationKey(RandomUtil.generateActivationKey());
        }
        authorities.add(authority);
        newUser.setAuthorities(authorities);
        newUser.setId(login);
        userSearchRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    public User createUserInformationIfNotExist(String login, String password, String firstName, String lastName, String email,
                                      String langKey, boolean activated) {

        Optional<User> user = loadUserByLogin(login);

        if (user.isPresent()) return user.get();

        return createUserInformation(login, password, firstName, lastName, email, langKey, activated);
    }

    public void updateUserInformation(String firstName, String lastName, String email, String langKey) {
        Optional<User> user = loadUserByLogin();

        user.ifPresent(userToUpdate -> {
            userToUpdate.setFirstName(firstName);
            userToUpdate.setLastName(lastName);
            userToUpdate.setEmail(email);
            userToUpdate.setLangKey(langKey);
            userSearchRepository.save(userToUpdate);
            log.debug("Changed Information for User: {}", userToUpdate);
        });
    }

    public Optional<User> loadUserByLogin() {
        return loadUserByLogin(SecurityUtils.getCurrentLogin());
    }

    public Optional<User> loadUserByLogin(String login) {
        return userSearchRepository.findByLogin(login);
    }

    public List<UsersDto> loadUserBySite(String siteId) {
        Sites site = siteService.loadSiteById(siteId).get();

        final List<UserRole> userRoleList = site.getUserRoleList();
        Map<String, String> userRoleMap = userRoleList.stream().collect(Collectors.toMap(ur->ur.getLogin(), ur->ur.getRole()));
        List<String> loginList = userRoleList.stream().map(ur -> ur.getLogin()).collect(Collectors.toList());

        List<UsersDto> res = new ArrayList<>();
        userSearchRepository.findAll(loginList).forEach(u -> {
            UsersDto usersDto = respondMapper.userToDto(u);
            usersDto.setRole(userRoleMap.get(u.getLogin()));
            usersDto.setPassword(null);
            res.add(usersDto);
        });

        return res;
    }

    public void changePassword(final String password) {
        Optional<User> user = loadUserByLogin();

        user.ifPresent(userToUpdate -> {
            String encryptedPassword = passwordEncoder.encode(password);
            userToUpdate.setPassword(encryptedPassword);
            userSearchRepository.save(userToUpdate);
            log.debug("Changed password for User: {}", userToUpdate);
        });
    }

    @Transactional(readOnly = true)
    public User getUserWithAuthorities() {
        Optional<User> user = loadUserByLogin();
        return user.get();
    }

    /**
     * Not activated users should be automatically deleted after 3 days.
     * <p/>
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     * </p>
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        DateTime now = new DateTime();
        // TODO FEN A implementer....
//        List<User> users = userRepository.findAllByActivatedIsFalseAndCreatedDateBefore(now.minusDays(3));
//        for (User user : users) {
//            log.debug("Deleting not activated user {}", user.getLogin());
//            userRepository.delete(user);
//            userSearchRepository.delete(user);
//        }
    }

    public UsersDto saveLinkExistingUser(String siteId, UserRole userRole) {
        siteService.saveLinkExistingUser(siteId, userRole);
        User user = userSearchRepository.findByEmail(userRole.getLogin()).get();
        return respondMapper.userToDto(user);
    }

}
