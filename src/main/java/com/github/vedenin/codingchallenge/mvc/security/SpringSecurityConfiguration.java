package com.github.vedenin.codingchallenge.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.activation.DataSource;
import javax.inject.Inject;

import static com.github.vedenin.codingchallenge.mvc.Consts.*;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Inject
    ConverterUserDetailsServices converterUserDetailsServices;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/" + LOGIN_URL, "/" + REGISTER_URL, "/rest/*").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/" + LOGIN_URL)
                .successForwardUrl("/" + CONVERTER_URL)
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(converterUserDetailsServices);
    }
}
