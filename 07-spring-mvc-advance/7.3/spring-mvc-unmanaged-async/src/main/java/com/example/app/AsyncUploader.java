package com.example.app;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.service.UploadService;

@Component
public class AsyncUploader {

	@Autowired
	UploadService uploadService;
	
	// 7.3.3.2. CompletableFutureを使用した非同期処理の実装 Handlerメソッドの実装例
	// @Asyncを付与したメソッドに、別スレッドで実行したい処理を実装する。
	// upload1(アップロードに5秒かかる想定)の実行
	@Async // 別スレッドで実行される
	public CompletableFuture<String> upload1(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload1 start");
		uploadService.upload1(file); // 重たい処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload1 end");
		
		// 7.3.3.2. CompletableFutureを使用した非同期処理の実装 Handlerメソッドの実装例
		// @Asyncを付与したメソッドの戻り値には、Spring MVCのフレームワーク処理に返却する値(View名)を指定したCompletableFutureを返却する。
		return CompletableFuture.completedFuture("upload/complete"); 
	}
	
	// upload2(アップロード中に例外が発生した想定)の実行
	@Async // 別スレッドで実行される
	public void upload2(MultipartFile file, DeferredResult<String> deferredResult) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload2 start");
		uploadService.upload2(file, deferredResult); // 重たい処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload2 end");
	}
	
	// upload3(アップロードに10秒かかりタイムアウトする想定)の実行
	@Async // 別スレッドで実行される
	public void upload3(MultipartFile file, DeferredResult<String> deferredResult) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload3 start");
		uploadService.upload3(file, deferredResult); // 重たい処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload3 end");
	}
		
}
