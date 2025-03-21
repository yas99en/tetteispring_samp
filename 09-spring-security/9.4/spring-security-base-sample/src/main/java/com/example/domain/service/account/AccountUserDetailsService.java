package com.example.domain.service.account;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Account;
import com.example.domain.repository.AccountRepository;

// 9.4.5.2. UserDetailsServiceの作成
@Service
@Import(AccountRepository.class)
public class AccountUserDetailsService implements UserDetailsService {

	private AccountRepository accountRepository;

	@Autowired
	public AccountUserDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = Optional.ofNullable(accountRepository.findOne(username))
				.orElseThrow(() -> new UsernameNotFoundException("user not found."));
		// Userクラスを継承したUserDetailsの実装クラスのため、本書とはコンストラクタが異なります。
		return new AccountUserDetails(account, true, true, true, getAuthorities(account));
	}

	private Collection<GrantedAuthority> getAuthorities(Account account) {
		// 認可
		if (account.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}

}
