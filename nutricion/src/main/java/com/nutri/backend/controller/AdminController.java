package com.nutri.backend.controller;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/admin")
	public String showAdmin( HttpServletRequest request) {
		return "USR_Admin";
	}

	@GetMapping("/adminCharts")
	public String showCharts() {
		return "USR_AdminCharts";
	}



	@GetMapping("/profileInfo")
	public String showProfile() {
		return "USR_ProfileInfoAdmin";
	}

	@GetMapping("/workerTable")
	public String workers(Model model) {

		return "USR_AdminWorkerTable";
	}

	@GetMapping("/addWorker")
	public String addWorkers() {
		return "USR_AdminAddWorker";
	}
	@GetMapping("/dietTable")
	public String dietTable() {
		return "USR_AdminDietTable";
	}
	@GetMapping("/editDiet")
	public String editDiet() {
		return "USR_AdminEditDiet";
	}
	@GetMapping("/editProfile")
	public String editProfile() {
		return "USR_editProfile";
	}

	//***Client Administration***
	@GetMapping("/tablesClient")
	public String showClients(Model model) {
		model.addAttribute("clients",userRepository.findByUserType("client"));
		return "USR_AdminClientTable";
	}
	@PostMapping("/deleteClient")
	public String deleteUser(Model model, @RequestParam(required = false) List<Long> id){
		if(id != null) {
			for (Long l : id) {
				userRepository.deleteById(l);
			}
		}
		return "redirect:/tablesClient";
	}



}
