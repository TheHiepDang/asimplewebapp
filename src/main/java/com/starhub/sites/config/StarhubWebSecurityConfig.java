package com.starhub.sites.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class StarhubWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private LogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/").hasRole("ADMIN")
                .antMatchers("/api/starhub/checkAuth").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/starhub/authenticate")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("password").roles("USER", "ADMIN").and()
                .withUser("user").password("password").roles("USER");
    }
}
