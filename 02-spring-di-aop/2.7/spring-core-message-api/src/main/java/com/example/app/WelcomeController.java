package com.example.app;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

	@Autowired
	MessageSource messageSource; // インジェクションする

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		// 2.7.2.3. MessageSourceのAPI使用例 MessageSourceのAPI使用例
		// getMessageメソッドの呼び出し
		System.out.print("ASCIIコード: ");
		System.out.print(messageSource.getMessage("welcome.message", new String[] { "Spring徹底入門" }, Locale.JAPANESE));
		// 2.7.2.4. MessageSourceResolvableの利用 MessageSourceResolvableの利用
		MessageSourceResolvable functionName = new DefaultMessageSourceResolvable("functionName.userRegistration");
		System.out.println(messageSource.getMessage("result.succeed", new MessageSourceResolvable[] { functionName }, Locale.JAPANESE));
		// ネイティブコードのメッセージ
		System.out.print("ネイティブコード: ");
		System.out.print(messageSource.getMessage("native.welcome.message", new String[] { "Spring徹底入門" }, Locale.JAPANESE));
		functionName = new DefaultMessageSourceResolvable("native.functionName.userRegistration");
		System.out.println(messageSource.getMessage("native.result.succeed", new MessageSourceResolvable[] { functionName }, Locale.JAPANESE));
		// 多言語サポート
		System.out.print("多言語（" + Locale.ENGLISH + "）: ");
		System.out.print(messageSource.getMessage("welcome.message", new String[] { "Spring徹底入門" }, Locale.ENGLISH));
		functionName = new DefaultMessageSourceResolvable("functionName.userRegistration");
		System.out.println(messageSource.getMessage("result.succeed", new MessageSourceResolvable[] { functionName }, Locale.ENGLISH));

		return "index";
	}

}