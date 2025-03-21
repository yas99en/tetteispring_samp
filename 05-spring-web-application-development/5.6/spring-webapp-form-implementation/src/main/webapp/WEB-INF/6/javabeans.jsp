<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>ネストしたJavaBeansとのバインディング</title>
</head>
<body>
	<form:form modelAttribute="accountCreateForm2"> 
		
		<!-- ... -->
		<span>名前</span><form:input path="account.name" /><br> 
		<span>E-Mail</span><form:input path="account.email" /><br>
		<!-- ... -->
		<span>番号</span><form:password path="card.no" /><br>
		<span>期限</span><form:input path="card.validMonth"/><br><br>
		<!-- ... --> 
	
		<input value="確認" type="submit"/><br> 
	</form:form>
</body>
</html>