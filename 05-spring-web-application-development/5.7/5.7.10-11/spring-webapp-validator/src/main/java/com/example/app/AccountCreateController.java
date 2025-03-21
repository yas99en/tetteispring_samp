package com.example.app;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;

import com.example.common.validation.AccountCreateFormValidator;

@Controller
public class AccountCreateController {

	@Autowired
	AccountCreateFormValidator accountCreateFormValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(accountCreateFormValidator);
	}
	
	@GetMapping("create")
	public String search(Model model) {
		return "account/form";
	}
	
	@PostMapping("create")
	public String confirm(@Validated AccountCreateForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			FieldError fieldErr = result.getFieldError("cardNo");
			if (null != fieldErr) {
				String outputMsg = "Error Code: " + fieldErr.getCode() + ", ErrMsg: " + fieldErr.getDefaultMessage();
				model.addAttribute("output", outputMsg);
			}
			return "account/form";
		}
		
		model.addAttribute("confirm", "登録成功");
		return "account/form";
	}	

}