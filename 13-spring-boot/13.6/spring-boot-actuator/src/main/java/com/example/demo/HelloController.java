package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

// 13.6.3.2. カスタムメトリクス情報の登録 MeterRegistryを使用してアクセスカウンタを取得する実装例
@RestController
@RequestMapping("hello")
public class HelloController {
	private final Counter counter;

	@Autowired
	public HelloController(MeterRegistry meterRegistry) {
		counter = meterRegistry.counter("hello.count");
	}

	@GetMapping
	public String hello() {
		// リクエストされた際にカウンタをインクリメント
		counter.increment();
		return "hello";
	}
}