package com.nutri.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class DataSampleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        this.userRepository.save(new User("ejemplo@yahoo.es",passwordEncoder.encode("1234")));
        this.userRepository.save(new User("Adrian","Garcia","ejemploworker@yahoo.es","Expert",passwordEncoder.encode("1234")));
        this.userRepository.save(new User("Juan","Perez","ejemploclient@yahoo.es",passwordEncoder.encode("1234")));
    }

}
