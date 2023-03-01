package com.nutri.backend.controller;

import com.nutri.backend.model.*;
import com.nutri.backend.repositories.DietRepository;
import com.nutri.backend.repositories.RecepyRepository;
import com.nutri.backend.repositories.UserRepository;
import com.nutri.backend.service.RecepyService;
import com.nutri.backend.service.UserService;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@Controller
public class WorkerController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RecepyService recepyService;
	@Autowired
	private UserService userService;
	@Autowired
	private RecepyRepository recepyRepository;
	@Autowired
	private DietRepository dietRepository;


	@GetMapping("/worker")
	public String showWorker(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		Page<User> clientPage = userService.findPageClient(0, "client");
		model.addAttribute("name", user.getName());
		model.addAttribute("clientPage",clientPage.toList());
		model.addAttribute("last",clientPage.getTotalPages());
		model.addAttribute("id", user.getId());
		return "USR_Worker";
	}

	@GetMapping("/worker/page/{page}")
	public String getWorkerPage(Model model, @PathVariable int page) {
		Page<User> client = userService.findPageClient(page, "client");
		List<User> users = client.toList();
		model.addAttribute("client", users);

		return "USR_WorkerClientTableAjax";

	}

	@GetMapping("/viewRecipe")
	public String viewRecipe(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		Page<Recepy> recepiesPage = recepyService.getPageOfRecepies(0) ;
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("recepy",recepiesPage.toList());
		model.addAttribute("last",recepiesPage.getTotalPages());
		model.addAttribute("id", user.getId());
		return "USR_WorkerViewRecipe";
	}

	@GetMapping("/workerRecepiesTable/page/{page}")
	public String getRecepiesTable(Model model, @PathVariable int page) {
		Page<Recepy> recepie =recepyService.getPageOfRecepies(page);
		model.addAttribute("recepy", recepie.toList());

		return "USR_WorkerRecepiesTableAjax";

	}

	@GetMapping("/workerDiets")
	public String workerDiets(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		Page<User> clientPage = userService.findPageClient(0, "worker");
		model.addAttribute("name", user.getName());
		model.addAttribute("client",userRepository.findByUserType("client"));
		model.addAttribute("id", user.getId());
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
		model.addAttribute("id", user.getId());
		return "USR_WorkerUploadDiets";
	}
	@PostMapping("/workerUploadDiets")
	public String workerUploadRecipes(Model model, HttpServletRequest request, @RequestParam String name1,
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
		Diet dieta=new Diet(name1,week,type_diet);
		dietRepository.save(dieta);
		model.addAttribute("name", user.getName());
		model.addAttribute("id", user.getId());
		return "redirect:/viewDiet";
	}


	@GetMapping("/workerUploadRecipes")
	public String workerUploadRecepies(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("id", user.getId());
		return "USR_WorkerUploadRecipes";
	}
	@PostMapping("/workerUploadRecipes")
	public String workerUploadRecepiesToDB(Model model, HttpServletRequest request,@RequestParam String recipe,
										   @RequestParam String ingredients,
										   @RequestParam String steps,@RequestParam String recipetype,
										   @RequestParam (name = "image", required = false) MultipartFile image) throws IOException {
		Recepy recetaAux=new Recepy();
		if (!image.isEmpty()){
			URI location = fromCurrentRequest().build().toUri();
			recetaAux.setImage(location.toString());
			recetaAux.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.getSize()));
		}
		recetaAux.setDescription(steps);
		recetaAux.setName(recipe);
		recetaAux.setIngredients(ingredients);
		recetaAux.setKindOfRecepy(recipetype);
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
		model.addAttribute("id", user.getId());
		return "USR_WorkerViewDiet";
	}
	@GetMapping("/workerProfile")
	public String workerProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("user", user);
		model.addAttribute("id", user.getId());
		//pasarle la info al html
		return "USR_WorkerProfile";
	}
	@GetMapping("/workerEditProfile")
	public String workerEditProfile(Model model, HttpServletRequest request) {
		String name = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(name).orElseThrow();
		model.addAttribute("name", user.getName());
		model.addAttribute("surname",user.getSurname());
		model.addAttribute("image",user.getImageFile());
		model.addAttribute("id", user.getId());
		//pasarle la info al html
		return "USR_WorkerEditProfile";
	}
	@PostMapping("/workerEditProfile")
	public String saveClientProfile(@RequestParam String clientName, @RequestParam String clientSurname,
									@RequestParam String clientPassword, @RequestParam String clientPasswordRepeat,
									@RequestParam (name = "clientImage", required = false) MultipartFile clientImage,
									HttpServletRequest request) throws IOException{
		final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(clientPassword);
		String nameRep = request.getUserPrincipal().getName();
		User user = userRepository.findByEmail(nameRep).orElseThrow();
		String name=user.getName();
		String surname=user.getSurname();
		if (!clientPassword.equals(clientPasswordRepeat) && !matcher.matches()){
			return "USR_WorkerProfile";
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
		return "redirect:/workerEditProfile";
	}
	@GetMapping("/worker/{id}/image")
	public ResponseEntity<Object> downloadworkerImage(@PathVariable long id) throws SQLException {
		Optional<User> optMon = userRepository.findById(id);
		if (optMon.get().getImageFile() != null) {
			Resource file = new InputStreamResource(
					optMon.get().getImageFile().getBinaryStream());
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					.contentLength(optMon.get().getImageFile().length())
					.body(file);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	@PostMapping("/{id}/image")
	public ResponseEntity<Object> uploadImage(@PathVariable long id,
											  @RequestParam MultipartFile imageFile) throws IOException {
		Optional<User> optMon = userRepository.findById(id);
		URI location = fromCurrentRequest().build().toUri();
		optMon.get().setImage(location.toString());

		optMon.get().setImageFile(BlobProxy.generateProxy(
				imageFile.getInputStream(), imageFile.getSize()));
		userRepository.save(optMon.get());
		return ResponseEntity.created(location).build();
	}


}
