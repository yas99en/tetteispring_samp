package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller 
@RequestMapping("accounts")
public class AccountController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping()
	public String get(
			@ModelAttribute AccountForm accountForm, 
			BindingResult result,
			Model model) {
		
		return "accounts/input";
	}
	
	@PostMapping() 
	public String postAccount(
			@Validated AccountForm accountForm,
			BindingResult result, Model model) { 
		
		if (result.hasErrors()) { 
			
			return "accounts/input"; 
		}
		
		return "accounts/complete";
	}

}
