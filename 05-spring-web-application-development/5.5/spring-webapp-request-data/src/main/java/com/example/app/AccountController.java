package com.example.app;

import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	
	private static final String FORWARD_RESULT= "result";
	
	// パス変数値の取得（@PathVariable）
	@GetMapping("accounts/{accountId}")
	public String detail(@PathVariable String accountId, Model model) {
		model.addAttribute("result", "accountId: " + accountId);
		return FORWARD_RESULT;
	}

	// リクエストパラメータ値の取得（@RequestParam）
	@GetMapping("detail")
	public String detailParam(@RequestParam String format, Model model) {
		model.addAttribute("result", "format: " + format);
		return FORWARD_RESULT;
	}

	// @RequestParam、@RequestHeader、@CookieValueの属性値の指定例
	@GetMapping("accounts")
	public String cart(@CookieValue("example.springbook.cartId") String cartId,
			@RequestHeader(name = "X-Track-Id", required = false) String trackingId,
			@RequestParam(defaultValue = "1") Integer page, Model model) {
		model.addAttribute("result", "cartId: " + cartId + ", trackingId: " + trackingId + ", page: " + page);
		return FORWARD_RESULT;
	}

	// Optionalの使用例
	@PostMapping("accounts/create")
	public String create(@Validated AccountCreateForm form, @RequestHeader("X-Track-Id") Optional<String> trackingId, Model model) {
		model.addAttribute("result", "trackingId: " + trackingId);
		return FORWARD_RESULT;
	}

	// バインディング処理のカスタマイズ（WebDataBinder）
	@InitBinder("targetDate")
	public void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyyMMdd"));
	}
	
	@GetMapping("searchInitBinder")
	public String searchInitBinder(@RequestParam Date targetDate, Model model) {
		DateFormatter df = new DateFormatter("yyyy-MM-dd");
		model.addAttribute("result", "targetDate: " + df.print(targetDate, Locale.JAPAN));
		return FORWARD_RESULT;
	}
	
	// アノテーションを使用したフォーマットの指定
	@GetMapping("searchAnnotation")
	public String searchAnnotation(@DateTimeFormat(pattern = "yyyyMMdd") @RequestParam Date targetDate, Model model) {
		DateFormatter df = new DateFormatter("yyyy-MM-dd");
		model.addAttribute("result", "targetDate: " + df.print(targetDate, Locale.JAPAN));
		return FORWARD_RESULT;
	}
	
}
