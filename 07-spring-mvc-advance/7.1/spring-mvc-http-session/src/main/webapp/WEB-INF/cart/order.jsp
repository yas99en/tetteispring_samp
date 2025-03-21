<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.2 注文画面</title>
</head>
<body>
	<p>注文画面</p>
	<p><c:out value="${messages}"/></p>
	<form:form modelAttribute="cartForm">
				
		<spring:eval var="cart" expression="@cart" />
			<c:forEach var="cartItem" items="${cart.cartItems}">
			<p>${cartItem}</p>
			</c:forEach>
		
	</form:form>

	<br />
	<a href="../orders/add">追加</a> <a href="../orders/remove">減少</a> <a href="../">インデックス画面へ</a>
</body>
</html>