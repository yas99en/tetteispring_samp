package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
	
	@GetMapping
    public String root(Model model) {
        return "redirect:/login";
    }
	
	@GetMapping("login")
	public String getLogin(Model model) {
		model.addAttribute(new LoginForm());
		return "11/home";
	}
	
	@PostMapping("login")
  	public String postLogin(LoginForm form) { 
  		return "redirect:/account";
  	}
	
	@GetMapping("account")
	public String getAccount(Model model) {
		model.addAttribute(new AccountForm());
		return "11/account";
	}
	
	@PostMapping("account")
  	public String postAccount(AccountForm form) { 
  		return "11/account";
  	}
	
}
