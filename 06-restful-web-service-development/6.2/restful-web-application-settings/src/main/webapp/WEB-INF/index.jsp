<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>6.2. アプリケーションの設定</title>
</head>

<body>
	<h1>6.2. アプリケーションの設定</h1>
	<h2>6.2.2. サーブレットコンテナの設定、6.2.3. フロントコントローラの設定</h2>
    <h3>6.2.2.1. HiddenHttpMethodFilterの適用、6.2.3.2. HttpMessageConverterのカスタマイズ 動作確認</h3>
    <p>コマンドプロンプトにて以下のコマンドを実行して、入力値を元にインデント及び改行されたデータが返却されていることを確認する</p>
    <p>curl -H "Content-type: application/json;charset=UTF-8" -X POST -d "{\"bookId\":\"00000000-0000-0000-0000-000000000000\",\"name\":\"Spring徹底入門\",\"publishedDate\":\"2024-10-01\"}" http://localhost:8080/restful-web-application-settings/books?_method=put</p>
</body>

</html>
