<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.1 入力画面（3/3）</title>
</head>
<body>
	<p>入力画面（3/3）</p>
	<form:form modelAttribute="accountCreateForm">

		<span>ユーザー名： <c:out value="${accountCreateForm.username}"/></span>
		<input type="hidden" name="username" value="${accountCreateForm.username}"/>
		<br />
		<span>パスワード： <c:out value="${accountCreateForm.password}"/></span>
		<input type="hidden" name="password" value="${accountCreateForm.password}"/>
		<br />
			
		<span>メールアドレス：</span>
		<input type="text" name="email" />
		<br />
		
		<br />
		<input value="確認画面へ" type="submit" />
		<br />
	</form:form>
	<br />
	<a href="../">インデックス画面へ</a>
</body>
</html>