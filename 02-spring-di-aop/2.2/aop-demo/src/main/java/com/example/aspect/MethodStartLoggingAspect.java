package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.domain.service.CalcService;

// 2.2.2. Spring AOP Aspectの実装例
// 2.2.3.1. Before @Beforeを用いたPointcutの指定例
@Aspect
@Component
public class MethodStartLoggingAspect {
	
	@Before("execution(* *..*ServiceImpl.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("@Before: メソッド開始: " + jp.getSignature());
	}
	
	// 2.2.5.4. 名前付きPointcut 名前付きPointcutの使用例
	// 2.2.5.5. Adviceの対象オブジェクトや引数を取得 target式やargs式を用いてJoinPointから対象オブジェクトや引数を取得する実装例
	// 書籍の「execution(* com.example.domain.service.CalcService.*(int))」の部分についてはNamedPointCutsを用いることも可能
	@Before("NamedPointCuts.inDomainLayer() && target(service) && args(input)")
	public void startLog(CalcService service, int input) {
		System.out.println("@Before: メソッド開始");
		System.out.println("targetObject = " + service);
		System.out.println("thisObject = " + service);
		System.out.println("args = " + input);
		System.out.println("@Before: メソッド終了");
	}
	
}
