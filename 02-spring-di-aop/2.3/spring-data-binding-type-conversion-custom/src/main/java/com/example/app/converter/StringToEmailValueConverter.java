package com.example.app.converter;

import org.springframework.core.convert.converter.Converter;

import com.example.domain.model.EmailValue;

// 2.3.6. Type Conversionのカスタマイズ Stringを独自クラス(EmailValue)へ変換するConverterクラスの作成例
public class StringToEmailValueConverter implements Converter<String, EmailValue> {

	@Override
	public EmailValue convert(String source) {
		EmailValue email = new EmailValue();
		email.setValue(source);
		return email;
	}

}