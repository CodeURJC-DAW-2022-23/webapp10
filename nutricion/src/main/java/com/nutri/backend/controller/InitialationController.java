package com.nutri.backend.controller;

import com.nutri.backend.model.Form;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.repositories.UserRepository;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


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
		while(userRepository.existsByEmail(email)){
			return "USR_NonRegRegister";
		}
		Calendar c1 = Calendar.getInstance();
		int month =c1.get(Calendar.MONTH) ;
		User user = new User(name,lastName,email,passwordEncoder.encode(password));
		user.setEntryDate(month);
		setUserImage(user,new ClassPathResource("static/images/undraw_profile.jpg").getPath());
		userRepository.save(user);
		return "redirect:/login";
	}

}
