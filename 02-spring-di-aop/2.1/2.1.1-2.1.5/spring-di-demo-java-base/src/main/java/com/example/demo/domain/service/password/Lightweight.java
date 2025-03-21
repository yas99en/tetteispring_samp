package com.example.demo.domain.service.password;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import org.springframework.beans.factory.annotation.Qualifier;

// 2.1.5.1. 型によるオートワイヤリング @Qualifierアノテーションを付与した@Lightweightアノテーションの実装例
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface Lightweight {
}