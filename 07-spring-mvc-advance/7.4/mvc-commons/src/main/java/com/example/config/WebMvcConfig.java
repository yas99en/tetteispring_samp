package com.example.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.CommonRequestDataMethodArgumentResolver;
import com.example.interceptor.SuccessLoggingInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("com.example")
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();
	}

	// 7.4.2. HandlerInterceptorの利用
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SuccessLoggingInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/resources/**");
	}

	// 7.4.4. HandlerMethodArgumentResolverの利用
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new CommonRequestDataMethodArgumentResolver());
	}
}
