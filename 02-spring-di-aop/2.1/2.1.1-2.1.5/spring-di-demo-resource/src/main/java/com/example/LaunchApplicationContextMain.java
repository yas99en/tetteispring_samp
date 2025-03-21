package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、@Resourceの処理が行なわれていることを確認する
	public static void main(String[] args) {
		// 2.1.2. ApplicationContextとBean定義 DIコンテナからインスタンスを取り出す実装例
		// 2.1.2. ApplicationContextとBean定義 各ApplicationContextの生成の実装例
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("@Resourceについて確認する");
		System.out.println("@Resourceの動作確認: UserRepositoryImpl saveが実行され、IFのListとMapがインジェクションされ、PasswordEncoderにSha256PasswordEncoderが用いられており、正常に動作していることが分かる");
		// 2.1.2. ApplicationContextとBean定義 Beanの各ルックアップ方法の実装例
		UserService service = context.getBean(UserService.class);
		User dummyUser = new User();
		dummyUser.setUsername("DummyUser1");
		service.register(dummyUser, "DummyPassword1");
		
		((ConfigurableApplicationContext) context).close();
	}
	
}