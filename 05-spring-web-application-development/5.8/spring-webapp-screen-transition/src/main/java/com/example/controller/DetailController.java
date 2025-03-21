package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Account;
import com.example.service.AccountService;

@Controller
@RequestMapping("account")
public class DetailController {

	@Autowired
	AccountService accountService;

	// 5.8.4 ModelAttributeアノテーションを付与したメソッドを用意する実装例
	@ModelAttribute
	public Account setUpAccount(@PathVariable String accountId) {
		return accountService.findOne(accountId);
	}

	@GetMapping("{accountId}")
	public String detail() {
		return "account/detail";
	}

}