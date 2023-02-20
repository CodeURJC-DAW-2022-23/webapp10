package com.nutri.backend.controller;

import com.nutri.backend.model.Diet;
import com.nutri.backend.model.Form;
import com.nutri.backend.model.Triplet;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.repositories.UserRepository;
import com.nutri.backend.service.DietSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ClientController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FormRepository formRep;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DietRepository dietRepository;

	@Autowired
	private DietSearchService dietSearchService;


	@GetMapping("/clientDiets")
	public String diet(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		Optional<Diet> aux=dietRepository.findByName("Bulking");
		Triplet[] dieta=aux.get().getWeek();
		List<String> desayuno=new ArrayList<>();
		List<String> comida=new ArrayList<>();
		List<String> cena=new ArrayList<>();
		for (Triplet dia:dieta){
			desayuno.add((String) dia.Breakfast);
			comida.add((String) dia.Lunch);
			cena.add((String) dia.Dinner);
		}
		model.addAttribute("name", user.getName());
		model.addAttribute("nombreDieta", aux.get().getName());
		model.addAttribute("desayuno",desayuno);
		model.addAttribute("comida",comida);
		model.addAttribute("cena",cena);
		return "USR_ClientDiets";
	}

	@GetMapping("/clientForm")
	public String forms(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		return "USR_ClientForm";
	}
	@GetMapping("/clientRecipes")
	public String recipes(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		return "USR_ClientRecepies";
	}

	@GetMapping("/clientChart")
	public String chart(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		return "USR_ClientCharts";
	}

	@GetMapping("/clientInfo")
	public String showInfo(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		return "USR_ProfileInfoClient";
	}

	@GetMapping("/clientInfoSetting")
	public String editInfo(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		return "USR_ClientEditProfile";
	}

	@PostMapping("/clientFormUpdate")
	public String updateForm(@RequestParam String gensex, @RequestParam String age,@RequestParam String phactivity,
					  @RequestParam int weight,@RequestParam int height, @RequestParam String interest,
					  @RequestParam String aspiration,HttpServletRequest request){
		String dietType;
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		if (user.getForm()==(null)){
			Form newForm = new Form(gensex,age,phactivity,weight,height,interest,aspiration);
			formRep.save(newForm);
			user.setForm(newForm);
			dietType=dietSearchService.dietAlgorithm(newForm);
			Diet diet= dietRepository.findByType(dietType).orElseThrow();
			user.setDiet(diet);
			userRepository.save(user);
		} else{
			Form newF=user.getForm();
			newF.setActivity(phactivity);
			newF.setSex(gensex);
			newF.setAge(age);
			newF.setWeight(weight);
			newF.setHeight(height);
			newF.setInteres(interest);
			newF.setDiet(aspiration);
			dietType=dietSearchService.dietAlgorithm(newF);
			Diet diet= dietRepository.findByType(dietType).orElseThrow();
			user.setDiet(diet);
			userRepository.save(user);
		}
		return "redirect:/clientDiets";
	}
	@GetMapping("/clientProfile")
	public String clientProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("email",user.getEmail());
		return "USR_ClientProfile";
	}
	@GetMapping("/clientEditProfile")
	public String editClientProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("surname",user.getSurname());
		return "USR_ClientEditProfile";
	}

	@PostMapping("/clientEditProfile")
	public String saveClientProfile(@RequestParam String clientName, @RequestParam String clientSurname,
									@RequestParam String clientPassword,@RequestParam String clientPasswordRepeat, HttpServletRequest request) {
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(clientPassword);
		String nameRep = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(nameRep).orElseThrow();
		String name=user.getName();
		String surname=user.getSurname();
		if (!clientPassword.equals(clientPasswordRepeat) && !matcher.matches()){
			return "redirect:/clientProfile";
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
		return "redirect:/clientProfile";
	}


}
