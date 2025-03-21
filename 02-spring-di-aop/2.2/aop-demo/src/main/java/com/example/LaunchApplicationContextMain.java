package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.domain.service.CalcService;
import com.example.domain.service.UserService;

public class LaunchApplicationContextMain {

	// mainメソッドを実行し、AOPの処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		System.out.println("正常終了時のAOP確認: 各Adviceがそれぞれのタイミングで実行されていることが分かる");
		userService.findOne("DummyUser1");
		System.out.println();
		
		System.out.println("例外発生時のAOP確認: @AfterThrowingが実行されていることが分かる");
		try {
			userService.checkOccuredExcetion();
		} catch (Exception e) {
			System.out.println("例外発生: " + e);
		}
		System.out.println();
		
		System.out.println("例外発生時のAOP確認（例外の変換）: @AfterThrowingにより例外が変換され伝播していることが分かる");
		try {
			userService.checkOccuredDataAccessException();
		} catch (Exception e) {
			System.out.println("例外発生: " + e);
		}
		System.out.println();
		
		System.out.println("通常終了時のAOP確認（Pointcut式の確認）: 名前付きPointcut式が動作していることを確認でき、またJoinPointから対象オブジェクトや引数を取得できていることが分かる");
		CalcService calcService = context.getBean(CalcService.class);
		calcService.calc(1);
		
		((ConfigurableApplicationContext) context).close();
	}
	
}


