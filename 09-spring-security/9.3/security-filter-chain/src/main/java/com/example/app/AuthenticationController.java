package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("ui")
public class AuthenticationController {
	
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

}
