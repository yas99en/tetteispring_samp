package com.example.domain.service.account;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.example.domain.model.Account;

@Service
public class AuthorizationService {

	@PreAuthorize("hasRole('ADMIN') or (#username == principal.username)")
	public void test(@P("username") String username) {
	}

	@PostAuthorize("(returnObject == null) or (returnObject.username == principal.username)")
	public Account testPostAuthorize(String username) {
		Account account = new Account();
		account.setUsername(username);
		return account;
	}
}
