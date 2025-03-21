package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 2.2.3.5. Around @Aroundを用いたPointcutの指定例
@Aspect
@Component
public class MethodLoggingAspect {
	@Around("execution(* *..*ServiceImpl.*(..))")
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("@Around: メソッド開始: " + jp.getSignature());
		try {
			// 対象メソッド実行
			Object result = jp.proceed();
			System.out.println("@Around: メソッド正常終了: " + jp.getSignature() + " 戻り値=" + result);
			return result;
		} catch (Exception e) {
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("@Around: メソッド異常終了: " + jp.getSignature());
			throw e;
		}
	}
}