package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {
	
	@GetMapping()
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("login")
	public String viewLoginForm() {
		return "loginForm";
	}
	
	@GetMapping("loginFailure")
	public String loginFailure() {
		return "loginForm";
	}
	
	@GetMapping(value = "login", params = {"error"})
	public String error() {
		return "loginForm"; 
	}
	
	@GetMapping("menu")
	public String menu() {
		return "menu"; 
	}
	
	@GetMapping("/resources/testpage")
	public String testpage() {
		return "resources/testpage";
	}
	
	@GetMapping("logout")
	public String viewlogoutForm() {
		return "logoutForm";
	}
}
