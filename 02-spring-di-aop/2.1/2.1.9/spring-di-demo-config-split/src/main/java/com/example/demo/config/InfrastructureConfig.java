package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 2.1.9.1. Java Configの分割 分割したコンフィギュレーションクラスの実装例(InfrastructureConfig.java)
@Configuration
public class InfrastructureConfig {
	@Bean
	DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/default");
		dataSource.setUsername("default");
		dataSource.setPassword("default");
				
		return dataSource;
    }
}
