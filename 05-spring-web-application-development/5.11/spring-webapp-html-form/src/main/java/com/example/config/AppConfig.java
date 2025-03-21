package com.example.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Map<String, String> hobbyCodeList() {
		Map<String, String> map = new LinkedHashMap<>(); 
		map.put("sport", "スポーツ");
		map.put("music", "音楽");
		return Collections.unmodifiableMap(map);
	}
	
	@Bean
	public Map<String, String> genderCodeList() {
		Map<String, String> map = new LinkedHashMap<>(); 
		map.put("men", "男性");
		map.put("women", "女性");
		return Collections.unmodifiableMap(map);
	}	
	
	@Bean
	public Map<String, String> prefectureCodeListForNorthKanto() {
		Map<String, String> map = new LinkedHashMap<>(); 
		map.put("08", "茨城");
		map.put("09", "栃木");
		map.put("10", "群馬");
		return Collections.unmodifiableMap(map); 
	}
	@Bean
	public Map<String, String> prefectureCodeListForSouthKanto() {
		Map<String, String> map = new LinkedHashMap<>(); 
		map.put("11", "埼玉");
		map.put("12", "千葉");
		map.put("13", "東京");
		map.put("14", "神奈川");
		return Collections.unmodifiableMap(map); 
	}

}
