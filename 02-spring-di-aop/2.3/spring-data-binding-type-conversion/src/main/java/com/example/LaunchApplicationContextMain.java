package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.domain.model.ApplicationProperties;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、データバインディング処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationProperties properties = context.getBean(ApplicationProperties.class);
		System.out.println("healthCheckEnabled is " + properties.getHealthCheckEnabled());
		System.out.println("dateOfServiceStarting1 is " + properties.getDateOfServiceStarting1());
		System.out.println("dateOfServiceStarting2 is " + properties.getDateOfServiceStarting2());
		((ConfigurableApplicationContext) context).close();
	}
	
}
