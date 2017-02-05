package com.starhub.sites;

import com.starhub.sites.service.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import java.io.File;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
@Configuration
@ComponentScan(basePackageClasses = Application.class)
@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        new File(FileServiceImpl.uploadingdir).mkdirs();
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }
}
