package com.nutri.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkerController {
	@GetMapping("/workerDiets")
	public String diets() {
		return "USR_WorkerDiets";
	}

	@GetMapping("/workerUploadDiets")
	public String uploadDiets() {
		return "USR_WorkerUploadDiets";
	}

	@GetMapping("/workerUploadRecipes")
	public String uploadRecipes() {
		return "USR_WorkerUploadRecipes";
	}

	@GetMapping("/viewRecipe")
	public String viewRecipe() {
		return "USR_WorkerViewRecipe";
	}

	@GetMapping("/viewDiet")
	public String viewDiet() {
		return "USR_WorkerViewDiet";
	}

}
