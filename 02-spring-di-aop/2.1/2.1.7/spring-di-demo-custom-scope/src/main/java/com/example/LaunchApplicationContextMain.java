package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {

	// mainメソッドを実行し、カスタムスコープの定義と処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println("カスタムスコープの動作確認: 3つのスレッドそれぞれで1つずつpasswordEncoderのオブジェクトが生成され、10回の試行で「BCryptPasswordEncoder Object Generation Time:」が3回コンソールに表示され、正しくthreadスコープになっていることが分かる");
		// スレッド上で実行する
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			UserService service = context.getBean(UserService.class);
			pool.submit(() -> {
				try {
					User dummyUser = new User();
					dummyUser.setUsername("DummyUser");
					service.register(dummyUser, "DummyPassword");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		pool.shutdown();

		((ConfigurableApplicationContext) context).close();
	}

}
