package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	// 8.4.3. テストの実行 テスト対象のController
    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
    
}
