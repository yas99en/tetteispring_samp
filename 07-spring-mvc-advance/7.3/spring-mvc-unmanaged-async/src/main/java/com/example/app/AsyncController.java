package com.example.app;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class AsyncController {
	
	@Autowired
	AsyncUploader asyncUploader;
	
	@Autowired
	GreetingMessageSender greetingMessageSender;
	
	// 7.3.3.2. CompletableFutureを使用した非同期処理の実装 Handlerメソッドの実装例
	// Handlerメソッドの戻り値としてCompletableFutureを返却する。
	// 型パラメータには、非同期処理が正常終了したときにSpring MVCのフレームワーク処理に返却する値の型を指定する。
	// ここでは遷移先のView名を返却するため、型パラメータにはStringを指定する。
	@PostMapping("upload1")
	public CompletableFuture<String> upload1(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload1 start");
		CompletableFuture<String> upload = asyncUploader.upload1(file); // 非同期処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload1 end");
		
		return upload;
	}

	// 7.3.1.1. 非同期実行が終了してからHTTPレスポンスを開始 Spring MVC管理外のスレッドを使用した非同期処理
	// DeferredResultを使用した非同期処理の実装 Handlerメソッドの実装例
	// Handlerメソッドの戻り値としてDeferredResultを返却する。
	@PostMapping("upload2")
	public DeferredResult<String> upload2(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload2 start");
		DeferredResult<String> deferredResult = new DeferredResult<String>(5 * 1000L);
		asyncUploader.upload2(file, deferredResult); // 非同期処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload2 end");
		
		return deferredResult;
	}
	
	// 7.3.1.1. 非同期実行が終了してからHTTPレスポンスを開始 Spring MVC管理外のスレッドを使用した非同期処理
	// DeferredResultを使用した非同期処理の実装 Handlerメソッドの実装例
	// Handlerメソッドの戻り値としてDeferredResultを返却する。
	@PostMapping("upload3")
	public DeferredResult<String> upload3(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload3 start");
		DeferredResult<String> deferredResult = new DeferredResult<String>(5 * 1000L);
		deferredResult.onTimeout(() -> {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": deferredResult onTimeout");
		});
		asyncUploader.upload3(file, deferredResult); // 非同期処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload3 end");
		
		return deferredResult;
	}
	
	// 7.3.3.3. SseEmitterを使用したPush型の非同期処理の実装 Handlerメソッドの実装例
	// Handlerメソッド戻り値としてSseEmitterを返却する。
	@GetMapping("greeting")
	public SseEmitter greeting() throws IOException, InterruptedException {
		SseEmitter emitter = new SseEmitter();
		greetingMessageSender.send(emitter); // 非同期処理を呼び出す
		return emitter;
	}
		
}
