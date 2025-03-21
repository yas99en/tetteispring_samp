package com.example.app;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cart;

//7.1.2.2　セッションスコープBeanの利用例
@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	Cart cart;
	
	@GetMapping("show")
	public String showItems() {
		return "cart/order";
	}
	
	@GetMapping("add")
	public String addItems() {
		Collection<String> items = cart.getCartItems();
		int newNo = items.size() + 1;
		items.add("item00" + newNo);
		return "cart/order";
	}
	
	@GetMapping("remove")
	public String removeItems(Model model) {
		Collection<String> items = cart.getCartItems();
		if (!items.isEmpty()) {
			items.remove("item00" + items.size());
		} else {
			model.addAttribute("messages", "残りアイテムはゼロになりました、さらに減少できません！");
		}
		return "cart/order";
	}
}
