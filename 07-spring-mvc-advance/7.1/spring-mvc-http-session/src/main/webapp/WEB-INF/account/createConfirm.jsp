<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.1 確認画面</title>
</head>
<body>
	<p>確認画面</p>
	<form:form modelAttribute="accountCreateForm">

		<span>ユーザー名： <c:out value="${accountCreateForm.username}"/></span>
		<input type="hidden" name="username" value="${accountCreateForm.username}"/>
		<br />
		<span>パスワード： <c:out value="${accountCreateForm.password}"/></span>
		<input type="hidden" name="password" value="${accountCreateForm.password}"/>
		<br />
		<span>メールアドレス： <c:out value="${accountCreateForm.email}"/></span>
		<input type="hidden" name="email" value="${accountCreateForm.email}"/>
		<br />
		
		<br />
		<input value="完了画面へ（オブジェクトを削除）" type="submit" />
		<br />
	</form:form>
	<br />
	<a href="../">インデックス画面へ</a>
</body>
</html>