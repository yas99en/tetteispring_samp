package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContext {
	
	// mainメソッドを実行し、ComponentScanの追加設定に関する処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("ComponentScanに追加設定した場合のアノテーションベースConfigurationについて確認する");
		System.out.println("excludeFiltersの動作確認: FieldInjectionUserServiceImpl registerが実行され、UserRepositoryImpl saveが実行され、PasswordEncoderにSha256PasswordEncoderが用いられており、正常に動作していることが分かる");
		UserService service = context.getBean(UserService.class);
		User dummyUser = new User();
		dummyUser.setUsername("DummyUser1");
		service.register(dummyUser, "DummyPassword1");
		((ConfigurableApplicationContext) context).close();
	}
		
}