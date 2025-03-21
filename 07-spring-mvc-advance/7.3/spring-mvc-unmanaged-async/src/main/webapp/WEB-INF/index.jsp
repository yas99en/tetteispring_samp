<!DOCTYPE html>
<html lang="ja-JP">
<head>
<meta charset="utf-8" />
<title>7.3 非同期リクエストの実装(Spring MVC管理外のスレッドを使用した非同期処理)</title>
</head>
<body>
	<h1>非同期リクエストの実装(Spring MVC管理外のスレッドを使用した非同期処理)</h1>
	<h2>7.3.3 非同期処理の実装</h2>
	<h3>7.3.3.2. CompletableFutureを使用した非同期処理の実装</h3>
	<p>
		以下のボタンより、ファイルを選択し(またはここでは未選択でもよい)、アップロードすると<br>
		5秒後にdummyのアップロード結果画面に遷移する。
	</p>
	<form id="upload1" action="upload1" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="アップロードする" />
	</form>
	<h3>7.3.3.3. SseEmitterを使用したPush型の非同期処理の実装</h3>
	<p>以下のリンクを押すと、1秒間隔でイベントがブラウザ上に反映され、データが表示される。</p>
	<p><a href="greeting">SseEmitterを使用したPush型の非同期処理の実装</a></p>
	<h2>7.3.4 非同期実行の例外ハンドリング</h2>
	<p>
		以下のボタンより、ファイルを選択し(またはここでは未選択でもよい)、アップロードすると<br>
		例外発生のページに遷移する。なお、UploadServiceのupload2の意図的に例外を発生させている部分である<br>
		「int i = 1 / 0;」をコメントアウトすると、5秒後にdummyのアップロード結果画面に遷移する。
	</p>
	<form id="upload2" action="upload2" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="アップロードする" />
	</form>
	<h2>7.3.5 非同期実行に対する共通処理の実装</h2>
	<p>
		以下のボタンより、ファイルを選択し(またはここでは未選択でもよい)、アップロードすると<br>
		5秒後以降にtimeout error画面に遷移する。
	</p>
	<form id="upload3" action="upload3" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="アップロードする" />
	</form>
</body>
</html>