package com.example.domain.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.AppConfig;
import com.example.config.TestConfig;
import com.example.domain.model.Account;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Testの実行順番を指定
@SpringJUnitConfig(classes = {AppConfig.class, TestConfig.class})
class AccountRepositoryTest2 {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	@Qualifier("jdbcTemplateForAssertion")
	JdbcTemplate jdbcTemplate;
	
	// 8.3.3.1. トランザクション境界の移動 トランザクション境界をテストケースメソッドの前に移動する際の指定例
	// メソッドレベルに指定した@Sql("/account-delete.sql")により、関連データが削除されてから本メソッドが実行される
	@Test
	@Order(1) // Testの実行順番を指定
	@Sql("/account-delete.sql")
	@Transactional // メソッドレベルに指定
	void testCreate() {
		Account account = new Account();
		account.setId("001");
		account.setName("Spring太郎");
		accountRepository.create(account);
		
		// 8.3.4. テーブルの中身の検証 JdbcTemplateを使用したレコードの検証例
		// JdbcTemplateを使用して登録したレコードをデータベースから取得
		Map<String, Object> createdAccount = jdbcTemplate.queryForMap("SELECT id, name FROM account WHERE id = '001'");
		// 取得したレコードの妥当性を検証
		assertThat(createdAccount.get("id"), is("001"));
		assertThat(createdAccount.get("name"), is("Spring太郎"));
		// データベースのレコード数の妥当性を検証
		assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account", Integer.class), is(1));
	}

	// トランザクションが効いているか確認するため、上のtestCreate()で登録したデータが残っていないことを検証
	@Test
	@Order(2) // Testの実行順番を指定
	void testTransaction() {
		assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account", Integer.class), is(0));
	}

}
