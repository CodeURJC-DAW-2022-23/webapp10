package com.nutri.backend.controller;

import com.nutri.backend.model.Form;
import com.nutri.backend.model.User;
import com.nutri.backend.repositories.FormRepository;
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
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	@GetMapping("/clientDiets")
	public String diet(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
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
		return "USR_ProfileClientEdit";
	}

	@PostMapping("/clientFormUpdate")
	public String updateForm(@RequestParam String gensex, @RequestParam String age,@RequestParam String phactivity,
					  @RequestParam int weight,@RequestParam int height, @RequestParam String interest,
					  @RequestParam String aspiration,HttpServletRequest request){
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		if (user.getForm()==(null)){
			Form newForm = new Form(gensex,age,phactivity,weight,height,interest,aspiration);
			formRep.save(newForm);
			user.setForm(newForm);
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
	@GetMapping("/editProfile")
	public String editClientProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("surname",user.getSurname());
		model.addAttribute("image",user.getImageFile());
		return "USR_ProfileClientEdit";
	}

	@PostMapping("/editProfile")
	public String saveClientProfile(@RequestParam String clientName, @RequestParam String clientSurname,
									@RequestParam String clientPassword, @RequestParam String clientPasswordRepeat,
									@RequestParam MultipartFile image, HttpServletRequest request) throws IOException {
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,40}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(clientPassword);
		String nameRep = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(nameRep).orElseThrow();
		String name=user.getName();
		String surname=user.getSurname();
		URI location = fromCurrentRequest().build().toUri();
		if (!clientPassword.equals(clientPasswordRepeat) && !matcher.matches()){
			return "redirect:/editProfile";
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
		user.setImage(location.toString());
		user.setImageFile(BlobProxy.generateProxy(image.getInputStream(),image.getSize()));
		userRepository.save(user);
		return "redirect:/clientProfile";
	}


}
