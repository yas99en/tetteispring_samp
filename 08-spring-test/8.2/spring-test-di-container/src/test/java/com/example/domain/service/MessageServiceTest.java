package com.example.domain.service;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

// 8.2.1. Beanの単体テスト 固定のメッセージを返却するクラスのJUnitテストケース
// 8.2.1. Beanの単体テスト MessageSourceからメッセージを取得するクラスのJUnitテストケース
@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

	@InjectMocks
	MessageService service;

	@Mock
	MessageSource mockMessageSource;

	@Test
	void testGetMessage() {
		MessageService service = new MessageService();
		String actualMessage = service.getMessage();
		assertThat(actualMessage, is("Hello!!"));
	}

	@Test
	void testGetMessgeByCode() {
		doReturn("Hello!!").when(mockMessageSource)
			.getMessage("greeting", null, Locale.getDefault());

		// テストを行なう。
		String actualMessage = service.getMessageByCode("greeting");
		assertThat(actualMessage, is("Hello!!"));
	}

}
