package com.nutri.backend.controller;

import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FormRepository formRepository;

    @GetMapping("/")
    public String page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal principal= request.getUserPrincipal();
        if (principal!=null){
            if (request.isUserInRole("admin")){
                return "redirect:/admin";
            }else if (request.isUserInRole("client")){
                return "redirect:/clientDiets";
            }else if (request.isUserInRole("worker")) {
                return "redirect:/worker";
            }else{
                return null;
            }
        }else
            return "USR_NonReg";
    }
}
