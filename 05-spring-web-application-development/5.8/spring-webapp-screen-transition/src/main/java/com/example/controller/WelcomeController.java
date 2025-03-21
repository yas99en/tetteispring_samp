package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	// 5.8.1 View名を文字列として返却する実装例
	@GetMapping("/")
	public String home() {
		return "home";
	}

	// 5.8.2 リダイレクトする際のView名の指定例
	@GetMapping("redirect")
	public String redirect() {
		return "redirect:/menu";
	}
}