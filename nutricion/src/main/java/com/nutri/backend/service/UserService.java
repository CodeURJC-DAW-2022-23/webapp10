package com.nutri.backend.service;


import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Page<User> findPageClient(int page, String s){
        return userRepository.findByUserType(PageRequest.of(page, 6), s);
    }


}
