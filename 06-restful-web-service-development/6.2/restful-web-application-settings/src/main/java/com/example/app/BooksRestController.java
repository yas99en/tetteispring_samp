package com.example.app;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.dto.BookResource;


@RestController
@RequestMapping("books")
public class BooksRestController {
	
	// 6.2.2.1. HiddenHttpMethodFilterの適用　本文内容の確認
	// ここでは簡単のため、入力値をそのまま返却している
	// コマンドプロンプトで以下のコマンドを実行して出力結果を確認し、またSTSのコンソールログにて正常に処理されているか確認する
	// curl -H "Content-type: application/json;charset=UTF-8" -X POST -d "{\"bookId\":\"00000000-0000-0000-0000-000000000000\",\"name\":\"Spring徹底入門\",\"publishedDate\":\"2024-10-01\"}" http://localhost:8080/restful-web-application-settings/books?_method=put
	@PutMapping
	public BookResource putBook(@RequestBody BookResource newResource) {		
		return newResource; 
	}
	
}
