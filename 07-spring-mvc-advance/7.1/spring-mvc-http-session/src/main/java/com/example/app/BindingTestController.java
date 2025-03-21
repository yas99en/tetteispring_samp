package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/binding")
@SessionAttributes(names = {"bindingTestForm"}) //前提1 セッションスコープで保存
public class BindingTestController {
	
	//前提2 Formオブジェクトに初期値設定
	@ModelAttribute(value = "bindingTestForm")
	public BindingTestForm setUpAccountCreateForm() {
		BindingTestForm form = new BindingTestForm();
		form.setUsername("initial username");
		form.setPassword("initial password");
		return form;
	}
	
	@GetMapping("false")
	public String getFalseTest() {
		return "binding/form";
	}
	
	@PostMapping("false")
	public String postTestFalse(
			@Validated BindingTestForm bindingTestForm,
			@ModelAttribute(value = "password", binding = false) String password, // bindingTestFormのpasswordがバインド
			RedirectAttributes redirectAttributes) {

		System.out.println("bindingTestForm.username = " + bindingTestForm.getUsername());
		System.out.println("bindingTestForm.password = " + bindingTestForm.getPassword());
		System.out.println("password = " + password);
		
		return "redirect:/binding/complete";
		
	}
	
	@GetMapping("complete")
	public String getComplete() {
		return "binding/createComplete";
	}

}
