package com.nutri.backend.controller;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;


@Controller
public class InitialationController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String page() {
		return "USR_NonReg";
	}

	@GetMapping("/login")
	public String loggingTem() {
		return "USR_NonRegLogin";
	}

	@GetMapping("/register")
	public String registerTem() {
		return "USR_NonRegRegister";
	}

	@GetMapping("/cliente")
	public String client() {
		return "USR_ClientDiets";
	}

	@GetMapping("/test")
	public String testTem() {
		return "USR_NonRegForm";
	}

	@GetMapping("/newUser")
	public String signin(Model model){return "USR_NonRegRegister";}

	@PostMapping("/newUser")
	public String addNewUser(@RequestParam String name,@RequestParam String lastName,@RequestParam String email,
							 @RequestParam String password){
		User user= new User(name,lastName,email,passwordEncoder.encode(password));
		userRepository.save(user);

		return "USR_NonRegLogin";
	}

}
