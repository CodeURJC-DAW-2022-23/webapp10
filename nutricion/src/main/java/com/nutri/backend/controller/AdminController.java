package com.nutri.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String showAdmin( HttpServletRequest request) {
		return "USR_Admin";
	}

	@GetMapping("/adminCharts")
	public String showCharts() {
		return "USR_AdminCharts";
	}

	@GetMapping("/tablesClient")
	public String showClients() {
		return "USR_AdminClientTable";
	}

	@GetMapping("/profileInfo")
	public String showProfile() {
		return "USR_ProfileInfoAdmin";
	}

	@GetMapping("/workerTable")
	public String workers() {
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

}
