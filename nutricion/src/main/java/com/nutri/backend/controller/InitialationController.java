package com.nutri.backend.controller;

import com.nutri.backend.model.Form;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.repositories.UserRepository;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class InitialationController {

	@Autowired
	private FormRepository formRep;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String loggingTem() {
		return "USR_NonRegLogin";
	}

	@GetMapping("/loginError")
	public String loggingErrorTem() {
		return "USR_NonRegLoginError";
	}

	@GetMapping("/register")
	public String registerTem() {
		return "USR_NonRegRegister";
	}
	@GetMapping("/404")
	public String error404() {
		return "404";
	}
	@GetMapping("/403")
	public String error403() {
		return "403";
	}
	@GetMapping("/500")
	public String error500() {
		return "500";
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
						  @RequestParam String password, @RequestParam String passwordRepeat){
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(password);
		while (!password.equals(passwordRepeat) && !matcher.matches()){
			return "USR_NonRegRegister";
		}
		while(userRepository.existsByEmail(email)){
			return "USR_NonRegRegister";
		}
		Calendar c1 = Calendar.getInstance();
		int month =c1.get(Calendar.MONTH) ;
		User user = new User(name,lastName,email,passwordEncoder.encode(password));
		user.setEntryDate(month);
		userRepository.save(user);
		return "redirect:/login";
	}

}
