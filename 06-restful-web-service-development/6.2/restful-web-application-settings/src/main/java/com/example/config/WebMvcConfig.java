package com.example.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//6.2.3.2. HttpMessageConverterのカスタマイズ Java ConfigによるBean定義例
@Configuration
@EnableWebMvc
@ComponentScan("com.example.app")
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();
    }
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter(
		Jackson2ObjectMapperBuilder.json().indentOutput(true).build());
	}

	// インターフェイスWebMvcConfigurerを実装し、extendMessageConvertersメソッドをオーバーライドする。 
	// メソッドの引数には、デフォルトのHttpMessageConverterが格納されているリストが渡される。
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, mappingJackson2HttpMessageConverter()); // 引数で受け取ったリストの先頭に、任意のHttpMessageConverterを追加する。
	}
	
}
