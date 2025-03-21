package com.example.app;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	// 5.7.9 ホーム画面
	@GetMapping
	public String root() {
        return "home";
    }
	
	// Bean Validation管理のプロパティファイルにエラーメッセージを定義
	@GetMapping("bean")
	public String spring(@ModelAttribute AccountForm form) {
		return "account/searchForm";
	}
	
	@PostMapping("bean")
	public String spring(
			@Validated @ModelAttribute AccountForm form,
			BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			return "account/searchForm";
		}
		
		return "account/searchForm";
	}
	
}
