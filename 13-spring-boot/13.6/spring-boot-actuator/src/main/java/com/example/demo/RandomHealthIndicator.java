package com.example.demo;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// 13.6.2. ヘルスチェック 独自のヘルスチェックの実装例
@Component
public class RandomHealthIndicator implements HealthIndicator{
	private Random random = new Random();

	@Override
	public Health health() {
		if (random.nextBoolean()) {
			return Health.up().build();
		} else {
			return Health.down().withDetail("error_code", 100).build();
		}
	}
}
