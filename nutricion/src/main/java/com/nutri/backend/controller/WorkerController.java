package com.nutri.backend.controller;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.RecepyRepository;
import com.nutri.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorkerController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RecepyRepository recepyRepository;

	@GetMapping("/worker")
	public String showWorker(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
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
		//pasarle la info al html
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
		model.addAttribute("name", user.getName());
		model.addAttribute("recepyBreakfast",recepyRepository.findByKindOfRecepy("Breakfast"));
		model.addAttribute("recepyLunch",recepyRepository.findByKindOfRecepy("Lunch"));
		model.addAttribute("recepyDinner",recepyRepository.findByKindOfRecepy("Dinner"));
		return "USR_WorkerViewDiet";
	}
	@GetMapping("/workerProfile")
	public String workerProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		//pasarle la info al html
		return "USR_WorkerProfile";
	}


}
