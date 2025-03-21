package com.example.domain.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
	
	// 2.3.6. Type Conversionのカスタマイズ Beanのフィールドにプロパティファイルで定義した値をバインディングするJava Configの実装例
	@Value("${application.adminEmail:}")
    private EmailValue adminEmail; // EmailValueのvalueプロパティに "admin@example.com" が設定される
	
	// 2.3.7. Field Formattingのカスタマイズ DIコンテナで管理するBean
	@Value("${application.dateOfServiceStarting:}")
	private LocalDate dateOfServiceStarting; // 「2024年1月1日」が設定される
	
	public EmailValue getAdminEmail() {
		return adminEmail;
	}
	
	public LocalDate getDateOfServiceStarting() {
		return dateOfServiceStarting;
	}
	
}
