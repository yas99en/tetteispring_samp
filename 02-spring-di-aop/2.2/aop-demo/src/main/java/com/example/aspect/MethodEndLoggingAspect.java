package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 2.2.3.4. After @Afterを用いたPointcutの指定例
@Aspect
@Component
public class MethodEndLoggingAspect {
	@After("execution(* *..*ServiceImpl.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("@After: メソッド終了: " + jp.getSignature());
	}
}