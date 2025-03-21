package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、Beanのライフサイクルに関する処理が行なわれていることを確認する
	public static void main(String[] args) {
		// 2.1.8.2.2. DIコンテナの破棄 try-with-resources文を利用したDIコンテナの破棄の実装例
		System.out.println("Post Construct・Pre Destroyについての動作確認: 各メソッドが、正しいタイミングで実行されていることが分かる");
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
		    // アプリケーションのコード
			UserService service = context.getBean(UserService.class);
			User dummyUser = new User();
			dummyUser.setUsername("DummyUser1");
			service.register(dummyUser, "DummyPassword1");
		}
	}
	
}