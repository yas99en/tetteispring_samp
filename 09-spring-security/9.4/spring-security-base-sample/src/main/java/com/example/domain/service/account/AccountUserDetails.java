package com.example.domain.service.account;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.example.domain.model.Account;

// 9.4.5.1. UserDetailsの作成 Userクラスを継承したUserDetailsの実装クラスの作成例
public class AccountUserDetails extends User {

	private final Account account;

	public AccountUserDetails(Account account, boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
		super(account.getUsername(), account.getPassword(), account.isEnabled(), true, true, true, authorities);
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}
}
