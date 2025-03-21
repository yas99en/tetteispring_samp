package springbook.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    protected String home(Model model) {
        model.addAttribute("now", new Date());
        return "home";
    }

}
