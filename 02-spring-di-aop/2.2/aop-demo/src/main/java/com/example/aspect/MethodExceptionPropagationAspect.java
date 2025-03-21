package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 2.2.3.3. After Throwing @AfterThrowingを用いた例外の変換
@Aspect
@Component
public class MethodExceptionPropagationAspect {
	@AfterThrowing(value = "execution(* *..*ServiceImpl.*(..))", throwing = "e")
	public void endLog(JoinPoint jp, DataAccessException e) {
		throw new ApplicationException(e);
	}
}
