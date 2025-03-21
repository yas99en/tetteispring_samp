package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 2.2.5.4. 名前付きPointcut 名前付きPointcutの定義例
@Aspect
@Component
public class NamedPointCuts {
		
	@Pointcut("within(com.example.web..*)") 
	public void inWebLayer() {}
	
	@Pointcut("within(com.example.domain..*)") 
	public void inDomainLayer() {}
			
	@Pointcut("execution(public * *(..))")
	public void anyPublicOperation() {}
		
}
