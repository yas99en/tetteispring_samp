<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>binding=falseの確認</title>
</head>
<body>	
	<p>@ModelAttribute binding=falseの確認</p>
	<br />
	<span>ユーザー名： <c:out value="${bindingTestForm.username}"/></span>
	<br />
	<span>パスワード： <c:out value="${bindingTestForm.password}"/></span>
	<br />
	<br />
	<a href="false">入力画面再表示</a>
</body>
</html>