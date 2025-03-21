package com.example.app;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	// プロパティからリソースの取得先を取得してResourceオブジェクトをインジェクション
	// プロパティ値の指定がなければデフォルト値(http://localhost:8080/{コンテキストパス}/greeting.json)が使用される
    @Value("${resource.greeting:http://localhost:8080/spring-resource-interface/greeting.json}")
	Resource greetingResource;
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() throws IOException {
        accessResource1();
        accessResource2();
        accessResource3();
        return "index";
    }
    
    // 2.6.3. Resourceインターフェイスを使用したリソースアクセス HTTP経由でWebリソースを取得する実装例
    public void accessResource1() throws IOException {
		// Resourceオブジェクトを生成
		Resource greetingResource = new UrlResource("http://localhost:8080/spring-resource-interface/greeting.json");
		// Resourceインターフェイス経由でリソースにアクセス
		try (InputStream in = ((UrlResource) greetingResource).getInputStream()) {
			String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		}
	}
    
    // 2.6.3. Resourceインターフェイスを使用したリソースアクセス ResourceLoaderでWebリソースを取得する実装例
    public void accessResource2() throws IOException {
		// ResourceLoader経由でResourceを取得
		Resource greetingResource = resourceLoader.getResource("http://localhost:8080/spring-resource-interface/greeting.json");
		// Resourceインターフェイス経由でリソースにアクセス
		try (InputStream in = ((UrlResource) greetingResource).getInputStream()) {
			String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		}
	}
    
    // 2.6.3. Resourceインターフェイスを使用したリソースアクセス プロパティファイルによりリソースの取得先を指定する実装例
	public void accessResource3() throws IOException {
		try (InputStream in = greetingResource.getInputStream()) {
			String content = StreamUtils.copyToString(in, StandardCharsets.UTF_8);
			System.out.println(content);
		}
	}

}