package com.nutri.backend.service;

import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LogingService{
    @Autowired
    private UserRepository userRepository;

}
