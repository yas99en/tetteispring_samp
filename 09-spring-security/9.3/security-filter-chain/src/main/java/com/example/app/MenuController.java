package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/menu")
public class MenuController {
	
	@GetMapping
	public String menu() {
		return "menu"; 
	}
}
