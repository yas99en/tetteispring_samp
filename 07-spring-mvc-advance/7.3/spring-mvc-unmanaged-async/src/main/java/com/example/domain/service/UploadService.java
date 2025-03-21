package com.example.domain.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadService {
	
	// アップロードに5秒かかる想定
	public void upload1(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload1 start");
		try {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload1 uploading...(5s)");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload1 upload file: " + file);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload1 end");
	}

	// アップロード中に例外が発生した想定
	public void upload2(MultipartFile file, DeferredResult<String> deferredResult) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 start");
		try {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 uploading...(5s)");
			int i = 1 / 0; // 例外を発生させる
			TimeUnit.SECONDS.sleep(5);
			deferredResult.setResult("upload/complete");
		} catch (InterruptedException e) {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": 例外: " + e.getClass().getName() + ": " + e.getMessage()); // 発生した例外を表示する
			deferredResult.setErrorResult(e); // 発生した例外をDeferredResultに設定する
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": 例外: " + e.getClass().getName() + ": " + e.getMessage()); // 発生した例外を表示する
			deferredResult.setErrorResult(e); // 発生した例外をDeferredResultに設定する
		}
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 end");
	}

	// アップロードに10秒かかりタイムアウトする想定
	public void upload3(MultipartFile file, DeferredResult<String> deferredResult) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload3 start");
		try {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload3 uploading...(10s)");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload3 upload file: " + file);
		} catch (InterruptedException e) {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": 例外: " + e.getClass().getName() + ": " + e.getMessage()); // 発生した例外を表示する
			deferredResult.setErrorResult(e); // 発生した例外をDeferredResultに設定する
			Thread.currentThread().interrupt();
		} catch (Exception e) {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": 例外: " + e.getClass().getName() + ": " + e.getMessage()); // 発生した例外を表示する
			deferredResult.setErrorResult(e); // 発生した例外をDeferredResultに設定する
		}
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload3 end");
	}
	
}
