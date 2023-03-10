package com.nutri.backend.service;


import com.nutri.backend.model.Diet;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DietService dietService;

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

    public List<User> findByUserType(String type){
        return userRepository.findByUserType(type);
    }


    //Admin services
    public HashMap<Integer,Integer> statisticsUserByMont(){
        HashMap<Integer,Integer> list = new HashMap<>(12);
        for(int i=0; i<12; i++){
           list.put(i,userRepository.findByEntryDate(i));
        }
        return list;
    }
    public HashMap<String,Integer>statisticsDiets(){
        String [] typesOfDiets={"Bulking","Cutting","Maintenence"};
        HashMap<String,Integer> diets= new HashMap<>(3);
        for(String type: typesOfDiets){
            diets.put(type,dietService.numOfDietsType(type));
        }
        return diets ;
    }

    public HashMap<Integer,Integer> statisticsEarnsByMonth(){
        HashMap<Integer,Integer> list = new HashMap<>(12);
        for(int i=0; i<12; i++){
            list.put(i,userRepository.findAllByUserMonth("client",i)*9);
        }
        return list;
    }
    public HashMap<String ,Integer> statisticsRecepiesDownloaded(HttpServletRequest request){
        User user = userRepository.findByEmail(request.getUserPrincipal().getName()).orElseThrow();
        String[] recepiesType= {"BreakFast","Lunch","Dinner"};
        HashMap<String,Integer> list = new HashMap<>(12);
        list.put("Breakfast",user.getbCounter());
        list.put("Lunch",user.getlCounter());
        list.put("Dinner",user.getdCounter());
        return list;
    }






}
