package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.service.MessageService;

//8.4.2.2. スタンドアロンモード 依存コンポーネントをモック化する場合のセットアップ例のController
@Controller
public class MessageRestController {

	private final MessageService service;
	
	@Autowired
	public MessageRestController(MessageService service) {
		this.service = service;
	}

	@GetMapping("message")
	public String getMessage() {
		return service.getMessage();
	}

}
