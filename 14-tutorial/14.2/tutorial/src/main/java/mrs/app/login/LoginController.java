package mrs.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 14.2.8.3. ログイン画面の作成 LoginController.java
@Controller
public class LoginController {
	
	@RequestMapping("loginForm")
	String loginForm() {
		return "login/loginForm";
	}
	
}