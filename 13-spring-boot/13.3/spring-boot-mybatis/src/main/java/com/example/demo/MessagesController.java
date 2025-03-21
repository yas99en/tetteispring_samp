package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 13.3.3. MyBatis Mapperインターフェイスの使用例
@RestController
public class MessagesController {
	@Autowired
	MessageMapper messageMapper;

	@GetMapping("messages")
	public List<Message> getMessages() {
		return messageMapper.findAll();
	}

	@PostMapping("messages")
	public Message postMessages(@RequestBody Message message) {
		messageMapper.create(message);
		return message;
	}
}