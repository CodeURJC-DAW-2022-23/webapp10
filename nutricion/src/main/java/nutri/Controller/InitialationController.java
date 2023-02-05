package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class InitialationController {
    @GetMapping("/")
    public String page(){
    return "USR_NonReg";
    }

    @GetMapping("/login")
    public String loggingTem(){
        return "USR_NonRegLogin";
    }

    @GetMapping("/register")
    public String registerTem(){return "USR_NonRegRegister";}

    @GetMapping("/cliente")
    public String client(){return "USR_ClientDiets";}

}
