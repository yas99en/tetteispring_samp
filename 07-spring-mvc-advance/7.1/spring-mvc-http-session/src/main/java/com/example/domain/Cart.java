package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//7.1.2.1　アノテーションによるセッションスコープのBean定義例
@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Collection<String> cartItems;
	
	public Cart() {
		if (cartItems == null) {
			cartItems = new ArrayList<>();
		}
		// 初期化Dummyデータを用意する
		for (int i = 0; i < 5; i++) {
			int itemNo = i + 1;
			cartItems.add("item00" + itemNo);
		}
	}

	public Cart(Collection<String> cartItems) {
		this.cartItems = cartItems;
	}

	public Collection<String> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Collection<String> cartItems) {
		this.cartItems = cartItems;
	}
	
}
