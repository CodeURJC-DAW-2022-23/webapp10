package com.nutri.backend.service;


import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Page<User> findPageClient(int page, String s){return userRepository.findByUserType(PageRequest.of(page, 6), s);}

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }

    public User save (User ex){
        return userRepository.save(ex);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean existByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public int findByEntryDate(int date){
        return userRepository.findByEntryDate(date);
    }

    public int findAllByUser(String type){
        return userRepository.findAllByuser(type);
    }

    public int finAllByUserMonth(String type,int date){
        return userRepository.findAllByUserMonth(type,date);
    }



}
