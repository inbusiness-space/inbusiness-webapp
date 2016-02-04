package inbusiness.space.webapp.repository;


import inbusiness.space.webapp.domain.User;
import org.joda.time.DateTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data ElasticSearch repository for the User entity.
 */
public interface UserSearchRepository extends MongoRepository<User, String> {
    List<User> findByActivationKey(String activationKey, Pageable pageable);

    List<User> findAllByActivatedIsFalseAndCreatedDateBefore(DateTime dateTime, Pageable pageable);

    Optional<User> findByResetKey(String resetKey);

    Optional<User> findByEmail(String email);

    Optional<User> findByLogin(String login);

}
