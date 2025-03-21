package com.example.api;

import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.dto.BookResource;

@Controller
public class IndexController {

	// 6.6.2.3. RestTemplateのDI例
	@Autowired
	RestOperations restOperations;

	// 初期表示処理
	// 登録したリソースを確認する為に書籍情報の一覧を取得し、画面に表示しています。
	@GetMapping
	public String index(Model model) {
		BookResource[] books = restOperations.getForObject("http://localhost:8080/restful-web-restclient-implementation/books", BookResource[].class);
		model.addAttribute("books", books);
		return "index";
	}

	// 6.6.3.2. postForLocationの使用例
	@GetMapping("postbook")
	public String post(Model model) {
		// リクエストボディに書き込むためのリソースクラスのオブジェクトを生成する。
		BookResource resource = new BookResource();
		resource.setName("Spring徹底入門");
		resource.setPublishedDate(LocalDate.of(2024, 4, 1));
		
		// postForLocationメソッドを使用してREST APIを呼び出す。
		// 第1引数にREST APIのURI、第2引数にリクエストボディの変換元となるJavaBeansを指定する。
		URI createdResourceUri = restOperations.postForLocation(
				"http://localhost:8080/restful-web-restclient-implementation/books", resource);
		System.out.println(createdResourceUri);
		
		model.addAttribute("createdResourceUri", createdResourceUri);
		return index(model);
	}

	// 6.6.3.3. ビルダーパターンのメソッドの使用例
	@GetMapping("responseEntity")
	public String setResponseEntity(Model model) {
		BookResource resource = new BookResource();
		resource.setName("Spring徹底入門 2版");
		resource.setPublishedDate(LocalDate.of(2024, 4, 2));

		// アクセスするREST API(URIとHTTPメソッド)を指定して、RequestEntityのビルダーオブジェクトを取得する。 
		// ビルダーオブジェクトを取得するためのメソッドは、HTTPメソッドごとに用意されている。
		RequestEntity<BookResource> requestEntity = RequestEntity
				.post(URI.create("http://localhost:8080/restful-web-restclient-implementation/books"))
				// Accept、Accept-Charset、If-Modified-Since、If-None-Match、Content-Type、Content-Lengthヘッダーを設定する場合は、 
				// ビルダーにあらかじめ用意されている専用のメソッド(accept、acceptCharset、ifModifiedSince、ifNoneMatch、contentType、contentLength)を使用する。
				.contentType(MediaType.APPLICATION_JSON)
				// 任意のヘッダーを設定する場合は、ビルダーのheaderメソッドを使用する。
				.header("X-Track-Id", UUID.randomUUID().toString())
				.body(resource);
		ResponseEntity<Void> responseEntity = restOperations.exchange(requestEntity, Void.class);
		model.addAttribute("responseEntity", responseEntity);
		return index(model);
	}

	// 6.6.3.4. REST API呼び出しの例
	@GetMapping("httpResponse")
	public String getHttpResponseEntity(Model model) {
		BookResource resource = new BookResource();
		resource.setName("Spring徹底入門 3版");
		resource.setPublishedDate(LocalDate.of(2024, 4, 3));
		
		// postForEntityメソッドを使用してREST APIを呼び出し、レスポンスをResponseEntityとして受け取る。
		ResponseEntity<Void> responseEntity = restOperations.postForEntity(
				"http://localhost:8080/restful-web-restclient-implementation/books", resource, Void.class);
		// ResponseEntityのgetStatusCodeメソッドを呼び出してHTTPステータスを取得する。
		HttpStatus httpStatus = responseEntity.getStatusCode();
		// ResponseEntityのgetHeadersメソッドを呼び出してレスポンスヘッダーを取得する。
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		
		model.addAttribute("httpStatus", httpStatus);
		model.addAttribute("responseHeaders", responseHeaders);
		return index(model);
	}

	// 6.6.3.5. URIテンプレートを使用してREST APIを呼び出す実装例
	@GetMapping("uriRest")
	public String uriRest(Model model) {
		String bookId = "00000000-0000-0000-0000-000000000000";
		BookResource resource = restOperations.getForObject(
				// REST APIを呼び出すときに指定するURIに、URIテンプレートを指定する。 
				"http://localhost:8080/restful-web-restclient-implementation/books/{bookId}",
				// メソッドの最終引数(可変長引数)に、URIテンプレートに埋め込む変数値を指定する。 
				// ここでは変数bookIdの値を指定している。
				BookResource.class, bookId);
		model.addAttribute("uriRestResource", resource);
		return index(model);
	}

	// 6.6.3.5. UriComponentsBuilderを使用してURIテンプレートを扱う実装例
	@GetMapping("uriComponentsBuilder")
	public String uriComponentsBuilder(Model model) {
		String bookId = "00000000-0000-0000-0000-000000000000";
		RequestEntity<Void> requestEntity = RequestEntity
				.get(UriComponentsBuilder
						.fromUriString("http://localhost:8080/restful-web-restclient-implementation/books/{bookId}")
						.buildAndExpand(bookId)
						.encode()
						.toUri())
				.header("X-Track-Id", UUID.randomUUID().toString())
				.build();
		ResponseEntity<BookResource> responseEntity = restOperations.exchange(requestEntity, BookResource.class);
		model.addAttribute("uriComponentsBuilder", responseEntity);
		return index(model);
	}
}
