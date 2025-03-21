package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping()
	public String index() {
		return "redirect:/login";
	}

	@GetMapping("login")
	public String viewLoginForm() {
		return "loginForm";
	}

	@GetMapping(value = "login", params = { "error" })
	public String error() {
		return "loginForm";
	}

	// 9.4.3.2. デフォルト動作のカスタマイズ
	@GetMapping("menu")
	public String menu() {
		log.info("9.4.3.2. デフォルト動作のカスタマイズ　認証成功時に遷移するデフォルトのパスの変更");
		return "menu";
	}

	// 9.4.4.2. デフォルト動作のカスタマイズ
	@GetMapping("loginFailure")
	public String loginFailure() {
		log.info("9.4.4.2. デフォルト動作のカスタマイズ　認証失敗時に遷移するパスの変更");
		return "loginError";
	}

	// 9.4.9.2. デフォルト動作のカスタマイズ
	@GetMapping("logoutSuccess")
	public String viewlogoutForm() {
		log.info("9.4.9.2. デフォルト動作のカスタマイズ ログアウト成功時に遷移するパスの変更");
		return "logoutForm";
	}
}
