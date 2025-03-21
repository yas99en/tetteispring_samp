package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.Account;
import com.example.domain.service.account.AuthorizationService;

@Controller
@RequestMapping("general")
public class GeneralController {

	private AuthorizationService authorizationService;

	@Autowired
	public GeneralController(AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}

	@GetMapping()
	public String general() {
		AccessDeniedException exception = null;

		try {
			// 9.5.5.2 @PreAuthorizeのついたメソッド呼び出し
			// 引数に"管理者ユーザー"を指定した場合、@PreAuthorizeのValue属性がtrueになりメソッドが実行される
			// 引数に"一般ユーザー"を指定した場合、一般ユーザーでログインしていれば@PreAuthorizeのvalue属性がtrueになる
			Account result = authorizationService.findOne("一般ユーザー");
			System.out.println("9.5.5.2 @PreAuthorizeメソッド 実行結果確認 : " + result.getUsername());
		} catch (AccessDeniedException e) {
			System.out.println("9.5.5.2 @PreAuthorizeメソッド アクセス不可");
			exception = e;
		}

		try {
			// 9.5.5.3 @PostAuthorizeのついたメソッド呼び出し
			// 引数に指定したユーザー名とログインで使用したユーザー名が一致した場合、@PostAuthorizeのvalue属性がtrueになる
			Account result = authorizationService.findOneByPostAuthorize("管理者ユーザー");
			System.out.println("9.5.5.3 @PostAuthorizeメソッド 実行結果確認 : " + result.getUsername());
		} catch (AccessDeniedException e) {
			System.out.println("9.5.5.3 @PostAuthorizeメソッド アクセス不可");
			exception = e;
		}

		if (exception != null) {
			throw exception;
		}

		return "general";
	}
}
