package nutri.Controller;

import nutri.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdmin(){
        System.out.println();
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
    @GetMapping("/workerTable")
    public String workers(){return "USR_AdminWorkerTable";}
    @GetMapping("/addWorker")
    public String addWorkers(){return "USR_AdminAddWorker";}



}
