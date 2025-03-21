package com.example.app;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.config.AppConfig;

// 8.2.4.2. Webアプリケーション向けのDIコンテナのコンフィギュレーション 各種モックオブジェクトのインジェクション例
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
// 8.2.6. プロファイルの指定 テスト実行時に適用するプロファイルの指定例
@ActiveProfiles("dev") // 適用したいプロファイルの名前を指定
class WebApplicationIntegrationTest {
	
	@Autowired
	MockServletContext mockServletContext; // テストケースメソッド間で共有される
	
	@Autowired
	MockHttpSession mockSession;
	
	@Autowired
	MockHttpServletRequest mockRequest;
	
	@Autowired
	MockHttpServletResponse mockResponse;
	
	@Autowired
	DataSource dataSource;
	
	@Test
	void DITest() {
		// @WebAppConfigurationにより
		// MockServletContext、MockHttpSession、MockHttpServletRequest、MockHttpServletResponseの
		// インジェクションができていることを確認する
		assertThat(mockServletContext, notNullValue());
		assertThat(mockSession, notNullValue());
		assertThat(mockRequest, notNullValue());
		assertThat(mockResponse, notNullValue());
	}
	
	@Test
	void ActiveProfilesTest() {
		try (Connection conn = dataSource.getConnection()) {
			// 接続先データベースの情報を確認する
			assertThat(conn.getMetaData().getDatabaseProductName(), is("H2"));
		} catch (SQLException e) {
			e.printStackTrace();
			fail("ActiveProfilesTestが失敗した", e);
		}
	}
	
}
