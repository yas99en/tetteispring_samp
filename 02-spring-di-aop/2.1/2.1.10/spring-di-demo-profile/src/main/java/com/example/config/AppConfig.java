package com.example.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "com.example.domain")
@Import({DevConfig.class, ProdConfig.class})
public class AppConfig {
	// 2.1.10.1. プロファイルの定義方法 メソッドレベルにプロファイル名を指定したJava Configの実装例
	@Bean(name = "dataSource")
	@Profile("test")
	DataSource dataSourceForTest() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
		dataSource.setUsername("test");
		dataSource.setPassword("test");
		
		return dataSource;
	}
	
	// 2.1.10.1. プロファイルの定義方法 メソッドレベルにプロファイル名を指定したJava Configの実装例
	@Bean(name = "dataSource")
	@Profile("development")
	DataSource dataSourceForDev() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/development");
		dataSource.setUsername("development");
		dataSource.setPassword("development");
		
		return dataSource;
	}
	
	// 2.1.10.1. プロファイルの定義方法 メソッドレベルにプロファイル名を指定したJava Configの実装例
	@Bean(name = "dataSource")
	@Profile("production")
	DataSource dataSourceForProd() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/production");
		dataSource.setUsername("production");
		dataSource.setPassword("production");
		
		return dataSource;
	}
	
}
