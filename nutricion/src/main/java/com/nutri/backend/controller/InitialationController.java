package com.nutri.backend.controller;

import com.nutri.backend.model.Form;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class InitialationController {

	@Autowired
	private FormRepository formRep;

	@Autowired
	private UserRepository userRepository;

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

	@PostMapping("/usrTest")
	public String formInfoUpdate(@RequestParam String gensex, @RequestParam String age,@RequestParam String phactivity,
								 @RequestParam int weight,@RequestParam int height, @RequestParam String interest,
								 @RequestParam String aspiration){
		Form newForm = new Form(gensex,age,phactivity,weight,height,interest,aspiration);
		formRep.save(newForm);
		return "redirect:/login";
	}
	@PostMapping("/addUser")
	public String newUser(@RequestParam String name,@RequestParam String lastName, @RequestParam String email,
						  @RequestParam String password){
		User user = new User(name,lastName,email,password);
		userRepository.save(user);
		return "redirect:/login";
	}

}
