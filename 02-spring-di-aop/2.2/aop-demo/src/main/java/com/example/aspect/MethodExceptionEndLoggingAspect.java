package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 2.2.3.3. After Throwing @AfterThrowingを用いたPointcutの指定例
@Aspect
@Component
public class MethodExceptionEndLoggingAspect {
	@AfterThrowing(value = "execution(* *..*ServiceImpl.*(..))", throwing = "e")
	public void endLog(JoinPoint jp, RuntimeException e) {
		// 本来は例外処理を実装するが、本書では省略
		System.out.println("@AfterThrowing: メソッド異常終了: " + jp.getSignature());
	}
}
