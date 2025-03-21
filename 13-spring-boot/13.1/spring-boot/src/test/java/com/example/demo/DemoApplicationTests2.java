package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

//13.1.1. Spring Bootで作るHello Worldアプリケーション アプリケーションサーバーを起動する方法に置き換えたテストケースクラス
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests2 {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	int port;

	@Test
	void testHello() {
		assertThat(restTemplate.getForObject("http://localhost:" + port, String.class), is("Hello World!"));
	}

}