package com.example.app;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class GreetingMessageSender {
	
	// 7.3.3.3. SseEmitterを使用したPush型の非同期処理の実装 Handlerメソッドの実装例
	// @Asyncを付与したメソッドで、イベントを送信する処理を実装する。
	// クライアントに送信するイベントは、Handlerメソッドの戻り値として返却したSseEmitterオブジェクトのメソッドを使う。
	@Async
	public void send(SseEmitter emitter) throws IOException, InterruptedException {
		// 1秒間隔でイベントを送信する
		emitter.send(SseEmitter.event().id(UUID.randomUUID().toString()).data("Good Morning!"));
		TimeUnit.SECONDS.sleep(1);
		emitter.send(SseEmitter.event().id(UUID.randomUUID().toString()).data("Hello!"));
		TimeUnit.SECONDS.sleep(1);
		emitter.send(SseEmitter.event().id(UUID.randomUUID().toString()).data("Good Night!"));
		// 非同期処理を終了する
		emitter.complete();
	}
	
}
