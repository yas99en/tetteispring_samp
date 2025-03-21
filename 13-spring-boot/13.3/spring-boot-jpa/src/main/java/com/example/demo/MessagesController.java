package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// 13.3.2. Spring Data JPA Repositoryの使用例
@RestController
public class MessagesController {
	@Autowired
	MessageRepository messageRepository;

	@GetMapping("messages")
	public List<Message> getMessages() {
		return messageRepository.findAll();
	}

	@PostMapping("messages")
	public Message postMessages(@RequestBody Message message) {
		return messageRepository.save(message);
	}
}