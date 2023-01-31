package nutri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class InitialationController {
    @GetMapping("/")
    public String page(Model model){
    return "index";
    }
}
