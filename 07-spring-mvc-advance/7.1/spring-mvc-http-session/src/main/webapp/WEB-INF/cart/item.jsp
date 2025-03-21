<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="utf-8" />
	<title>7.1.2 商品画面</title>
</head>
<body>
	<p>商品画面</p>
	<p><c:out value="${messages}"/></p>
	<form:form modelAttribute="cartForm">
		<!-- 7.1.2.3 View(JSP)からアクセスする実装例 -->
		<spring:eval var="cart" expression="@cart" />
			<c:forEach var="cartItem" items="${cart.cartItems}">
			<p>${cartItem}</p>
			</c:forEach>
		
	</form:form>

	<br />
	<a href="../items/add">追加</a> <a href="../items/remove">減少</a> <a href="../cart/show">カート画面へ</a> <a href="../">インデックス画面へ</a>
</body>
</html>