<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>5.11</title>
</head>
<body>
    <h2>SpringのHTMLフォーム用タグライブラリの利用</h2>
    
    <form:form modelAttribute="loginForm">
		ユーザー名:<form:input path="username"/><br> 
		パスワード:<form:password path="password"/><br> 
		<form:button>ログイン</form:button>
	</form:form>

</body>
</html>