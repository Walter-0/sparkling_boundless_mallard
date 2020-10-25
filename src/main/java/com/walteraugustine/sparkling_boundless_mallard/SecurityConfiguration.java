package com.walteraugustine.sparkling_boundless_mallard;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity)((HttpSecurity)((AuthorizedUrl)http.authorizeRequests()
                .anyRequest())
                .authenticated()
                .and())
                .oauth2Login()
                .and())
                .oauth2ResourceServer()
                .jwt();
    }
}
