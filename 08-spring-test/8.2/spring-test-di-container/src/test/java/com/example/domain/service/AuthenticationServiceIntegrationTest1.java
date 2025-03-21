package com.example.domain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.config.AppConfig;

// 8.2.7.1. アノテーションに直接指定 プロパティ値を直接指定する際の定義例
@SpringJUnitConfig(classes = AppConfig.class)
@TestPropertySource(properties = "auth.failureCountToLock=3")
@ActiveProfiles("dev") // 適用したいプロファイルの名前を指定
class AuthenticationServiceIntegrationTest1 {
	
	private final AuthenticationService service;
	
	@Autowired
	AuthenticationServiceIntegrationTest1(AuthenticationService service) {
		this.service = service;
	}
	
	@Test
	void propertySourceTest() {
		assertThat(service.getFailureCountToLock(), is(3));
	}
	
}
