package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、アノテーションベースConfiguration及びインジェクションの処理が行なわれていることを確認する
	public static void main(String[] args) {
		// 2.1.2. ApplicationContextとBean定義 DIコンテナからインスタンスを取り出す実装例
		// 2.1.2. ApplicationContextとBean定義 各ApplicationContextの生成の実装例
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("アノテーションベースConfigurationについて確認する");
		System.out.println("Field Injectionの動作確認: FieldInjectionUserServiceImpl registerが実行され、UserRepositoryImpl saveが実行され、IFのListとMapがインジェクションされ、PasswordEncoderにBCryptPasswordEncoderが用いられており、正常に動作していることが分かる");
		// 2.1.2. ApplicationContextとBean定義 Beanの各ルックアップ方法の実装例
		UserService service = context.getBean("fieldInjectionUserService", UserService.class);
		User dummyUser = new User();
		dummyUser.setUsername("DummyUser1");
		service.register(dummyUser, "DummyPassword1");
		System.out.println();
		
		System.out.println("Setter Injectionの動作確認: SetterInjectionUserServiceImpl registerが実行され、UserRepositoryImpl saveが実行され、PasswordEncoderにBCryptPasswordEncoderが用いられており、正常に動作していることが分かる");
		service = context.getBean("setterInjectionUserService", UserService.class);
		dummyUser = new User();
		dummyUser.setUsername("DummyUser2");
		service.register(dummyUser, "DummyPassword2");
		System.out.println();
		
		System.out.println("Constructor Injectionの動作確認: ConstructorInjectionUserServiceImpl registerが実行され、UserRepositoryImpl saveが実行され、PasswordEncoderにBCryptPasswordEncoderが用いられており、正常に動作していることが分かる");
		service = context.getBean("constructorInjectionUserService", UserService.class);
		dummyUser = new User();
		dummyUser.setUsername("DummyUser3");
		service.register(dummyUser, "DummyPassword3");
				
		((ConfigurableApplicationContext) context).close();
	}
	
}