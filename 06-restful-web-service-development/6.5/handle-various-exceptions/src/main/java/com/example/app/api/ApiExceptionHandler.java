package com.example.app.api;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final Map<Class<? extends Exception>, String> messageMappings;
	
	// 6.5.2 例外メッセージを変換する場合の例外ハンドラクラスの実装例
	public ApiExceptionHandler() {
		LinkedHashMap<Class<? extends Exception>, String> map = new LinkedHashMap<>();
		map.put(HttpMessageNotReadableException.class, "Request body is invalid");
		map.put(MethodArgumentNotValidException.class, "Request value is invalid");
		messageMappings = Collections.unmodifiableMap(map);
	}

	private String resolveMessage(Exception ex, String defaultMessage) {
		return messageMappings.entrySet().stream()
				.filter(entry -> entry.getKey().isAssignableFrom(ex.getClass()))
				.findFirst()
				.map(Map.Entry::getValue).orElse(defaultMessage);
	}

	private ApiError createApiError(Exception ex) {
		ApiError apiError = new ApiError();
		apiError.setMessage(resolveMessage(ex, ex.getMessage()));
		apiError.setDocumentationUrl("http://example.com/api/errors");
		return apiError;
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = createApiError(ex);
		return super.handleExceptionInternal(
				ex, apiError, headers, status, request);
	}

	// 6.5.3 ユーザー定義の例外のハンドリング例
	@ExceptionHandler
	public ResponseEntity<Object> handleBookNotFoundException(
			BookNotFoundException ex, WebRequest request) {
		return handleExceptionInternal(
				ex, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	// 6.5.3 システム例外のハンドリング例
	@ExceptionHandler
	public ResponseEntity<Object> handleSystemException(
			Exception ex, WebRequest request) {
		ApiError apiError = createApiError(ex, "System error is occurred");
		return super.handleExceptionInternal(
				ex, apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	private ApiError createApiError(Exception ex, String defaultMessage) {
		ApiError apiError = new ApiError();
		apiError.setMessage(resolveMessage(ex, defaultMessage));
		apiError.setDocumentationUrl("http://example.com/api/errors");
		return apiError;
	}

	// 6.5.4 エラーの詳細情報を追加する実装例
	@Autowired
	MessageSource messageSource;

	private String getMessage(MessageSourceResolvable resolvable, WebRequest request) {
		return messageSource.getMessage(resolvable, request.getLocale());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = createApiError(ex, ex.getMessage());
		// オブジェクトに紐付けられているエラーオブジェクトの追加
		ex.getBindingResult().getGlobalErrors().stream()
				.forEach(e -> apiError.addDetail(e.getObjectName(), getMessage(e, request)));
		// フィールドに紐付けられているエラーオブジェクトの追加
		ex.getBindingResult().getFieldErrors().stream()
				.forEach(e -> apiError.addDetail(e.getField(), getMessage(e, request)));
		return super.handleExceptionInternal(
				ex, apiError, headers, status, request);
	}

}
