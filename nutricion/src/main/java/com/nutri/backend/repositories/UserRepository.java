package com.nutri.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.backend.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
