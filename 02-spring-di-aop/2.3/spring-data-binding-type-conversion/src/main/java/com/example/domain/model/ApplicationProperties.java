package com.example.domain.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
	
	// 2.3.3. PropertyEditorの利用 DIコンテナで管理するBean
	@Value("${application.healthCheck:no}")
	private boolean healthCheckEnabled; // trueが設定される
	
	// 2.3.4. ConversionServiceの利用 DIコンテナで管理するBean
	@Value("${application.dateOfServiceStarting1:}")
	private LocalDate dateOfServiceStarting1; // 「2024年1月1日」が設定される
	
	// 2.3.5. フォーマット指定用のアノテーションの利用 フォーマットの指定例
	@Value("${application.dateOfServiceStarting2:}")
	@DateTimeFormat(pattern = "uuuu/M/d") // 個別にフォーマットを指定
	private LocalDate dateOfServiceStarting2;
			
	public boolean getHealthCheckEnabled() {
		return healthCheckEnabled;
	}
	
	public LocalDate getDateOfServiceStarting1() {
		return dateOfServiceStarting1;
	}

	public LocalDate getDateOfServiceStarting2() {
		return dateOfServiceStarting2;
	}

}
