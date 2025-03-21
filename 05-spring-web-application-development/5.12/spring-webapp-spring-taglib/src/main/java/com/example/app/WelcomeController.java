package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class WelcomeController {
	
	@GetMapping("welcome")
	public String create(Model model) {
		// 5.12.7 データを用意する
		String userUrl = "/myWebApp/users/";
		String userId = "A0000001";
		model.addAttribute("userUrl", userUrl);
		model.addAttribute("userId", userId);
		
		return "home";
	}

	@PostMapping("welcome")
	public String createAccount(BindingResult result, Model model) {
		return "home";
	}

}
