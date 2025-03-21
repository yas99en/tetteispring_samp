package com.example.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

// 8.2.2.1. Bean定義ファイルの作成 Java ConfigによるBean定義例
@Configuration
@ComponentScan("com.example.domain")
public class AppConfig {

	@Bean // MessageSourceのBean定義
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");
		return messageSource;
	}

}
