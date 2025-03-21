<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>6.4. リソースクラスの実装</title>
</head>

<body>
	<h1>6.4. リソースクラスの実装</h1>
	<h2>6.4.2. Jacksonの機能を使用したフォーマットの制御</h2>
    <h3>6.4.2.2. JSONにインデントを設ける方法、6.4.2.3. Date and Time APIのクラスをサポートする方法、6.4.2.4. 日時型のフォーマットを指定する方法 動作確認</h3>
    <p>コマンドプロンプトにて以下のコマンドを実行して、レスポンスのJSONのインデントと日付フォーマット(yyyy-MM-dd)を確認する</p>
    <p>curl http://localhost:8080/application-resource/books -i -H "Content-Type: application/json" -d "{\"bookId\" : \"00000000-0000-0000-0000-000000000000\",  \"name\" : \"書籍名\",  \"authors\" : [ \"著者A\" ],  \"publishedDate\" : \"2024-04-01\",  \"publisher\" : {   \"name\" : \"翔泳社\", \"tel\" : \"03-xxxx-xxxx\"  }}"</p>
	<h3>6.4.2.4. 日時型のフォーマットを指定する方法 注釈 ヒント 動作確認</h3>
    <p>コマンドプロンプトにて以下のコマンドを実行して、レスポンスのJSONの日付フォーマット(yyyy/MM/dd)を確認する</p>
    <p>curl http://localhost:8080/application-resource/books1 -i -H "Content-Type: application/json" -d "{\"bookId\" : \"00000000-0000-0000-0000-000000000000\",  \"name\" : \"書籍名\",  \"authors\" : [ \"著者A\" ],  \"publishedDate\" : \"2024-04-01\",  \"publisher\" : {   \"name\" : \"翔泳社\", \"tel\" : \"03-xxxx-xxxx\"  }}"</p>
</body>

</html>
