package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.async.CustomCallableProcessingInterceptor;
import com.example.async.CustomDeferredResultProcessingInterceptor;

@Configuration
@EnableWebMvc // 7.3.2.2. Spring MVC上での非同期実行の有効化 Java ConfigによるBean定義 @EnableWebMvcを付与すると非同期実行の機能が自動で有効になる。
@ComponentScan("com.example.app")
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();
	}
	
	// 7.3.2.2. Spring MVC上での非同期実行の有効化 Java ConfigによるBean定義
	// 非同期実行の設定をカスタマイズする場合は、WebMvcConfigurerのconfigureAsyncSupportメソッドをオーバーライドする。
	// タイムアウト時間(ミリ秒単位)は要件に合わせてカスタマイズする。
	@Override 
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) { 
		configurer.setDefaultTimeout(5000);
		// 7.3.2.2. Spring MVC上での非同期実行の有効化 注釈 メモ
		// スレッドプールを利用するようにカスタマイズしたTaskExecutorを設定する
		configurer.setTaskExecutor(mvcTaskExecutor());
		// 7.3.5. 非同期実行に対する共通処理の実装　Java ConfigによるBean定義例　Callableに対する共通処理
		configurer.registerCallableInterceptors(new CustomCallableProcessingInterceptor());
		// 7.3.5. 非同期実行に対する共通処理の実装　Java ConfigによるBean定義例 DeferredResultに対する共通処理
		configurer.registerDeferredResultInterceptors(new CustomDeferredResultProcessingInterceptor());
	}
	
	@Bean 
	public AsyncTaskExecutor mvcTaskExecutor() { 
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); 
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10); 
		executor.setQueueCapacity(25);
		
		return executor;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
}
