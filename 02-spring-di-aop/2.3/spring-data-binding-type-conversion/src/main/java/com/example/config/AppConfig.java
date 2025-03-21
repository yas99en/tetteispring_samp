package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

@Configuration
@ComponentScan("com.example.domain")
@PropertySource("classpath:application.properties")
public class AppConfig {

	// 2.3.4. ConversionServiceの利用 Java ConfigによるBean定義例
	@Bean
	public ConversionService conversionService() {
	    return new DefaultFormattingConversionService();
	}

}
