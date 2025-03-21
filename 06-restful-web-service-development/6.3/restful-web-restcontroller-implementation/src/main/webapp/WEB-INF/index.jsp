<!DOCTYPE html>
<html lang="ja-JP">
	<head>
		<title>6.3</title>
	</head>
	<body>
		<h1>6.3. @RestController の実装</h1>
		<ul>
			<li>
				<p>6.3.3.2. Bookリソースの取得</p>
				<a href="books">Bookリソースの取得</a>
				<p>curlを利用したAPIへのアクセス方法:</p>curl http://localhost:8080/restful-web-restcontroller-implementation/books/00000000-0000-0000-0000-000000000000
			</li>
			<li>
				<p>6.3.3.3. リソースの作成</p>
				<p>curlを利用したAPIへのアクセス方法:</p>curl -H "Content-type: application/json;charset=UTF-8" -X POST -d "{\"name\":\"Spring book 徹底入門\",\"publishedDate\":\"2024-04-01\"}" http://localhost:8080/restful-web-restcontroller-implementation/books
			</li>
			<li>
				<p>6.3.3.4. リソースの更新</p>
				<p>curlを利用したAPIへのアクセス方法:</p>curl -H "Content-type: application/json;charset=UTF-8" -X PUT -d "{\"bookId\":\"c1c3da32-16e9-4288-9dc9-4866f2e4407a\",\"name\":\"Spring徹底入門 (Spring 4.2対応)\",\"publishedDate\":\"2024-03-20\"}" http://localhost:8080/restful-web-restcontroller-implementation/books/c1c3da32-16e9-4288-9dc9-4866f2e4407a
			</li>
			<li>
				<p>6.3.3.5. リソースの削除</p>
				<p>curlを利用したAPIへのアクセス方法:</p>curl -X DELETE http://localhost:8080/restful-web-restcontroller-implementation/books/c1c3da32-16e9-4288-9dc9-4866f2e4407a
				<p>リソースの作成 → リソースの削除 → 削除したリソースを取得:</p>curl http://localhost:8080/restful-web-restcontroller-implementation/books/c1c3da32-16e9-4288-9dc9-4866f2e4407a
			</li>
			<li>
				<p>6.3.3.6. リソースの検索</p>
				<a href="books">検索条件なしで検索した場合のレスポンス例</a>
				<br>
				<a href="books?name=%e6%9b%b8%e7%b1%8d">検索条件を指定した場合のレスポンス例</a>
			</li>
			<li>
				<p>6.3.4 CORSのサポート</p>
				CORS適用確認:「127.0.0.1」に対し書籍情報を取得するAJAXリクエストを送信し、取得結果を以下に表示する。<br/>
				<input type="button" value="AJAXリクエスト送信" onclick="testCORS()" />
				<h2 id="bookId" style="width: 750px; border-color: aqua; border-style: solid; border-width: 2px">「bookId」</h2>
				<h2 id="name" style="width: 750px; border-color: aqua; border-style: solid; border-width: 2px">「書籍名」</h2>
				<h2 id="publishedDate" style="width: 750px; border-color: aqua; border-style: solid; border-width: 2px">「出版日」</h2>
			</li>
		</ul>
		<script>
			function testCORS() {
				let r = new XMLHttpRequest();
				// リクエスト処理成功
				r.onreadystatechange = function() {
					if (r.status == 200 && r.readyState == 4) {
						// htmlコンソール出力
						console.log("レスポンス情報：" + r.responseText);
						// 取得結果を画面に表示
						let book = JSON.parse(r.responseText);
						document.getElementById('bookId').innerText = "bookId: " + book.bookId
						document.getElementById('name').innerText = "Name: " + book.name;
						document.getElementById('publishedDate').innerText = "publishedDate: " + book.publishedDate
					}
				}
				// リクエスト送信
				r.open("GET", "http://127.0.0.1:8090/restful-web-restcontroller-implementation/books/00000000-0000-0000-0000-000000000000");
				r.setRequestHeader('X-Custom-Header', 'value'); // プリフライト方式を使用
				r.send();
			}
		</script>
	</body>
</html>