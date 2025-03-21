package com.example.async;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

//7.3.5. 非同期実行に対する共通処理の実装 DeferredResultProcessingInterceptorの実装例
public class CustomDeferredResultProcessingInterceptor implements DeferredResultProcessingInterceptor {

	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": CustomDeferredResultProcessingInterceptor handleTimeout");
		deferredResult.setResult((T)"error/timeoutError"); // timeoutのページに遷移するがスレッドの処理自体は続く点に注意
		return false;
	}
	
}
