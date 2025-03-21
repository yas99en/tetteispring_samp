package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.SmartValidator;

import com.example.app.AccountCreateSmartForm.FreeAccount;
import com.example.app.AccountCreateSmartForm.PayAccount;

@Controller
public class AccountCreateSmartController {

	@Autowired
	SmartValidator validator;

	@GetMapping("smart")
	public String searchSmart(Model model) {
		return "account/form";
	}
	
	@PostMapping("smart")
	public String confirmSmart2(AccountCreateSmartForm form,
			                   BindingResult result, Model model) {
		Class<?> validationGroup = null;
		switch (form.getType()) {
		case "1":
			validationGroup = FreeAccount.class;
			break;
		case "2":
			validationGroup = PayAccount.class;
			break;
		default:
			break;
		}
		
		validator.validate(form, result, validationGroup);
		if (result.hasErrors()) {
			FieldError fieldErr = result.getFieldError("cardNo");
			if (null != fieldErr) {
				String outputMsg = "Error Code: " + fieldErr.getCode() + ", ErrMsg: " + fieldErr.getDefaultMessage();
				model.addAttribute("output", outputMsg);
			}
			return "account/form";
		}
		
		model.addAttribute("confirm", "登録成功");
		return "account/confirm";
	}
}