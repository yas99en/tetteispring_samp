<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>5.5リクエストデータの取得</title>
</head>
<body>
    <h2>リクエストデータの取得</h2>
    <br />
    
    <a href="accounts/A001">パス変数値の取得</a><br/>
    <a href="detail?format=standard">リクエストパラメータ値の取得</a><br/>
    <a href="accounts">@RequestParam、@RequestHeader、@CookieValueの属性値の指定例</a><br/>
    <a href="searchInitBinder?targetDate=20240506">バインディング処理のカスタマイズ（WebDataBinder）</a><br/>
    <a href="searchAnnotation?targetDate=20240507">アノテーションを使用したフォーマットの指定</a><br/>

    <br/>
    <script>
		document.cookie = 'example.springbook.cartId=123';
	</script>
</body>
</html>