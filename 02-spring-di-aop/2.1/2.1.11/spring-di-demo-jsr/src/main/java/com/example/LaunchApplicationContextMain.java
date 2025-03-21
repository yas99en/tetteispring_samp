package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、JSR 330のAPIの処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("JSR 330のAPIの動作確認: DIできており正常に動作していることが分かり、また「BCryptPasswordEncoder Object Generation Time:」が毎回コンソールに表示され、正しくprototypeスコープになっていることが分かる");
		for (int i = 0; i < 10; i++) {
			UserService service = context.getBean(UserService.class);
			User dummyUser = new User();
			dummyUser.setUsername("DummyUser" + i);
			service.register(dummyUser, "DummyPassword" + i);
		}
		
		((ConfigurableApplicationContext) context).close();
	}
	
}