package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 10.5.6. Open EntityManager in Viewパターンの設定 Java ConfigによるBean定義例
@Configuration
@EnableWebMvc
@ComponentScan({"com.example.app", "com.example.domain"})
@Import(JpaConfig.class)
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();
	}

	@Bean
	public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
		return new OpenEntityManagerInViewInterceptor();
	}

	// OpenEntityManagerInViewInterceptorをインターセプト処理として登録し、
	// トランザクション終了後にEntityManagerが閉じないようにする。
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/**/*.html")
		.excludePathPatterns("/**/*.js")
		.excludePathPatterns("/**/*.css")
		.excludePathPatterns("/**/*.png");
	}
}