package com.example;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.config.AppConfig;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、Java Configの分割処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService service = context.getBean(UserService.class);
		BasicDataSource dataSource =  (BasicDataSource) context.getBean(DataSource.class);
		System.out.println("DomainConfigの動作確認: DIできており、正常に動作していることが分かる");
		User dummyUser = new User();
		dummyUser.setUsername("DummyUser_split");
		service.register(dummyUser, "DummyUser_split");
		System.out.println();
		
		System.out.println("InfrastructureConfigの動作確認: 分割したコンフィギュレーションクラスのBeanを、正しく読み込めていることが分かる");
		System.out.println("DriverClassName: " + dataSource.getDriverClassName());
		System.out.println("Url: " + dataSource.getUrl());
		System.out.println("Username: " + dataSource.getUsername());
		System.out.println("Password: " + dataSource.getPassword());
				
		((ConfigurableApplicationContext) context).close();
	}
	
}