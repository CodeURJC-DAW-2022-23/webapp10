package com.nutri.backend.controller;

import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Recepy;
import com.nutri.backend.model.Triplet;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.RecepyRepository;
import com.nutri.backend.repositories.UserRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
		model.addAttribute("image",user.getImage());
		return "USR_Worker";
	}
	@GetMapping("/workerDiets")
	public String workerDiets(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("client",userRepository.findByUserType("client"));
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
	@PostMapping("/workerUploadDiets")
	public String workerUploadRecipes(Model model, HttpServletRequest request, @RequestParam String nombre,
									@RequestParam String brmon,@RequestParam String brtue,
									@RequestParam String brwed,@RequestParam String brthr,@RequestParam String brfri,
									@RequestParam String brsat,@RequestParam String brsun,
									@RequestParam String lunmon,@RequestParam String luntue,
									@RequestParam String lunwed,@RequestParam String lunthr,@RequestParam String lunfri,
									@RequestParam String lunsat,@RequestParam String lunsun,
									@RequestParam String dinmon,@RequestParam String dintue,
									@RequestParam String dinwed,@RequestParam String dinthr,@RequestParam String dinfri,
									@RequestParam String dinsat,@RequestParam String dinsun,
									@RequestParam String type_diet) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		String[] desayunos={brmon,brtue,brwed,brthr,brfri,brsat,brsun};
		String[] comidas={lunmon,luntue,lunwed,lunthr,lunfri,lunsat,lunsun};
		String[] cenas={dinmon,dintue,dinwed,dinthr,dinfri,dinsat,dinsun};
		System.out.println(desayunos);
		Triplet week[]=new Triplet[7];
		for (int aux=0;aux<week.length;aux++){
			week[aux]=new Triplet(null,null,null);
			if (desayunos[aux]!=null) {
				week[aux].Breakfast=desayunos[aux];
			} else{
				week[aux].Breakfast="Nada";
			}
			if (comidas[aux]!=null) {
				week[aux].Lunch=comidas[aux];
			} else{
				week[aux].Lunch="Nada";
			}
			if (cenas[aux]!=null) {
				week[aux].Dinner=cenas[aux];
			} else{
				week[aux].Dinner="Nada";
			}
		}
		Diet dieta=new Diet(nombre,week,type_diet);
		dietRepository.save(dieta);
		model.addAttribute("name", user.getName());
		return "redirect:/viewDiet";
	}

	@GetMapping("/viewRecipe")
	public String viewRecipe(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("recepy",recepyRepository.findAll());
		return "USR_WorkerViewRecipe";
	}
	@GetMapping("/workerUploadRecipes")
	public String workerUploadRecepies(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		return "USR_WorkerUploadRecipes";
	}
	@PostMapping("/workerUploadRecipes")
	public String workerUploadRecepiesToDB(Model model, HttpServletRequest request,@RequestParam String recipe,
										   @RequestParam String steps,@RequestParam String recipetype,
										   @RequestParam String image) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		Recepy recetaAux=null;
		if (image.equals("null")){
			recetaAux=new Recepy(recipe,"",steps,recipetype);
		}else{
			recetaAux=new Recepy(recipe,"",steps,recipetype);
		}
		recepyRepository.save(recetaAux);
		return "redirect:/viewRecipe";
	}
	@GetMapping("/viewDiet")
	public String viewDiet(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		List<Diet> dietas=dietRepository.findAll();
		Map<String,String> tupla= new HashMap<>();
		for (Diet dieta:dietas){
			tupla.put(dieta.getName(),dieta.printWeek(dieta.getWeek()));
		}
		model.addAttribute("name", user.getName());
		model.addAttribute("dieta",tupla);
		return "USR_WorkerViewDiet";
	}
	@GetMapping("/workerProfile")
	public String workerProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("user", user);
		//pasarle la info al html
		return "USR_WorkerProfile";
	}
	@GetMapping("/workerEditProfile")
	public String workerEditProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("surname",user.getSurname());
		if (user.hasImage()){
			model.addAttribute("image",user.getImage());
		}

		//pasarle la info al html
		return "USR_WorkerEditProfile";
	}
	@PostMapping("/workerEditProfile")
	public String saveClientProfile(@RequestParam String clientName, @RequestParam String clientSurname,
									@RequestParam String clientPassword, @RequestParam String clientPasswordRepeat,
									@RequestParam (name = "clientImage", required = false) MultipartFile image,
									HttpServletRequest request) throws IOException{
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
			if (!image.isEmpty())
				user.setImage(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
			user.setEncodedPassword(passwordEncoder.encode(clientPassword));
		}
		userRepository.save(user);
		return "redirect:/workerProfile";
	}
}
