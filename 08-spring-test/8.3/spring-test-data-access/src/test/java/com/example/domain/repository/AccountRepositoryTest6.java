package com.example.domain.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.example.config.AppConfig;
import com.example.config.TestConfig;
import com.example.domain.mapper.AccountMapper;
import com.example.domain.model.Account;

//8.3.3.3. 永続コンテキストのフラッシュ MyBatis利用時のフラッシュ方法
@ActiveProfiles("mybatis") // 適用したいプロファイルの名前を指定
@SpringJUnitConfig(classes = {AppConfig.class, TestConfig.class})
class AccountRepositoryTest6 {

	@Autowired
	AccountMapper accountMapper;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	@Qualifier("jdbcTemplateForAssertion")
	JdbcTemplate jdbcTemplate;

	// メソッドレベルに指定した@Sql("/account-delete.sql")により、関連データが削除されてから本メソッドが実行される
	@Test
	@Transactional
	@Sql("/account-delete.sql")
	void testCreate2() {
		Account account = new Account();
		account.setId("001");
		account.setName("Spring太郎");
		accountMapper.create(account);
		// フラッシュしていないのでデータベースにまだ反映されていないことを確認
		assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account", Integer.class), is(0));
		// 永続コンテキストのフラッシュ MyBatis利用時のフラッシュ方法
		sqlSession.flushStatements();
		// フラッシュしたのでデータベースに反映されたことを確認
		assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account", Integer.class), is(1));
		
		// 8.3.4. テーブルの中身の検証 JdbcTemplateを使用したレコードの検証例
		// JdbcTemplateを使用して登録したレコードをデータベースから取得
		Map<String, Object> createdAccount = jdbcTemplate.queryForMap("SELECT id, name FROM account WHERE id = '001'");
		// 取得したレコードの妥当性を検証
		assertThat(createdAccount.get("id"), is("001"));
		assertThat(createdAccount.get("name"), is("Spring太郎"));
	}

}
