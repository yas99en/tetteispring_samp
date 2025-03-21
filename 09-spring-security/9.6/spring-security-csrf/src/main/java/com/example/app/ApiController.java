package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.dto.MessageResource;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@GetMapping("test")
	public String test() {
		return "api security OK";
	}
	
	@PostMapping("message")
	public void outputMessage(@RequestBody MessageResource messageResource) {
		System.out.println(messageResource.getMessage());
	}
}
