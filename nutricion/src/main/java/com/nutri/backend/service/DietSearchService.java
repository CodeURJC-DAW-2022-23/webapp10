package com.nutri.backend.service;

import com.nutri.backend.model.Form;
import com.nutri.backend.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.From;

@Service
public class DietSearchService {


    public String dietAlgorithm(Form form) {
        String type="";

        int height=form.getHeight();
        int weight= form.getWeight();

        int imc =weight / (height * height);

        if(imc<18){
            if(form.getInteres().equals("wloss")||form.getInteres().equals("health")){
                type="Maintenence";
            }else if(form.getInteres().equals("wgain")){
                type="Bulking";
            }
        }else if(imc>18 && imc<25){
            if (form.getInteres().equals("wloss")){
                type="Cutting";
            }else if (form.getInteres().equals("wgain")){
                type="Bulking";
            }else{
                type="Mantenaince";
            }

        }else if (imc>25){
            if (form.getInteres().equals("wloss")){
                type="Cutting";
            }else if (form.getInteres().equals("wgain")){
                type="Bulking";
            }else{
                type="Mantenaince";
            }
        }
        return type;
    }
}