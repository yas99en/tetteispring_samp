package com.example.app.api;

import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 6.5.5 エラー応答用のControllerの実装例
@RestController
public class ApiErrorPageController {

	@GetMapping("/error")
	public ApiError handleError(HttpServletRequest request) {

		String message;
		Exception ex = (Exception) request.getAttribute(
				RequestDispatcher.ERROR_EXCEPTION);
		Integer statusCode = (Integer) request.getAttribute(
				RequestDispatcher.ERROR_STATUS_CODE);
		if (ex != null) {
			message = ex.getMessage(); // メッセージの解決方法は見直しましょう
		} else {
			if (Arrays.asList(HttpStatus.values()).stream()
					.anyMatch(status -> status.value() == statusCode)) {
				message = HttpStatus.valueOf(statusCode).getReasonPhrase();
			} else {
				message = "Custom error(" + statusCode + ") is occurred";
			}
		}

		ApiError apiError = new ApiError();
		apiError.setMessage(message);
		apiError.setDocumentationUrl("http://example.com/api/errors/");
		return apiError;
	}
}
