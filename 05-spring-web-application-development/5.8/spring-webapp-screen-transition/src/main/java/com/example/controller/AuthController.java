package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.LoginForm;

@Controller
@RequestMapping("auth")
public class AuthController {

	// 5.8.3 フォワードする際のView名の指定例
	@GetMapping("login")
	public String login(@Validated LoginForm form, BindingResult result) {
		if(result.hasErrors()) {
			return "auth/loginForm";
		}
		return "forward:/auth/authenticate";
	}
	
	@GetMapping("authenticate")
	public String authenticate() {
		return "auth/authenticate";
	}
	
}