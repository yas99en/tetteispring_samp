package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 2.1.9.1. Java Configの分割 分割したコンフィギュレーションクラスをインポートするJava Configの実装例(AppConfig.java)
@Configuration
@Import({DomainConfig.class, InfrastructureConfig.class})
public class AppConfig {
	/*
	 * DomainConfig.classとInfrastructureConfig.class に定義したBeanをDIすることができる
	 */
}
