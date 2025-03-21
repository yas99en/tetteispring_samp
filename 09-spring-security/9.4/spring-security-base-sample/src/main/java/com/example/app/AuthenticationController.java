package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.service.account.AccountUserDetails;

@Controller
public class AuthenticationController {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping()
	public String index() {
		return "redirect:/login";
	}

	// 9.4.2.3. ログインフォームの作成
	@GetMapping("/login")
	public String viewLoginForm() {
		return "loginForm";
	}

	@GetMapping("loginFailure")
	public String loginFailure() {
		return "loginForm";
	}

	@GetMapping(value = "login", params = { "error" })
	public String error() {
		return "loginForm";
	}

	// 9.4.3.2. デフォルト動作のカスタマイズ
	@GetMapping("menu")
	public String menu(@AuthenticationPrincipal AccountUserDetails accountUserDetails, // 認証情報を受け取る
			Model model) {
		// 9.4.10 認証情報へのアクセス
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = null;
		if (authentication.getPrincipal() instanceof AccountUserDetails) {
			// Authentication#getPrincipalメソッドを呼び出して、 UserDetailsオブジェクトを取得する
			AccountUserDetails userDetails = AccountUserDetails.class.cast(authentication.getPrincipal());
			// 本書ではuuidとなっているが本サンプルではusernameとする
			username = userDetails.getAccount().getUsername();
		}
		// 9.4.11 認証処理とSpring MVCの連携
		model.addAttribute(accountUserDetails.getAccount());
		log.info("Account username \n 9.4.10 : " + username + "\n 9.4.11 : "
				+ accountUserDetails.getAccount().getUsername());
		return "menu";
	}
}
