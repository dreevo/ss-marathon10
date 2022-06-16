package com.dreevo.ssmarathon10as.repositories;

import com.dreevo.ssmarathon10as.models.SecurityUser;
import com.dreevo.ssmarathon10as.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUsername(String username);
}
