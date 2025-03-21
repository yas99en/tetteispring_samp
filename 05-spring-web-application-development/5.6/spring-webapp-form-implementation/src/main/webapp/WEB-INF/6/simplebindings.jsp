<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>シンプル型とのバインディング</title>
</head>

<body>
    <form:form modelAttribute="accountCreateForm1"> 
		
		<span>名前</span><form:input path="name" /><br> 
		<span>TEL</span><form:input path="tel" /><br>
		<span>誕生日</span><form:input path="dateOfBirth" type="date" /><br> 
		<span>E-Mail</span><form:input path="email" type="email" /><br><br>
		<input value="確認" type="submit"/><br> 
		
	</form:form>
</body>

</html>
