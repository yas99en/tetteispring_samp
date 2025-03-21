package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync // 7.3.3.1. @Asyncの利用 Java ConfigによるBean定義 	@EnableAsyncを付与すると@Asyncを利用した非同期実行の機能が有効になる。
public class AsyncConfig {
	
	// 7.3.3.1. @Asyncの利用 Java ConfigによるBean定義
	// @Asyncがデフォルトで使用するTaskExecutorは、要求ごとに新しいスレッドを生成する実装クラス(SimpleAsyncTaskExecutor)である。
	// 使用するTaskExecutorをカスタマイズする場合は、"taskExecutor"というBean名でBean定義しておけばよい。
	// ここでは、スレッドプールを利用するようにカスタマイズしたTaskExecutorをBean定義している。
	@Bean
	public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);

        return executor;
    }
	
}
