package com.example.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {
	
	// 2.7.2.1. MessageSourceのBean定義 Java ConfigによるBean定義例
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// クラスパス上に格納されているプロパティファイル(拡張子は除く)を指定する
		messageSource.setBasenames("messages");
		// 2.7.3. ネイティブコードのメッセージ定義 オプションの指定例
		// ネイティブコードのエンコーディングを指定
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
		
}