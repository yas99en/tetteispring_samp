package com.example.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

// 9.4.7.3. イベントリスナの作成
@Component
public class AuthenticationEventListeners {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationEventListeners.class);

	@EventListener
	public void handleBadCredentials(AuthenticationFailureBadCredentialsEvent event) {
		log.info("Bad credentials is detected. username : {}", event.getAuthentication().getName());
	}

	// ログイン成功時のログを追加
	@EventListener
	public void handleLoginSuccess(AuthenticationSuccessEvent event) {
		log.info("Login Success");
	}

	// ログアウト成功時のログを追加
	@EventListener
	public void handleLogoutSuccess(LogoutSuccessEvent event) {
		log.info("Logout Success");
	}

}
