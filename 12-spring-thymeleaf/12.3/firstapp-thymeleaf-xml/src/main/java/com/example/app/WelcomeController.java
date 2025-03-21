package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    @GetMapping
    public String home() {
        return "index";
    }

}