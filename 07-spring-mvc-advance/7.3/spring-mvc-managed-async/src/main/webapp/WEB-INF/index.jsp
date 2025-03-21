<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.3 非同期リクエストの実装(Spring MVC管理下のスレッドを使用した非同期処理)</title>
</head>
<body>
	<h1>非同期リクエストの実装(Spring MVC管理下のスレッドを使用した非同期処理)</h1>
	<h2>7.3.2 非同期実行を有効にするための設定</h2>
	<h3>7.3.2.2. Spring MVC上での非同期実行の有効化</h3>
	<p>
		以下のボタンより、ファイルを選択し(またはここでは未選択でもよい)、アップロードすると<br>
		5秒後にdummyのアップロード結果画面に遷移する。
	</p>
	<form id="upload1" action="upload1" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="アップロードする" />
	</form>
	<h2>7.3.5 非同期実行に対する共通処理の実装</h2>
	<p>
		以下のボタンより、ファイルを選択し(またはここでは未選択でもよい)、アップロードすると<br>
		5秒後以降にtimeout error画面に遷移する。
	</p>
	<form id="upload2" action="upload2" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="アップロードする" />
	</form>
</body>
</html>