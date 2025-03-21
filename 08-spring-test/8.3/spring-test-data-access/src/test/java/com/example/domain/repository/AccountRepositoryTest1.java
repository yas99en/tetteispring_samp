package com.example.domain.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.config.AppConfig;
import com.example.config.TestConfig;
import com.example.domain.model.Account;

// 8.3.1. テスト用のデータソースの設定 @ContextConfigurationでのBean定義ファイルの指定例
// 8.3.2. テストデータのセットアップ @Sqlを使用したテストデータのセットアップ例
@SpringJUnitConfig(classes = {AppConfig.class, TestConfig.class})
@Sql("/account-delete.sql")
class AccountRepositoryTest1 {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	@Qualifier("jdbcTemplateForAssertion")
	JdbcTemplate jdbcTemplate;

	// クラスレベルに指定した@Sql("/account-delete.sql")により、関連データが削除されてから本メソッドが実行される
	@Test
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

	// メソッドレベルに指定した@Sql({ "/account-delete.sql", "/account-insert-data.sql" })により、関連データが初期化されてから本メソッドが実行される
	@Test
	@Sql({ "/account-delete.sql", "/account-insert-data.sql" })
	void testFindOne() {
		// 1行目のデータを検証
		Account account = accountRepository.fineOne("001");
		assertThat(account.getId(), is("001"));
		assertThat(account.getName(), is("Spring太郎"));
		// 2行目のデータを検証
		account = accountRepository.fineOne("002");
		assertThat(account.getId(), is("002"));
		assertThat(account.getName(), is("Spring次郎"));
	}

}
