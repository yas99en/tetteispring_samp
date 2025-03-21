package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/accounts")
@SessionAttributes(names = { "password", "username" }) // 7.1.1.1 属性名を使用した管理対象オブジェクトの指定例
public class AccountCreateAttributeController {

	// 7.1.1.2 オブジェクトをHTTPセッションに追加するための実装例
	@ModelAttribute("password")
	public String setUpPassword() {
		return new String("初期値");
	}

	// 入力画面（属性名を使用）をGetで表示する
	@GetMapping("create1a")
	public String create1(Model model) {
		return "account/form1a";
	}

	// 確認画面をGetで表示する
	@GetMapping("create1b")
	public String confirm(Model model) {
		return "account/createConfirm1a";
	}

	//　7.1.1.2　Modelからオブジェクトを取得する際の実装例  HttpSessionRequiredExceptionの確認用入力画面
	@GetMapping("create4ng")
	public String createNg(Model model) {
		return "account/form4ng";
	}

	// 入力画面（属性名を使用） -->(フォームをSubmitする)--> 確認画面、redirectして、セッション値を確認する
	@PostMapping("create1a")
	public String create2(@Validated AccountCreateAttributeForm from, BindingResult result, ModelMap modelMap) {
		// ModelMapを利用して、セッション"password"に値をセットする
		modelMap.put("password", from.getPassword());
		return "redirect:/accounts/create1b";
	}

	//　7.1.1.2　Modelからオブジェクトを取得する際の実装例
	@PostMapping("create1b")
	public String create(@Validated AccountCreateAttributeForm from, 
			BindingResult result,
			@ModelAttribute("password") String password, 
			RedirectAttributes redirectAttributes) {
			return "account/createComplete";
	}

	//　7.1.1.2　Modelからオブジェクトを取得する際の実装例 HttpSessionRequiredExceptionの確認
	@PostMapping("create4ng")
	public String createNg(@Validated AccountCreateAttributeForm from, BindingResult result,
			@ModelAttribute("username") String username, RedirectAttributes redirectAttributes) {
		return "account/createComplete";
	}

}