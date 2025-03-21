package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 2.1.6.1. デフォルトのコンポーネントスキャン 適切なコンポーネントスキャン対象の指定例
// 2.1.6.2. フィルタを明示したコンポーネントスキャン スキャン対象から除外するコンポーネントを指定するための設定例(Java Configの場合)
// @Excludeが付与されているクラスをスキャン対象から除外する
@Configuration
@ComponentScan(basePackages = "com.example.demo.domain", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Exclude.class})
})
public class AppConfig {
}
