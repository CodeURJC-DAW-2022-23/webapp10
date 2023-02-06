package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin")
    public String mostrarAdmin(){
        return "USR_Admin";
    }
    @GetMapping("/buttons")
    public String mostrarBotones(){
        return "buttons";
    }
    @GetMapping("/cards")
    public String mostrarCartas(){
        return "charts";
    }
    @GetMapping("/colors")
    public String mostrarColores(){
        return "colors";
    }
    @GetMapping("/error")
    public String errorPage(){
        return "404";
    }
    @GetMapping("/tables")
    public String adminTable(){
        return "USR_AdminClientTable";
    }

}
