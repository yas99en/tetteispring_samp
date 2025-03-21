package com.example.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;

import com.example.app.converter.StringToEmailValueConverter;

@Configuration
@ComponentScan("com.example.domain")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Bean
	public ConversionService conversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		// 2.3.6. Type Conversionのカスタマイズ Java ConfigによるBean定義例
	    // addConverterメソッドの引数に作成したConverterを指定
	    conversionService.addConverter(new StringToEmailValueConverter());
	    // 2.3.7. Field Formattingのカスタマイズ Java ConfigによるBean定義例
	    DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
	    // ISO 8601の拡張形式に変更
	    registrar.setDateFormatter(DateTimeFormatter.ISO_DATE);
	    registrar.registerFormatters(conversionService);
	    return conversionService;
	}

}
