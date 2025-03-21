package com.example.app;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String root(Model model) {
        model.addAttribute("now", new Date());
        return "index";
    }
}
