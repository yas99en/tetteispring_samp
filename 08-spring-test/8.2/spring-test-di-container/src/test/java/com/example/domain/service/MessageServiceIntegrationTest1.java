package com.example.domain.service;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.config.AppConfig;

// 8.2.2.2. テストケースの作成と実行 結合テスト用のテストケースクラス
// 8.2.4. DIコンテナのコンフィギュレーション Bean定義をJava Configで行なう場合の指定例
// 8.2.5.2. DIコンテナの破棄 テストケースクラス内の全テストが終了したタイミングで破棄する例
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("dev") // 適用したいプロファイルの名前を指定
@DirtiesContext
class MessageServiceIntegrationTest1 {

	@Autowired
	MessageService service;

	@Test
	@DirtiesContext
	void testGetMessageByCode() {
		String actualMessage = service.getMessageByCode("greeting");
		assertThat(actualMessage, is("Hello!!"));
	}

}
