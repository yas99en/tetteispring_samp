package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("broken-jsp")
	public String broken() {
		return "broken";
	}
}
