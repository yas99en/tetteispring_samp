<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.1 入力画面（2/3）</title>
</head>
<body>
	<p>入力画面（2/3）</p>
	<form:form modelAttribute="accountCreateForm">

		<!-- 7.1.1.4 View(JSP)からアクセスする実装例 -->
		<span>ユーザー名： <c:out value="${accountCreateForm.username}"/></span>
		<input type="hidden" name="username" value="${accountCreateForm.username}"/>
		<br />
		
		<span>パスワード：</span>
		<input type="text" name="password" />	
		<br />
		
		<br />
		<input value="入力画面（3/3）へ" type="submit" />
		<br />
	</form:form>
	<br />
	<a href="../">インデックス画面へ</a>
</body>
</html>