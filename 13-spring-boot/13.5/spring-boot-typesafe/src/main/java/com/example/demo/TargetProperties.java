package com.example.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

// 13.5.1. @ConfigurationPropertiesを用いたプロパティの設定 @ConfigurationPropertiesの使用例
@Component
@ConfigurationProperties(prefix = "target")
// 13.5.2. Bean Validationによるプロパティ値のチェック Bean Validationのアノテーションの指定例
@Validated
public class TargetProperties {
	@NotEmpty
    private String host;
	@Min(1)
	@Max(65535)
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}