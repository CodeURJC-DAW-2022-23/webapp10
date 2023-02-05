package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/clientDiets")
    public String diet(){
        return "USR_ClientDiets";
    }

    @GetMapping("/clientForm")
    public String forms(){
        return "USR_ClientForm";
    }

    @GetMapping("/clientRecipes")
    public String recipes(){
        return "USR_ClientRecepies";
    }

    @GetMapping("/clientChart")
    public String chart(){
        return "USR_ClientCharts";
    }

}
