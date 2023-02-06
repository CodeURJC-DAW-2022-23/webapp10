package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


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

}
