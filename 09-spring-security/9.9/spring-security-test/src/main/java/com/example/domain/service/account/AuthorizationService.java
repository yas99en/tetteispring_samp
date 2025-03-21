package com.example.domain.service.account;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.example.domain.model.Account;

@Service
public class AuthorizationService {

	@PreAuthorize("hasRole('ADMIN') or (#username == principal.username)")
	// @Pをつけると明示的に引数名を指定する
	public void test(@P("username") String username) {
		System.out.println("====9.5.5 test====");
	}
	
	@PostAuthorize("(returnObject == null) or (returnObject.username == principal.username)")
	public Account testPostAuthorize(String username) {
		System.out.println("====9.5.5 test====");
		System.out.println(username);
		Account account = new Account();
		account.setUsername(username);
		return account;
	}

}
