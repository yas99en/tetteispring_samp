package com.example.async;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

// 7.3.5. 非同期実行に対する共通処理の実装 CallableProcessingInterceptorの実装例
public class CustomCallableProcessingInterceptor implements CallableProcessingInterceptor {

	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": CustomCallableProcessingInterceptor handleTimeout");
		return "error/timeoutError";
	}
	
}
