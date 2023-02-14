package com.nutri.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findByUserType(String userType);
    boolean existsByEmail(String foo);

}
