package com.example.demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 13.2.1. RESTful Webサービスの作成 Controllerの実装例
@RestController
public class MessagesController {
	
	final List<Message> messages = new CopyOnWriteArrayList<>();

	@GetMapping("messages")
	public List<Message> getMessages() {
		return messages;
	}

	@PostMapping("messages")
	public Message postMessages(@RequestBody Message message) {
		messages.add(message);
		return message;
	}
	
}