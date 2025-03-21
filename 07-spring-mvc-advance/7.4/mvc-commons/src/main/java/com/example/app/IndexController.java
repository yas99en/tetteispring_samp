package com.example.app;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CommonRequestData;

@Controller
public class IndexController {

	// 7.4.4. HandlerMethodArgumentResolverの利用
	@GetMapping
	public String index(Model model, CommonRequestData commonRequestData) {
		System.out.println("userAgent : " + commonRequestData.getUserAgent());
		System.out.println("sessionId : " + commonRequestData.getSessionId());
		// 本書ではmodel.addAttributeせずに"home"に遷移
		model.addAttribute("userAgent", commonRequestData.getUserAgent());
		model.addAttribute("sessionId", commonRequestData.getSessionId());
		model.addAttribute("now", new Date());
		return "index";
	}

	// 7.4.3. @ControllerAdviceの利用
	@GetMapping("arith")
	public String arith() {
		throw new ArithmeticException("ArithmeticException Test");
	}
}
