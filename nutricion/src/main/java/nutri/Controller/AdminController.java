package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


@GetMapping("/admin")
public String mostrarAdmin(){
    return "admin";
}
@GetMapping("/buttons")
public String mostrarBotones(){
    return "buttons";
}
@GetMapping("/admin/cards")
public String mostrarCartas(){
    return "charts";
}
@GetMapping("/admin/colors")
public String mostrarColores(){
    return "colors";
}

}
