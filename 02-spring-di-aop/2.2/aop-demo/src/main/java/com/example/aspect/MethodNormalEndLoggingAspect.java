package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.domain.model.User;

@Aspect
@Component
public class MethodNormalEndLoggingAspect {
	
	// 2.2.3.2. After Returning @AfterReturningを用いたPointcutの指定例
	@AfterReturning("execution(* *..*ServiceImpl.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("@AfterReturning: メソッド正常終了: " + jp.getSignature());
	}
	
	// 2.2.3.2. After Returning @AfterReturningを用いたPointcutの指定例(戻り値を利用する場合)
	@AfterReturning(value = "execution(* *..*ServiceImpl.*(..))", returning = "user")
	public void endLog(JoinPoint jp, User user) {
		System.out.println("@AfterReturning: メソッド正常終了: " + jp.getSignature() + " 戻り値=" + user);
	}
	
}
