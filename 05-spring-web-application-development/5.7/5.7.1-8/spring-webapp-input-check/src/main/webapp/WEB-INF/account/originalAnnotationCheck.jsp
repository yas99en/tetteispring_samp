<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.7-sample</title>
</head>

<body>

	<h1>独自アノテーションの確認 サンプル</h1>
    <form:form modelAttribute="accountOriginalAnnotationCheckForm"> 
    	<span>クーポンコード</span><form:input path="couponCode" /> &nbsp; <form:errors path="couponCode" /><br>
    	<span>パスワード</span><form:input path="password" /> &nbsp; <form:errors path="password" /><br>
    	<br>
		<input value="入力チェック" type="submit"/><br>
	</form:form>
	<br>
	
	<span>
		書籍の5.7.6の内容を本サンプルで確認できます。<br>
		<br>
		このサンプルでは、以下の入力制限が入っています。<br>
		<ul>
    		<li>クーポンコード：英数字でない場合エラー</li>
    		<li>パスワード：8文字以上で記号を1文字入れていないとエラー</li>
    	</ul>
	</span>
	
</body>

</html>
