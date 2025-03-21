package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

// 13.3.1. Spring JDBC JdbcTemplateの使用例
@RestController
public class MessagesController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("messages")
	public List<Message> getMessages() {
		return jdbcTemplate.query("SELECT text FROM messages ORDER BY id", (rs, i) -> {
			Message m = new Message();
			m.setText(rs.getString("text"));
			return m;
		});
	}

	@PostMapping("messages")
	public Message postMessages(@RequestBody Message message) {
		jdbcTemplate.update("INSERT INTO messages(text) VALUES (?)", message.getText());
		return message;
	}
}