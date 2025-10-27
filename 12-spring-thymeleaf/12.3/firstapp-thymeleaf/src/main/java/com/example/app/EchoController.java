package com.example.app;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("echo")
public class EchoController {

    @GetMapping
    public String viewInput(Model model) {
        EchoForm form = new EchoForm();
        model.addAttribute(form);
        return "echo/input";
    }
    
    @PostMapping
    public String echo(@Valid EchoForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "echo/input";
        }
        return "echo/output";
    }

}