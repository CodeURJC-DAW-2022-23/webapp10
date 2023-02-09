package com.nutri.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class DataSampleService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {

        this.userRepository.save(new User("ejemplo@yahoo.es","1234"));
        this.userRepository.save(new User("Juan","Perez","ejemploworker@yahoo.es","1234"));
    }

}
