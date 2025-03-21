package com.example.app;

// 8.4.2.4. staticメソッドのインポート staticメソッドのインポート例
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

// 8.4.2.2. スタンドアロンモード スタンドアロンモードのセットアップ例
// DIコンテナを生成するためのアノテーションは不要
class WelcomeControllerStandAloneTest {

	MockMvc mockMvc;

	@BeforeEach
	void setupMockMvc() {
		this.mockMvc = MockMvcBuilders
						.standaloneSetup(new WelcomeController())
						// 8.4.2.3. サーブレットフィルタの追加 サーブレットフィルタの追加例
						// サーブレットフィルタの追加
						.addFilters(new CharacterEncodingFilter("UTF-8"))
						.build();
	}

	@Test
	void testHome() throws Exception {
		// 8.4.3. テストの実行 「GET /」に対するテストの実装例
		// 8.4.4. リクエストデータのセットアップ リクエストデータのセットアップ例
		// 8.4.5. 実行結果の検証 実行結果の検証例
		// 8.4.6. 実行結果の出力 実行結果をログに出力する際の実装例
		mockMvc.perform(get("/")
					.param("name", "Spring")
					.accept(MediaType.APPLICATION_JSON)
					.header("X-Track-Id", UUID.randomUUID().toString()))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("index"))
				.andExpect(header().exists("Content-Language"))
				.andDo(log());
	}

}
