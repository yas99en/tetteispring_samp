package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.service.UploadService;

@Component
public class AsyncUploader {

	@Autowired
	UploadService uploadService;
	
	// upload1(アップロードに5秒かかる想定)の実行
	public void upload1(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload1 start");
		uploadService.upload1(file); // 重たい処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload1 end");
	}
	
	// upload2(アップロードに10秒かかりタイムアウトする想定)の実行
	public void upload2(MultipartFile file) {
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload2 start");
		uploadService.upload2(file); // 重たい処理を呼び出す
		System.out.println("ThreadName: " + Thread.currentThread().getName() + ": AsyncUploader upload2 end");
	}
	
}
