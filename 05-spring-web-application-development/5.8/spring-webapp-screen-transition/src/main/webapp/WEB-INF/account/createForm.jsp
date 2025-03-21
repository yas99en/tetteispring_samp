<!DOCTYPE html>
<html lang="ja-JP">

<head>
	<title>5.8-createForm</title>
</head>

<body>
	<form:form action="${pageContext.request.contextPath}/account/create" method="post"
		modelAttribute="accountCreateForm">
		<input value="次画面へPOST" type="submit" />
	</form:form>
	<form:form action="${pageContext.request.contextPath}/account/create2" method="post"
		modelAttribute="accountCreateForm">
		<input value="次画面へPOST" type="submit" />
	</form:form>
	<form:form action="${pageContext.request.contextPath}/account/create3" method="post"
		modelAttribute="accountCreateForm">
		<input value="次画面へPOST" type="submit" />
	</form:form>
	<a href="${pageContext.request.contextPath}">ホームへ</a>

</body>

</html>