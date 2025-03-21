package com.example.app;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping
	public String index() {
		return "index";
	}

	// 7.6.2. ロケールの利用
	@GetMapping(path = "make", params = "scope=daily")
	public String makeDailyReport(Model model, Locale locale) {
		// ロケールに依存する処理を行なう
		model.addAttribute("locale", locale);
		return "report/complete";
	}
}