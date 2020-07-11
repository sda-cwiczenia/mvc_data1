package com.sda.mvc_data1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        UserDetails mod = User.withDefaultPasswordEncoder()
                .username("mod")
                .password("mod")
                .roles("MOD")
                .build();
        return new InMemoryUserDetailsManager(admin,mod);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/person-add").hasRole("ADMIN")
                .antMatchers("/person-find").hasAnyRole("MOD", "ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll().defaultSuccessUrl("/welcome")
                .and()
                .logout().permitAll()
                .logoutSuccessUrl("/login")
                .and().csrf().disable();
    }
}
