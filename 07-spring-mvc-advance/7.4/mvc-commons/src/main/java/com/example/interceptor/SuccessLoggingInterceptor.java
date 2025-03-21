package com.example.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 7.4.2. HandlerInterceptorの利用
public class SuccessLoggingInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(SuccessLoggingInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) {
		if (logger.isInfoEnabled()) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			logger.info("[SUCCESS CONTROLLER] {}.{}",
					method.getDeclaringClass().getSimpleName(), method.getName());
		}
	}
}
