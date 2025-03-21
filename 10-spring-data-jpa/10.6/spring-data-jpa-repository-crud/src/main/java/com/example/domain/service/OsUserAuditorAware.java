package com.example.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

// 10.6.6. 監査情報の付与 AuditorAwareインターフェイスの実装例
public class OsUserAuditorAware implements AuditorAware<String> {
	
    @Value("#{ systemProperties['user.name'] }")
    private String userName;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(userName);
    }
}
