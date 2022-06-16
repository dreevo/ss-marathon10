package com.dreevo.ssmarathon10as.services;

import com.dreevo.ssmarathon10as.models.SecurityUser;
import com.dreevo.ssmarathon10as.models.User;
import com.dreevo.ssmarathon10as.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class JdbcUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUsername(s);
        if(user.isPresent()){
            return new SecurityUser(user.get());
        }else{
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
