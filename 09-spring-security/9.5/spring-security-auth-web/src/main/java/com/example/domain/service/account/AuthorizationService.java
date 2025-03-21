package com.example.domain.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.domain.model.Account;
import com.example.domain.repository.AccountRepository;

// 9.5.5 メソッドへの認可
@Service
public class AuthorizationService {
	
	private AccountRepository accountRepository;
	
	@Autowired
	public AuthorizationService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	// 9.5.5.2 メソッド実行前に適用するアクセスポリシーの指定
	@PreAuthorize("hasRole('ADMIN') or (#username == principal.username)")
	public Account findOne(String username) {
	    return accountRepository.findOneByName(username);
	}
	
	// 9.5.5.3 メソッド実行後に適用するアクセスポリシーの指定
	// 書籍では「departmentCode」にアクセスする例が記載されていますが、本実装では戻り値が「Account」のため「Account.username」にアクセスしています。
	@PostAuthorize("(returnObject == null) or (returnObject.username == principal.username)")
	public Account findOneByPostAuthorize(String username) {
		return accountRepository.findOneByName(username);
	}

}
