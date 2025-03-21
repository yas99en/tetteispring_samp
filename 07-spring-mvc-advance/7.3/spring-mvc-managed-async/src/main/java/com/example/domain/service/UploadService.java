package com.example.domain.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
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
	
	// アップロードに10秒かかりタイムアウトする想定
	public void upload2(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 start");
		try {
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 uploading...(10s)");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 upload file: " + file);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": UploadService upload2 end");
	}
	
}
