<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>disp-error</title>
</head>
<body>
	<form:form modelAttribute="accountForm"> 

		<span>名前</span>
		<form:input path="name"/><br> 
		<form:errors path="name" /><br> 
		<br> 
		<span>年齢</span>
		<form:input path="age" type="number"/><br> 
		<form:errors path="age" /><br> 
		<br> 
		<span>コメント</span>
		<form:input path="comment"/><br> 
		<form:errors path="comment" /><br> 
		<br> 
		<input value="確認" type="submit"/><br> 
		<br> 		
	</form:form>
</body>
</html>