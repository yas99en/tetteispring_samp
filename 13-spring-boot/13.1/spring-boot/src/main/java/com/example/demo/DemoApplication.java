package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//13.1.1. Spring Bootで作るHello Worldアプリケーション DemoApplication.javaをControllerとして扱う際の実装例
@SpringBootApplication
@RestController
public class DemoApplication {
	
	@GetMapping("/")
	String hello() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
