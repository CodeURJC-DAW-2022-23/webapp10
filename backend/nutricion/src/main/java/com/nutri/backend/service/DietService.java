package com.nutri.backend.service;

import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Form;
import com.nutri.backend.repositories.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {

    @Autowired
    DietRepository dietRepository;

    public List<Optional<Diet>> findAllDietsByType(String type){
        return dietRepository.findAllByType(type);
    }

    public void save(Diet diet){
        dietRepository.save(diet);
    }

    public List<Diet> findAll(){
        return dietRepository.findAll();
    }

    public Optional<Diet> findByName(String name){
        return dietRepository.findByName(name);
    }

    public Optional<Diet> findByType(String type){
        return dietRepository.findByType(type);
    }

    public int numOfDietsType(String type){
        return dietRepository.numOfDietsType(type);
    }

    public int numOfDiets(){
        return dietRepository.numOfDiets();
    }



    public String dietAlgorithm(Form form) {
        String type="";
        double imc;
        double height=form.getHeight();
        double weight= form.getWeight();

         imc =(weight / (height * height));

        if(imc<18){
            if(form.getDiet().equals("wloss")||form.getInteres().equals("health")){
                type="Maintenence";
            }else if(form.getDiet().equals("wgain")){
                type="Bulking";
            }
        }else if(imc>18 && imc<25){
            if (form.getDiet().equals("wloss")){
                type="Cutting";
            }else if (form.getDiet().equals("wgain")){
                type="Bulking";
            }else{
                type="Maintenence";
            }

        }else if (imc>25){
            if (form.getDiet().equals("wloss")){
                type="Cutting";
            }else if (form.getDiet().equals("wgain")){
                type="Bulking";
            }else{
                type="Maintenence";
            }
        }
        return type;
    }

    public Optional<Diet> findById(Long l) {
        return dietRepository.findById(l);
    }

    public void delete(Long l) {
        dietRepository.deleteById(l);
    }

    public void deleteById(Long id) {
        dietRepository.deleteById(id);
    }
}