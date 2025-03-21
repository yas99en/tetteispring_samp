package com.example.app;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes(types = AccountCreateForm2.class) 
public class WelcomeController {
	
    @GetMapping
    public String root(Model model) {
        model.addAttribute("now", new Date());
        return "6/home";
    }
    
  	@PostMapping("simplebindings")
  	public String create(
  		@Validated AccountCreateForm1 form, BindingResult result, 
  		RedirectAttributes redirectAttributes) { 
  		redirectAttributes.addFlashAttribute(form);
  		return "redirect:/simplebindings";
  	}

    //シンプル型とのバインディング
  	@GetMapping("simplebindings")
  	public String simplebindings(AccountCreateForm1 form) { 
  		return "6/simplebindings";
  	}
  	
  	@ModelAttribute 
	public AccountCreateForm2 setUpForm() {
		return new AccountCreateForm2();  
	}

    //ネストした JavaBeans とのバインディング
	@GetMapping("javabeans")
	public String getForm(Model model, SessionStatus status) {
		status.setComplete();
		return "6/javabeans"; 
	}
	
	@PostMapping("javabeans")
	public String form(@ModelAttribute @Validated AccountCreateForm2 form) {
		return "redirect:/javabeans";
	}
	
	//コレクション内の JavaBeans とのバインディング
	@GetMapping("collection")
	public String collection(Model model) {
		model.addAttribute(new AccountCreateForm3());
		return "6/collection"; 
	}
	
	@PostMapping("collection")
	public String postCollection(@ModelAttribute @Validated AccountCreateForm3 form) {
		return "redirect:/collection";
	}
	
}
