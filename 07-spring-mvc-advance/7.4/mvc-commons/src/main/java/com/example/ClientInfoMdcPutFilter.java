package com.example;

import java.io.IOException;

import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

// 7.4.1.1. DIコンテナで管理しているBeanのインジェクション
@Component("clientInfoMdcPutFilter") // サーブレットフィルタをDIコンテナに登録
public class ClientInfoMdcPutFilter extends OncePerRequestFilter {
	private static final String MDC_KEY = "greetMsg";

	@Autowired
	MessageSource messageSource; // 利用するBeanをインジェクションする

	@Override
	protected final void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

		String name = request.getRemoteHost();
		String greetMsg = messageSource.getMessage("greeting", new String[] { name }, Locale.ROOT);
		MDC.put(MDC_KEY, greetMsg);
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.remove(MDC_KEY);
		}
	}
}
