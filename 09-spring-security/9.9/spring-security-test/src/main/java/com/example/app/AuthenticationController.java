package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping("logout")
	public String viewlogoutForm() {
		return "logoutForm";
	}

	@GetMapping("access-denied")
	public String accessDenied() {
		return "accessDeniedError"; 
	}
}
