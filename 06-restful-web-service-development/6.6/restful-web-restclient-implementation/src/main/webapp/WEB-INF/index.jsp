<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>6.6 RESTクライアントの実装</title>
	<style>
		th, td {
			border:1px solid #333;
		}
	</style>
</head>
<body>
	<table>
		<caption>書籍(リソース)の一覧</caption>
		<thead>
			<tr>
				<th>書籍ID</th>
				<th>書籍名</th>
				<th>掲載日</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.bookId}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.publishedDate}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>6.6. REST クライアントの実装</h1>
	<h2>6.6.3. REST API の呼び出し</h2>
	<ul>
		<li>リソースの作成 
			<p><a href="postbook">postForLocationの使用例</a> : ${createdResourceUri}</p>
		</li>
		<li>リクエストヘッダーの設定
			<p><a href="responseEntity">ビルダーパターンのメソッドの使用例</a> : ${responseEntity}</p>
		</li>
		<li>HTTPステータスとレスポンスヘッダーの取得
			<p><a href="httpResponse">REST API呼び出しの例 </a></p>
			<p>httpStatus : ${httpStatus}</p>
			<p>responseHeaders : ${responseHeaders}</p>
		</li>
		<li>URIテンプレートの利用
			<p><a href="uriRest">URIテンプレートを使用してREST APIを呼び出す実装例 </a> : ${uriRestResource}</p>
			<p><a href="uriComponentsBuilder">UriComponentsBuilderを使用してURIテンプレートを扱う実装例 </a></p>
			<p>httpStatus : ${uriComponentsBuilder.statusCode}</p>
			<p>responseHeaders : ${uriComponentsBuilder.headers}</p>
			<p>responseBody : ${uriComponentsBuilder.body}</p>
		</li>
	</ul>
	<h2>6.6.5. タイムアウトの指定</h2>
	<p>確認方法：BooksRestController.javaにおけるcreateBookメソッドにThread.sleep(5000)を設定し，プログラムを再実行した後に6.6.3. リソース作成の「postForLocationの使用例」のリンクをクリックするとRead timed outエラーが見られる.</p>
</body>
</html>