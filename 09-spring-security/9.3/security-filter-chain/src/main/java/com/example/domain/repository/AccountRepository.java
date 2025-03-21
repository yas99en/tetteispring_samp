package com.example.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Account;
import com.example.domain.model.Role;

// 書籍に合わせAccountRepositoryというクラス名にしているが、
// JPAの章は後ろの章になるため、データベース接続は3章3節を参考にした内容
@Repository
public class AccountRepository {

	private JdbcTemplate jdbcTemplate;

	public AccountRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Account findOne(String username) {
		String sql = "SELECT login_user.name as name, login_user.password as password, roles.id as role_id, roles.name as role_name FROM login_user, user_role, roles WHERE login_user.id = ? AND login_user.id = user_role.user_id AND user_role.role_id = roles.id";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, username);
		Account account = new Account();
		account.setRoles( new ArrayList<Role>());
		for(Map<String, Object> result: resultList) {
			account.setUsername((String) result.get("name"));
			account.setPassword((String) result.get("password"));
			Role role = new Role();
			role.setId((int) result.get("role_id"));
			role.setName((String) result.get("role_name"));
			account.getRoles().add(role);
		}
		return account;
	}

}
