<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.1 確認画面</title>
</head>
<body>
	<p>確認画面</p>
	<form:form modelAttribute="accountCreateAttributeForm">

		<span>パスワード： <c:out value="${password}"/></span>
		<br />
		
		<br />
		<input value="完了画面へ" type="submit" />
		<br />
	</form:form>
	<br />
	<a href="../">インデックス画面へ</a>
</body>
</html>