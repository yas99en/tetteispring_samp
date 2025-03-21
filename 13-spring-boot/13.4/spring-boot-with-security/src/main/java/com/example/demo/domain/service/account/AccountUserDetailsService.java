package com.example.demo.domain.service.account;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.model.Account;
import com.example.demo.domain.repository.AccountRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {
	
	private AccountRepository accountRepository;
	
	public AccountUserDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = Optional.ofNullable(accountRepository.findOne(username))
				.orElseThrow(() -> new UsernameNotFoundException("user not found."));
		return new AccountUserDetails(account, getAuthorities(account));
	}
	
	private Collection<GrantedAuthority> getAuthorities(Account account) { 
		if (account.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER"); 
		}
	}

}
