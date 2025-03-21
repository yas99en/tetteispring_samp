package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/accounts")
@SessionAttributes(types = AccountCreateForm.class) // クラスを使用した管理対象オブジェクトの指定例
public class AccountCreateController {

	// 7.1.1.2 オブジェクトをHTTPセッションに追加するための実装例
	@ModelAttribute("accountCreateForm")
	public AccountCreateForm setUpAccountCreateForm() {
		return new AccountCreateForm();
	}
	
	// 入力画面（1/3）をGetで表示する
	@GetMapping("create1")
	public String create1(Model model) {
		return "account/form1";
	}

	// 入力画面（2/3）をGetで表示する
	@GetMapping("create2")
	public String create2(Model model) {
		return "account/form2";
	}

	// 入力画面（3/3）をGetで表示する
	@GetMapping("create3")
	public String create3(Model model) {
		return "account/form3";
	}

	// 確認画面をGetで表示する
	@GetMapping("create")
	public String confirm(Model model) {
		return "account/createConfirm";
	}

	// 入力画面（1/3） -->(フォームをSubmitする)--> 入力画面（2/3）、redirectして、セッション値を確認する
	//　7.1.1.2　Modelからオブジェクトを取得する際の実装例
	@PostMapping("create1")
	public String create2(@Validated AccountCreateForm from, BindingResult result) {
		return "redirect:/accounts/create2";
	}

	// 入力画面（2/3） -->(フォームをSubmitする)--> 入力画面（3/3）、redirectして、セッション値を確認する
	@PostMapping("create2")
	public String create3(@Validated AccountCreateForm from, BindingResult result) {
		return "redirect:/accounts/create3";
	}

	// 入力画面（3/3） -->(フォームをSubmitする)--> 確認画面、redirectして、セッション値を確認する
	@PostMapping("create3")
	public String confirm(@Validated AccountCreateForm from, BindingResult result) {
		return "redirect:/accounts/create";
	}

	@PostMapping("create")
	public String create(Model model) {
		return "redirect:/accounts/create?complete";
	}

	// 7.1.1.3 オブジェクトをHTTPセッションから削除するための実装例
	@GetMapping(path = "create", params = "complete")
	public String createComplete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "account/createComplete";
	}

}
