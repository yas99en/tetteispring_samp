package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、スコープの指定と異なるスコープのインジェクションの処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("ルックアップメソッドインジェクションによる異なるスコープのインジェクションの動作確認: 「ThreadUnsafePasswordEncoder Object Generation Time:」が毎回コンソールに表示され、正しくprototypeスコープになっていることが分かる");
		for (int i = 0; i < 10; i++) {
			UserService service = context.getBean(UserService.class);
			User dummyUser = new User();
			dummyUser.setUsername("DummyUser" + i);
			service.register(dummyUser, "DummyPassword" + i);
		}
		
		((ConfigurableApplicationContext) context).close();
	}
	
}