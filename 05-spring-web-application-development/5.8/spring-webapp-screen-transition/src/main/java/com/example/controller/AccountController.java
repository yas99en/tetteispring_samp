package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.AccountCreateForm;
import com.example.model.Account;
import com.example.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping("form")
	public String create(Model model) {
		return "account/createForm";
	}

	// 5.8.2 RedirectAttributesにリクエストパラメータを格納する実装例
	@PostMapping("create")
	public String create(@Validated AccountCreateForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		Account createdAccount = accountService.create("test user 1");
		redirectAttributes.addAttribute("accountId", createdAccount.getAccountId());
		redirectAttributes.addAttribute("name", createdAccount.getName());
		return "redirect:/account/create?complete";
	}

	@GetMapping(path = "create", params = "complete")
	public String createComplete() {
		return "account/createComplete";
	}

	// 5.8.2リダイレクト先のURLを動的に組み立てる実装例
	@PostMapping("create2")
	public String create2(@Validated AccountCreateForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		Account createdAccount = accountService.create("test user 2");
		redirectAttributes.addAttribute("accountId", createdAccount.getAccountId());
		return "redirect:/account/{accountId}?createComplete";
	}

	// 5.8.5RedirectAttributesにJavaオブジェクトを格納する実装例
	@PostMapping("create3")
	public String create3(@Validated AccountCreateForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		Account createdAccount = accountService.create("test user 3");
		redirectAttributes.addFlashAttribute("account", createdAccount);
		return "redirect:/account/create?complete";
	}
}