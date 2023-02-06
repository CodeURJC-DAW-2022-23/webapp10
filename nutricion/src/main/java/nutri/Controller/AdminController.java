package nutri.Controller;

import nutri.Model.User;
import nutri.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    public void addAdmin(){
        userRepository.save(new User("ejemplo@yahoo.es","1234"));
    }

    @GetMapping("/admin")
    public String showAdmin(){
        return "USR_Admin";
    }
    @GetMapping("/adminCharts")
    public String showCharts(){
        return "USR_AdminCharts";
    }
    @GetMapping("/tablesClient")
    public String showClients(){
        return "USR_AdminClientTable";
    }
    @GetMapping("/profileInfo")
    public String showProfile(){return "USR_ProfileInfoAdmin";}



}
