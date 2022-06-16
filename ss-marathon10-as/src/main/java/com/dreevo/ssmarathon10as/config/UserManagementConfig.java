package com.dreevo.ssmarathon10as.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserManagementConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }

//    @Bean
//    public JdbcUserDetailsManager jdbcUserDetailsManager() {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        var udm = new InMemoryUserDetailsManager();
        var user = User.withUsername("dreevo")
                .password(passwordEncoder().encode("1234")).authorities("read").build();
        udm.createUser(user);
        return udm;
    }
}