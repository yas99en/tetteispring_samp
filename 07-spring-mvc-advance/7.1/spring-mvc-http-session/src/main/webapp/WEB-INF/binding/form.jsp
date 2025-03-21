<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>binding=falseの確認</title>
</head>
<body>
	<p>@ModelAttribute binding=falseの確認</p>
	
	<form:form modelAttribute="bindingTestForm">
		<br />
		<span>ユーザー名：</span>
		<form:input type="text" path="username" value="${username}"/>
		<br />
		<span>パスワード：</span>
		<form:input type="text" path="password" value="${password}"/>
		<br />
		<br />
		<form:button type="submit">登録</form:button>
	</form:form>
	<br />
	<a href="../">インデックス画面へ</a>
</body>
</html>