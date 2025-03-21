package com.example.app;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.AccountSwitchCheckForm.FreeAccount;
import com.example.app.AccountSwitchCheckForm.PayAccount;

@Controller
public class AccountController {
	
	// 5.7 ホーム画面
	@GetMapping
	public String root() {
        return "home";
    }
	
	// 5.7.1〜5.7.3, 5.7.4(一部) 入力値チェック
	@GetMapping("search")
	public String search(@ModelAttribute AccountSearchForm form) {
		return "account/searchForm";
	}
	
	@PostMapping("search")
	public String search(
			@Validated AccountSearchForm form,
			BindingResult result,
			Model model) {
		
		if (result.hasErrors()) {
			return "account/searchForm";
		}
		
		model.addAttribute("name", form.getName());
		model.addAttribute("tel", form.getTel());
		model.addAttribute("dateOfBirth", form.getDateOfBirth());
		model.addAttribute("email", form.getEmail());
		return "account/searchResult";
	}
	
	// 5.7.4 入力値チェック
	@GetMapping("inputcheck")
	public String inputValueCheck(AccountInputValueCheckForm form) {
		return "account/inputValueCheckForm";
	}
	
	@PostMapping("inputcheck")
	public String inputValueCheck(
			@Validated AccountInputValueCheckForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "account/inputValueCheckForm";
		}
		return "redirect:/inputcheck";
	}
	
	// 5.7.5 Validアノテーション
	@GetMapping("validcheck")
	public String validCheck(AccountValidAnnotationCheckForm form) {
		return "account/validAnnotationCheckForm";
	}
	
	@PostMapping("validcheck")
	public String validCheck(
			@Valid AccountValidAnnotationCheckForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "account/validAnnotationCheckForm";
		}
		return "redirect:/validcheck";
	}
	
	// 5.7.6 独自アノテーション
	@GetMapping("origincheck")
	public String originCheck(AccountOriginalAnnotationCheckForm form) {
		return "account/originalAnnotationCheck";
	}
	
	@PostMapping("origincheck")
	public String originCheck(
			@Validated AccountOriginalAnnotationCheckForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "account/originalAnnotationCheck";
		}
		return "redirect:/origincheck";
	}
	
	// 5.7.7 入力チェック切替
	@GetMapping("switchcheck")
	public String switchCheck(AccountSwitchCheckForm form) {
		return "account/switchCheck";
	}
	
	@PostMapping(path = "switchcheck", params = { "confirm", "type=1" })
	public String confirmFreeAccount(
			@Validated(FreeAccount.class) AccountSwitchCheckForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "account/switchCheck";
		}
		return "account/switchCheck";
	}
	
	@PostMapping(path = "switchcheck", params = { "confirm", "type=2" })
	public String confirmPayAccount(
			@Validated(PayAccount.class) AccountSwitchCheckForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "account/switchCheck";
		}
		return "account/switchCheck";
	}
	
	// =========================================
	// 5.7.3 未入力チェック
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// テキスト入力項目で未入力の場合は、nullに置換する
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
}
