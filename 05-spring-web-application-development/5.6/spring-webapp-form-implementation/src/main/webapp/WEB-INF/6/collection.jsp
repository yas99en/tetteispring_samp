<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>コレクション内のJavaBeansとのバインディング</title>
</head>
<body>
	<form:form modelAttribute="accountCreateForm3"> 
		
		<!-- ... -->
		<span>番号</span><form:password path="cards[0].no" /><br> 
		<span>期限</span><form:input path="cards[0].validMonth"/><br><br> 
		<!-- ... -->
		<span>番号</span><form:password path="cards[1].no" /><br> 
		<span>期限</span><form:input path="cards[1].validMonth"/><br><br>
		<!-- ... -->
	
		<input value="確認" type="submit"/><br> 
	</form:form>
</body>
</html>