package com.nutri.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/")
    public String page(HttpServletRequest request) {
        Principal principal= request.getUserPrincipal();
        if (principal!=null){
            if (request.isUserInRole("ADMIN")){
                return "redirect:/admin";
            }else if (request.isUserInRole("CLIENT")){
                return "redirect:/clientChart";
            }else{return "redirect:/worker";}
        }else
            return "USR_NonReg";
    }
}
