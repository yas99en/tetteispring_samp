package com.example.domain.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Account;

@Profile("default") // デフォルトのRepository定義
@Repository
public class AccountRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void create(Account account) {
		final String sql = "INSERT INTO account(id, name) values(?, ?)";
		jdbcTemplate.update(sql, account.getId(), account.getName());
	}

	public Account fineOne(String id) {
		final String sql = "SELECT id, name FROM account WHERE id = ?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);
		Account account = new Account();
		account.setId((String) result.get("id"));
		account.setName((String) result.get("name"));

		return account;
	}
	
}
