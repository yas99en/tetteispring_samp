package com.example;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.domain.service.AuthenticationService;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、プロパティ管理の処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AuthenticationService authenticationService = context.getBean(AuthenticationService.class);
		
		System.out.println("Java ConfigでのBean定義における、@Valueによる設定値のインジェクションに関する動作確認: dataSourceArgumentInjectionにてdataSourceが正しく設定されていることが分かる");
		BasicDataSource dataSource =  (BasicDataSource) context.getBean("dataSourceArgumentInjection", DataSource.class);
		System.out.println("DriverClassName: " + dataSource.getDriverClassName());
		System.out.println("Url: " + dataSource.getUrl());
		System.out.println("Username: " + dataSource.getUsername());
		System.out.println("Password: " + dataSource.getPassword());
		System.out.println();
		
		System.out.println("Java ConfigでのBean定義における、@Valueによる設定値のフィールドへのインジェクションに関する動作確認: dataSourcePropertyInjectionにてdataSourceが正しく設定されていることが分かる");
		dataSource =  (BasicDataSource) context.getBean("dataSourcePropertyInjection", DataSource.class);
		System.out.println("DriverClassName: " + dataSource.getDriverClassName());
		System.out.println("Url: " + dataSource.getUrl());
		System.out.println("Username: " + dataSource.getUsername());
		System.out.println("Password: " + dataSource.getPassword());
		System.out.println();
		
		System.out.println("アノテーションでのBean定義における、@Valueによる設定値のインジェクションに関する動作確認: 認証におけるロック処理が正しく設定されていることが分かる");
		authenticationService.check();
		((ConfigurableApplicationContext) context).close();
	}
	
}