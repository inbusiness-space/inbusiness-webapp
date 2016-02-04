package inbusiness.space.webapp.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Configuration
public class MailConfiguration implements EnvironmentAware {

    private static final String ENV_SPRING_MAIL = "mail.";
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final String PROP_HOST = "host";
    private static final String DEFAULT_PROP_HOST = "localhost";
    private static final String PROP_PORT = "port";
    private static final String PROP_POP_PORT = "pop_port";
    private static final String PROP_USER = "username";
    private static final String PROP_PASSWORD = "password";
    private static final String PROP_PROTO = "protocol";
    private static final String PROP_TLS = "tls";
    private static final String PROP_AUTH = "auth";
    private static final String PROP_SMTP_AUTH = "mail.smtps.auth";
    private static final String PROP_STARTTLS = "mail.smtps.starttls.enable";
    private static final String PROP_TRANSPORT_PROTO = "mail.transport.protocol";

    private final Logger log = LoggerFactory.getLogger(MailConfiguration.class);

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_SPRING_MAIL);
    }

//    @Bean
//    public PopReceiverUtil popReceiver() {
//
//        String host = propertyResolver.getProperty(PROP_HOST, DEFAULT_PROP_HOST);
//        String port = propertyResolver.getProperty(PROP_POP_PORT, "0");
//        String user = propertyResolver.getProperty(PROP_USER);
//        String password = propertyResolver.getProperty(PROP_PASSWORD);
//
//        PopReceiverUtil receiver = new PopReceiverUtil();
//        receiver.setHost(host);
//        receiver.setPort(port);
//        receiver.setUser(user);
//        receiver.setPassword(password);
//
//        return receiver;
//    }

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        log.debug("Configuring mail server");
        String host = propertyResolver.getProperty(PROP_HOST, DEFAULT_PROP_HOST);
        int port = propertyResolver.getProperty(PROP_PORT, Integer.class, 0);
        String user = propertyResolver.getProperty(PROP_USER);
        String password = propertyResolver.getProperty(PROP_PASSWORD);
        String protocol = propertyResolver.getProperty(PROP_PROTO);
        Boolean tls = propertyResolver.getProperty(PROP_TLS, Boolean.class, true);
        Boolean auth = propertyResolver.getProperty(PROP_AUTH, Boolean.class, true);

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        if (host != null && !host.isEmpty()) {
            sender.setHost(host);
        } else {
            log.warn("Warning! Your SMTP server is not configured. We will try to use one on localhost.");
            log.debug("Did you configure your SMTP settings in your application.yml?");
            sender.setHost(DEFAULT_HOST);
        }

        sender.setPort(port);
        sender.setUsername(user);
        sender.setPassword(password);

        Properties sendProperties = new Properties();
        sendProperties.setProperty(PROP_SMTP_AUTH, auth.toString());

        sendProperties.setProperty("mail.smtps.ssl.enable", "true");


        sendProperties.put("mail.smtps.host", host);
        sendProperties.put("mail.smtps.port", "465");
        sendProperties.put("mail.smtps.auth", "true");
        sendProperties.put("mail.smtps.user", user);
        sendProperties.put("mail.transport.protocol", "smtps");
        sendProperties.put("mail.smtps.ssl.enable", "true");


        sender.setProtocol(protocol);
        sendProperties.setProperty(PROP_TRANSPORT_PROTO, protocol);
        sender.setJavaMailProperties(sendProperties);

        Session session = Session.getInstance(sendProperties ,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

        session.setDebug(true);
        sender.setSession(session);



        return sender;
    }
}
