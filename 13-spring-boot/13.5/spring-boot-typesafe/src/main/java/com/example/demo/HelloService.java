package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	// 13.5. Spring Bootで型安全なプロパティ設定 プロパティのインジェクション例
	@Value("${target.host}")
	String host;
	@Value("${target.port}")
	int port;
	
	public String hello1() {
		String target = "http://" + host + ":" + port;
		return target;
 	}

	// 13.5.1. @ConfigurationPropertiesを用いたプロパティの設定 @ConfigurationPropertiesを付与したBeanの利用例
	@Autowired
	TargetProperties targetProperties;

	public String hello2() {
		String target = "http://" + targetProperties.getHost() + ":" + targetProperties.getPort();
		return target;
	}
	
	@Autowired
	TargetProperties1 targetProperties1;

	public String hello3() {
		String target = "http://" + targetProperties1.getHost1() + ":" + targetProperties1.getPort1();
		return target;
	}
}