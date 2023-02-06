package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkerController {
    @GetMapping("/WorkerDiets")
    public String diets(){
        return "USR_WorkerDiets";
    }
    @GetMapping("/WorkerUploadDiets")
    public String uploadDiets (){
        return "USR_WorkerUploadDiets";
    }
    @GetMapping("/WorkerUploadRecipes")
    public String uploadRecipes (){
        return "USR_WorkerUploadRecipes";
    }



}
