<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.7-sample</title>
</head>

<body>

	<h1>入力チェック サンプル</h1>
    <form:form modelAttribute="accountForm"> 
		<span>名前</span><form:input path="name" /> &nbsp; <form:errors path="name" /><br>
		<span>デフォルトで適用されるメッセージコードの変更例</span><form:input path="defaultMessage" /> &nbsp; <form:errors path="defaultMessage" /><br>
		<span>エラーメッセージをmessage属性に直接指定する定義例</span><form:input path="directMessage" /> &nbsp; <form:errors path="directMessage" /><br>
		<input value="確認" type="submit"/><br><br>
		
	</form:form>
	<br>
	
	<span>
		書籍の5.7.9を本サンプルで確認できます。<br>
	</span>
	
</body>

</html>
