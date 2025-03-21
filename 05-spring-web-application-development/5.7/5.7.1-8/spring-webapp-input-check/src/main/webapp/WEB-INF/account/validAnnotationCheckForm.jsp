<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.7-sample</title>
</head>

<body>

	<h1>Validアノテーションの確認 サンプル</h1>
    <form:form modelAttribute="accountValidAnnotationCheckForm"> 
    	<span>入力項目</span><form:input path="item" /> &nbsp; <form:errors path="item" /><br><br>
		<input value="入力チェック" type="submit"/><br>
	</form:form>
	<br>
	
	<span>
		書籍の5.7.5の内容を本サンプルで確認できます。<br>
		<br>
		このサンプルでは、以下の入力制限が入っています。<br>
		<ul>
    		<li>入力項目：未入力の場合エラー</li>
    	</ul>
	</span>
	
</body>

</html>
