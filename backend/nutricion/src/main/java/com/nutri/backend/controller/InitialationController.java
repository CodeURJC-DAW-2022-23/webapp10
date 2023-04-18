package com.nutri.backend.controller;

import com.nutri.backend.model.Form;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.service.UserService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class InitialationController {

	@Autowired
	private FormRepository formRep;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String loggingTem() {
		return "USR_NonRegLogin";
	}

	@GetMapping("/loginError")
	public String loggingErrorTem() {
			return "/login";
	}

	@GetMapping("/register")
	public String registerTem() {
		return "USR_NonRegRegister";
	}



	@GetMapping("/test")
	public String testTem() {
		return "USR_NonRegForm";
	}

	@PostMapping("/usrTest")
	public String formInfoUpdate(@RequestParam String gensex, @RequestParam String age, @RequestParam String phactivity,
								 @RequestParam double weight, @RequestParam double height, @RequestParam String interest,
								 @RequestParam String aspiration, HttpServletRequest request, HttpServletResponse response){
		Form newForm = new Form(gensex,age,phactivity,weight,height,interest,aspiration);
		formRep.save(newForm);
		String id =String.valueOf(newForm.getId());
		Cookie formId = new Cookie("formId",id);
		formId.setMaxAge(60*60);
		response.addCookie(formId);
		return "redirect:/register";
	}
	private void setUserImage(User user, String classpathResource){
		try {
			Resource image = new ClassPathResource(classpathResource);
			user.setImage("Default");
			user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
		} catch(Exception e){

		}
	}

	@PostMapping("/addUser")
	public String newUser(@RequestParam String name,@RequestParam String lastName, @RequestParam String email,
						  @RequestParam String password, @RequestParam String passwordRepeat) throws IOException {
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(password);
		while (!password.equals(passwordRepeat) && !matcher.matches()){
			return "USR_NonRegRegister";
		}
		while(userService.existByEmail(email)){
			return "USR_NonRegRegister";
		}
		Calendar c1 = Calendar.getInstance();
		int month =c1.get(Calendar.MONTH) ;
		User user = new User(name,lastName,email,passwordEncoder.encode(password));
		user.setEntryDate(month);
		setUserImage(user,new ClassPathResource("static/images/undraw_profile.jpg").getPath());
		userService.save(user);
		return "redirect:/login";
	}

}
