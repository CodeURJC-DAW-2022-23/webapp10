package com.nutri.backend.controller;

import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Triplet;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.RecepyRepository;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.util.List;

@Controller
public class WorkerController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RecepyRepository recepyRepository;

	@Autowired
	private DietRepository dietRepository;

	@GetMapping("/worker")
	public String showWorker(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("client",userRepository.findByUserType("client"));

		return "USR_Worker";
	}
	@GetMapping("/workerDiets")
	public String workerDiets(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		//pasarle la info al html
		return "USR_WorkerDiets";
	}
	
	@GetMapping("/workerUploadDiets")
	public String workerUploadDiets(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("recepyBreakfast",recepyRepository.findByKindOfRecepy("Breakfast"));
		model.addAttribute("recepyLunch",recepyRepository.findByKindOfRecepy("Lunch"));
		model.addAttribute("recepyDinner",recepyRepository.findByKindOfRecepy("Dinner"));
		return "USR_WorkerUploadDiets";
	}
	
	@GetMapping("/workerUploadRecipes")
	public String workerUploadRecipes(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		//pasarle la info al html
		return "USR_WorkerUploadRecipes";
	}
	@GetMapping("/viewRecipe")
	public String viewRecipe(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("recepy",recepyRepository.findAll());
		return "USR_WorkerViewRecipe";
	}
	@GetMapping("/viewDiet")
	public String viewDiet(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		List<Diet> dietas=dietRepository.findAll();
		List<String> nombres=dietRepository.findOnlyName();
		List<String> auxTriplete= new ArrayList<>();
		for (Diet dieta:dietas){
			auxTriplete.add(dieta.printWeek(dieta.getWeek()));
		}
		model.addAttribute("name", user.getName());
		model.addAttribute("diet",nombres);
		model.addAttribute("week",auxTriplete);
		return "USR_WorkerViewDiet";
	}
	@GetMapping("/workerProfile")
	public String workerProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("email",user.getEmail());
		//pasarle la info al html
		return "USR_WorkerProfile";
	}
	@GetMapping("/workerEditProfile")
	public String workerEditProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("surname",user.getSurname());
		//pasarle la info al html
		return "USR_WorkerEditProfile";
	}
	@PostMapping("/workerEditProfile")
	public String saveClientProfile(@RequestParam String clientName, @RequestParam String clientSurname,
									@RequestParam String clientPassword, @RequestParam String clientPasswordRepeat, HttpServletRequest request) {
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(clientPassword);
		String nameRep = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(nameRep).orElseThrow();
		String name=user.getName();
		String surname=user.getSurname();
		if (!clientPassword.equals(clientPasswordRepeat) && !matcher.matches()){
			return "redirect:/workerProfile";
		}else{
			if (clientName!=null && !clientName.equals("")){
				user.setName(clientName);
			}else{
				user.setName(name);
			}
			if (clientSurname!=null && !clientSurname.equals("")){
				user.setSurname(clientSurname);
			}else{
				user.setSurname(surname);
			}
			user.setEncodedPassword(passwordEncoder.encode(clientPassword));
		}
		userRepository.save(user);
		return "redirect:/workerProfile";
	}
}
