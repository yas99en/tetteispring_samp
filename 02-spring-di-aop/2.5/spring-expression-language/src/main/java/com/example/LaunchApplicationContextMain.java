package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.example.config.AppConfig;
import com.example.domain.model.Staff;
import com.example.domain.model.TemporaryDirectory;

public class LaunchApplicationContextMain {
	
	// mainメソッドを実行し、SpELの処理が行なわれていることを確認する
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// 2.5.2. SpEL APIの利用 SpELを利用した簡単な演算の例
		ExpressionParser parser = new SpelExpressionParser(); // SpEL用の解析オブジェクトの生成 
		Expression expression = parser.parseExpression("1 * 10 + 1"); // 式の解析
		Integer calculationResult = expression.getValue(Integer.class); // 式の評価
		System.out.println("calculationResult: " + calculationResult);
		// 2.5.2. SpEL APIの利用 SpELを利用したJavaBeansのプロパティへのアクセス例
		parser = new SpelExpressionParser();
		expression = parser.parseExpression("joinedYear"); // 式の解析
		Staff staff = context.getBean(Staff.class); // 書籍ではStaff staff = new Staff();としているが、ここではルックアップしている
		expression.setValue(staff, "2000"); // 式の評価 
		Integer joinedYear = staff.getJoinedYear();
		System.out.println("joinedYear: " + joinedYear);
		// SpELを使用して取得した値をTemporaryDirectoryのコンストラクタに渡せているか確認する
		TemporaryDirectory temporaryDirectory = context.getBean(TemporaryDirectory.class);
		System.out.println("TemporaryDirectory: " + temporaryDirectory.getDirectory().getPath());
		((ConfigurableApplicationContext) context).close();
	}
	
}
