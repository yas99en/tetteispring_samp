package com.example.app;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class AccountCreateController {

	@ModelAttribute("accountCreateForm")
	public AccountCreateForm setUpAccountCreateForm() {
		return new AccountCreateForm();
	}
	
	@GetMapping("create")
	public String search(Model model) {
		// 5.12.6 データを用意する
		List<Date> targetDateList = new ArrayList<Date>();
		targetDateList.add(new Date());
		model.addAttribute("targetDateList", targetDateList);
		
		//5.12.9　データを用意する
		model.addAttribute("message1", "\";alert('test'); var l=\"");
		model.addAttribute("message2", "message><test");
		model.addAttribute("message3", "message><test\\");
		return "createForm";
	}

	@PostMapping("create")
	public String confirm(@Validated AccountCreateForm form, BindingResult result, Model model) {
		// 5.12.8 エスケープ有効かを確認する
		model.addAttribute("defaultHtmlEscape", form.getDefaultHtmlEscapeStr());
		
		if (result.hasErrors()) {
			System.out.println("errors count: " + result.getFieldErrorCount());
			model.addAttribute("errors", result.getAllErrors());
			return "createForm";
		}
		return "createResult";
	}	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}