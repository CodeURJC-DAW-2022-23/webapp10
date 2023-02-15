package com.nutri.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/")
    public String page(HttpServletRequest request) {
        Principal principal= request.getUserPrincipal();
        if (principal!=null){
            if (request.isUserInRole("admin")){
                return "redirect:/admin";
            }else if (request.isUserInRole("client")){
                return "redirect:/clientChart";
            }else if (request.isUserInRole("worker")) {
                return "redirect:/worker";
            }else{
                return null;
            }
        }else
            return "USR_NonReg";
    }
}
