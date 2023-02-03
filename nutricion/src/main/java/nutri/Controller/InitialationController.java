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
        return "LoginTMP";
    }

    @GetMapping("/register")
    public String registerTem(){return "register";}


}
