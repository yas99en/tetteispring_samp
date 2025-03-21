package com.example.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 13.2.2.1. Thymeleafの利用 Controllerの実装例
// 13.2.2.3. メッセージの外部化 MessageSourceの使用例
@Controller
public class HelloController {
	
	@Autowired
	MessageSource messageSource;
	
	// メッセージの外部化(Controllerでメッセージを取得する場合)
	@GetMapping("/hello1")
    public String hello(Model model, Locale locale) {
    	model.addAttribute("title", messageSource.getMessage("app.title", null, locale));
        model.addAttribute("hello", "Hello World 1!");
        return "hello1";
    }
    
	// メッセージの外部化(Thymeleaf自身が持つメッセージ解決の仕組みを使う場合)
    @GetMapping("/hello2")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello World 2!");
        return "hello2";
    }
    
}
