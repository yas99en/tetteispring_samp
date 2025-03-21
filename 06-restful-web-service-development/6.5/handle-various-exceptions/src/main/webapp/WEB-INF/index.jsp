<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>6.5 sample</title>
</head>

<body>
    <h1>6.5 動作確認方法</h1>
    <p>以下のコマンドを実行して確認してください。<br>
    
    <h2>6.5.2 Spring MVCの例外ハンドラの実装</h2>
    <p>curl http://localhost:8080/handle-various-exceptions/books -X POST -H "Content-Type:application/json" -d "{"</p>
    
    <h2>6.5.3 ハンドリング対象の例外クラスの追加</h2>
    <ul>
	    <li>ユーザー定義の例外のハンドリング例<br>
	        <p>存在しない本のID(ここではno-such-book-exists)を指定する。<br>
	        curl http://localhost:8080/handle-various-exceptions/books/no-such-book-exists</p>
	    </li>
	    <li>システム例外のハンドリング例<br>
	        <p>idがruntime-exceptionの本にアクセスする。(内部処理にて意図的にRuntimeExceptionを投げる実装としている)<br>
	        curl http://localhost:8080/handle-various-exceptions/books/runtime-exception</p>
	    </li>
    </ul>

    <h2>6.5.4 入力チェック例外のハンドリング</h2>
    <p>curl http://localhost:8080/handle-various-exceptions/books -X POST -H "Content-Type:application/json" -d "{\"name\":\"\"}"</p>
        
    <h2>6.5.5 サーブレットコンテナに通知されたエラーの応答</h2>
    <ul>
        <li>例外クラスによるエラーハンドリング確認<br>
            <p>curl http://localhost:8080/handle-various-exceptions/broken-jsp</p>
        </li>
        <li>HTTPステータスコードによるエラーハンドリング確認<br>
            <p>curl http://localhost:8080/handle-various-exceptions/no-such-page-exist</p>
        </li>
    </ul>
</body>

</html>
