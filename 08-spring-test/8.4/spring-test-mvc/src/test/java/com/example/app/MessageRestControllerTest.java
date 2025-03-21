package com.example.app;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.config.AppConfig;
import com.example.config.WebMvcConfig;
import com.example.domain.service.MessageService;

// 8.4.2.2. スタンドアロンモード 依存コンポーネントをモック化する場合のセットアップ例
@ExtendWith(MockitoExtension.class)
@SpringJUnitWebConfig(classes = {WebMvcConfig.class, AppConfig.class})
class MessageRestControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	MessageRestController controller;

	@Mock
	MessageService mockMessageService;

	@BeforeEach
	void setupMockMvc() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testGetMessage() throws Exception {
		doReturn("Hello!!").when(mockMessageService).getMessage();

		// 8.4.2.2. スタンドアロンモード 依存コンポーネントをモック化する場合のセットアップ例のテストを行なう。
		mockMvc.perform(get("/message")
				.header("X-Track-Id", UUID.randomUUID().toString()))
				.andExpect(status().isOk());
	}

}
