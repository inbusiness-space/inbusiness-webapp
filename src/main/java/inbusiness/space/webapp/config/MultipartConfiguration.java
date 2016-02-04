package inbusiness.space.webapp.config;


import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

@Configuration
public class MultipartConfiguration  {

    @Resource
    private Environment environment;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(environment.getProperty("multipart.maxFileSize"));
        factory.setMaxRequestSize(environment.getProperty("multipart.maxRequestSize"));
        return factory.createMultipartConfig();
    }
}
