package com.example.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 2.4.1. Bean定義内でプロパティの使用 Java Configにおけるプロパティファイルの場所の設定例
@Configuration
@ComponentScan(basePackages = "com.example.domain")
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Value("${datasource.driver-class-name}")
	String driverClassName;
	
	@Value("${datasource.url}")
	String url;
	
	@Value("${datasource.username}")
	String username;
	
	@Value("${datasource.password}")
	String password;

	// 2.4.2. Beanにプロパティをインジェクション Java ConfigにおけるBean定義でプロパティファイルの値をバインディングする実装例
	@Bean(destroyMethod = "close")
	DataSource dataSourcePropertyInjection() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false);
		
		return dataSource;
	}
	
	// 2.4.1. Bean定義内でプロパティの使用 @Valueによる設定値のインジェクションを利用したDataSource定義の例
	@Bean(destroyMethod = "close")
	DataSource dataSourceArgumentInjection(@Value("${datasource.driver-class-name}") String driverClassName,
	                      @Value("${datasource.url}") String url,
	                      @Value("${datasource.username}") String username,
	                      @Value("${datasource.password}") String password) {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(driverClassName);
	    dataSource.setUrl(url);
	    dataSource.setUsername(username);
	    dataSource.setPassword(password);
	    dataSource.setDefaultAutoCommit(false);
	    
	    return dataSource;
	}
	
}
