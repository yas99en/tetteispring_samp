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
		<span>TEL</span><form:input path="tel" /> &nbsp; <form:errors path="tel" /><br>
		<span>誕生日</span><form:input path="dateOfBirth" type="date" /> &nbsp; <form:errors path="dateOfBirth" /><br> 
		<span>E-Mail</span><form:input path="email" type="email" /> &nbsp; <form:errors path="email" /><br><br>
		<input value="確認" type="submit"/><br><br>
		
	</form:form>
	<br>
	
	<span>
		書籍の5.7.9を本サンプルで確認できます。<br>
	</span>
	
</body>

</html>
