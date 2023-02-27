package com.nutri.backend.controller;

import com.nutri.backend.model.*;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.FormRepository;
import com.nutri.backend.repositories.RecepyRepository;
import com.nutri.backend.repositories.UserRepository;
import com.nutri.backend.service.DietService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Controller
public class ClientController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FormRepository formRep;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RecepyRepository recepyRepository;

	@Autowired
	private DietRepository dietRepository;

	@Autowired
	private DietService dietService;

	//User Diets and Recepies controller
	@GetMapping("/clientDiets")
	public String diet(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		Optional<Diet> diet= Optional.ofNullable(user.getDiet());//user.getDiet()
		//aqui habra que cambiarlo por que le de la dieta que tenga el cliente inscrito
		if(diet.isPresent()) {
			Triplet[] diet1 = diet.get().getWeek();
			List<String> breakfast = new ArrayList<>();
			List<String> lunch = new ArrayList<>();
			List<String> dinner = new ArrayList<>();
			for (Triplet day : diet1) {
				breakfast.add((String) day.Breakfast);
				lunch.add((String) day.Lunch);
				dinner.add((String) day.Dinner);
			}
			model.addAttribute("name", user.getName());
			model.addAttribute("nd", diet.get().getName());
			model.addAttribute("br", breakfast);
			model.addAttribute("ln", lunch);
			model.addAttribute("dn", dinner);
			model.addAttribute("id", user.getId());
			return "USR_ClientDiets";
		}
		return "USR_ClientDiets";
	}
	@GetMapping("/clientRecipes")
	public String recipes(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("id",user.getId());
		List<Recepy> recepies = new ArrayList<>();
		Diet diet = user.getDiet();
		Triplet[] diet1 = diet.getWeek();
		for (Triplet aux : diet1){
			Recepy recepy = recepyRepository.findByName((String)aux.Breakfast).orElseThrow();
			recepies.add(recepy);
			Recepy recepy1 = recepyRepository.findByName((String)aux.Lunch).orElseThrow();
			recepies.add(recepy1);
			Recepy recepy2 = recepyRepository.findByName((String)aux.Dinner).orElseThrow();
			recepies.add(recepy2);
		}
		Collections.shuffle(recepies);
		model.addAttribute("recepies",recepies);
		return "USR_ClientRecepies";
	}


	//Client Chart controller

	@GetMapping("/clientChart")
	public String chart(Model model, HttpServletRequest request, HttpServletResponse response) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("id",user.getId());
		Cookie[] cookies = request.getCookies();
		String formId = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("formId"))
				formId = cookie.getValue();
		}
		Cookie userNameCookieRemove = new Cookie("formId", "");
		userNameCookieRemove.setMaxAge(0);
		response.addCookie(userNameCookieRemove);
		if (formId != null) {
			Long id = Long.parseLong(formId);
			Form form = formRep.findById(id).orElseThrow();
			user.setForm(form);
			userRepository.save(user);
		}
		return "USR_ClientCharts";
	}


	//Formulary controller
	@GetMapping("/clientForm")
	public String forms(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("id",user.getId());
		return "USR_ClientForm";
	}

	@PostMapping("/clientFormUpdate")
	public String updateForm(@RequestParam String gensex, @RequestParam String age,@RequestParam String phactivity,
					  @RequestParam String weight,@RequestParam String height, @RequestParam String interest,
					  @RequestParam String aspiration,HttpServletRequest request){
		double weight1=Double.parseDouble(weight);
		double height1=Double.parseDouble(height);
		String dietType;
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		if (user.getForm()==(null)){
			Form newForm = new Form(gensex,age,phactivity,weight1,height1,interest,aspiration);
			formRep.save(newForm);
			user.setForm(newForm);
			dietType= dietService.dietAlgorithm(newForm);
			List<Optional<Diet>> diets= dietService.findAllDietsByType(dietType);
			Collections.shuffle(diets);
			user.setDiet(diets.get(0).orElseThrow());
			userRepository.save(user);
		} else{
			Form newF=user.getForm();
			newF.setActivity(phactivity);
			newF.setSex(gensex);
			newF.setAge(age);
			newF.setWeight(weight1);
			newF.setHeight(height1);
			newF.setInteres(interest);
			newF.setDiet(aspiration);
			dietType= dietService.dietAlgorithm(newF);
			Diet diet= dietRepository.findByType(dietType).orElseThrow();
			user.setDiet(diet);
			userRepository.save(user);
		}
		return "redirect:/clientDiets";
	}

	//Client Profile controller

	@GetMapping("/clientInfo")
	public String showInfo(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("id",user.getId());
		return "USR_ProfileInfoClient";
	}

	@GetMapping("/clientInfoSetting")
	public String editInfo(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("id",user.getId());
		return "USR_ClientEditProfile";
	}

	@GetMapping("/clientProfile")
	public String clientProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("email",user.getEmail());
		model.addAttribute("id",user.getId());
		return "USR_ClientProfile";
	}
	@GetMapping("/clientEditProfile")
	public String editClientProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("surname",user.getSurname());
		model.addAttribute("id",user.getId());
		return "USR_ClientEditProfile";
	}

	@PostMapping("/clientEditProfile")
	public String saveClientProfile(@RequestParam String clientName, @RequestParam String clientSurname,
									@RequestParam String clientPassword, @RequestParam String clientPasswordRepeat,
									@RequestParam (name = "clientImage", required = false) MultipartFile clientImage,
									HttpServletRequest request) throws IOException {
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(clientPassword);
		String nameRep = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(nameRep).orElseThrow();
		String name=user.getName();
		String surname=user.getSurname();
		if (!clientPassword.equals(clientPasswordRepeat) && !matcher.matches()){
			return "USR_ClientProfile";
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
			if (!clientImage.isEmpty()){
				URI location = fromCurrentRequest().build().toUri();
				user.setImage(location.toString());
				user.setImageFile(BlobProxy.generateProxy(clientImage.getInputStream(), clientImage.getSize()));
			}
		}
		userRepository.save(user);
		return "redirect:/clientEditProfile";
	}

}
