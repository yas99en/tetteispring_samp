package com.example.domain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 8.2.4.1. デフォルトのBean定義ファイル staticなコンフィギュレーションクラス(内部クラス)の作成例
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class MessageServiceIntegrationTest2 {

	@Configuration
	static class LocalContext {
		// Bean定義
		@Bean // MessageSourceのBean定義
		public MessageSource messageSource() {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.setBasenames("messages");
			return messageSource;
		}
		
		@Bean // MessageServiceのBean定義
		public MessageService messageService() {
			MessageService messageService = new MessageService();
			return messageService;
		}
	}

	@Autowired
	MessageService service;

	@Test
	void testGetMessageByCode() {
		String actualMessage = service.getMessageByCode("greeting");
		assertThat(actualMessage, is("Hello!!"));
	}

}
