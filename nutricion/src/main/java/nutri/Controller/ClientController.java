package nutri.Controller;

import nutri.Model.User;
import nutri.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientController{
    @Autowired
    private UserRepository userRepository;
    public void run(String... args) throws Exception {
        userRepository.save(new User("adrian","Garcia","0598K","a@gmail.com","1234"));
    }

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

    @GetMapping("/clientInfo")
    public String showInfo(){
        return "USR_ProfileInfoClient";
    }

    @GetMapping("/clientInfoSetting")
    public String editInfo(){
        return "USR_ProfileClientEdit";
    }
}
