package com.nutri.backend.controller;

import com.nutri.backend.model.User;
import com.nutri.backend.repositories.UserRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

	@Autowired
	private PasswordEncoder passwordEncoder;

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

	//Chart controller
	@GetMapping("/chatInformation")
	public String updateCharts(Model model, HttpServletRequest request){
		int count;
		int month;
		for (int i=0;i<12;i+=1){
			month=userRepository.findByEntryDate(i);
		}


		return "USR_AdminCharts";
	}



	//Worker Administration Controller
	@GetMapping("/workerTable")
	public String workers(Model model) {
		model.addAttribute("workers",userRepository.findByUserType("worker"));
		return "USR_AdminWorkerTable";
	}

	@PostMapping("/deleteWorker")
	public String deleteWorker(Model model,@RequestParam List<Long> id){
		if(id != null) {
			for (Long l : id) {
				userRepository.deleteById(l);
			}
		}
		return "redirect:/workerTable";
	}

	@GetMapping("/addWorker")
	public String showAddWorkersForm() {

		return "USR_AdminAddWorker";
	}
	@PostMapping("/addWorker")
	public String addWorker(@RequestParam String workerName,@RequestParam String workerLastname,@RequestParam String workerEmail
			,@RequestParam String workerPassword,@RequestParam String workerDescription) {
		Calendar c1 = Calendar.getInstance();
		int month =c1.get(Calendar.MONTH) ;
		User user = new User(workerName,workerLastname,workerEmail,workerDescription,passwordEncoder.encode(workerPassword));
		user.setEntryDate(month);
		userRepository.save(user);
		return "redirect:/workerTable";
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
