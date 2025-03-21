package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    private final HelloService helloService;
    
    @Autowired
	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

    @GetMapping("/hello")
    public String hello(Model model) {
        String hello1 = helloService.hello1();
        model.addAttribute("hello1", hello1);
        String hello2 = helloService.hello2();
        model.addAttribute("hello2", hello2);
        String hello3 = helloService.hello3();
        model.addAttribute("hello3", hello3);
        return "hello";
    }
}