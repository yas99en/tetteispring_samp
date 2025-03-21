<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.1 入力画面</title>
</head>
<body>
	<p>入力画面</p>
	<form:form modelAttribute="accountCreateAttributeForm">

		<span>パスワード：</span>
		<input type="text" name="password" value="${password}"/>	
		<br />
		
		<br />
		<input value="確認画面へ" type="submit" />
		<br />
	</form:form>
	<br />
	<a href="../">インデックス画面へ</a>
</body>
</html>