package com.dreevo.ssmarathon10as;

import com.dreevo.ssmarathon10as.models.SecurityUser;
import com.dreevo.ssmarathon10as.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class SsMarathon10AsApplication implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private JdbcUserDetailsManager jdbcUserDetailsManager;

    public static void main(String[] args) {
        SpringApplication.run(SsMarathon10AsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        SecurityUser user = SecurityUser.builder()
//                .user(new User("0","dreevo", passwordEncoder.encode("1234")))
//                .build();
//        jdbcUserDetailsManager.createUser(user);
    }
}
