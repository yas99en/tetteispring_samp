package com.example.app;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AsyncController {
	
	@Autowired
	AsyncUploader asyncUploader;
	
	// 7.3.1.1. 非同期実行が終了してからHTTPレスポンスを開始 Spring MVC管理のスレッドを使用した非同期処理
	// Handlerメソッドからjava.util.concurrent.Callableを返却
	@PostMapping("upload1")
	public Callable<String> upload1(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload1 start");
		Callable<String> upload = () -> {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": Callable call start");
			asyncUploader.upload1(file); // 非同期処理を呼び出す
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": Callable call end");
            return "upload/complete";
        };
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload1 end");
		
		return upload;
	}
	
	// 7.3.1.1. 非同期実行が終了してからHTTPレスポンスを開始 Spring MVC管理のスレッドを使用した非同期処理
	// Handlerメソッドからjava.util.concurrent.Callableを返却
	@PostMapping("upload2")
	public Callable<String> upload2(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload2 start");
		Callable<String> upload = () -> {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": Callable call start");
			asyncUploader.upload2(file); // 非同期処理を呼び出す
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": Callable call end");
            return "upload/complete";
        };
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncController upload2 end");
		
		return upload;
	}
	
}
