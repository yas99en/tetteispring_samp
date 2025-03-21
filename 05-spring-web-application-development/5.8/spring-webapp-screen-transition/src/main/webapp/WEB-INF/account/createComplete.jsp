<!DOCTYPE html>
<html lang="ja-JP">

<head>
	<title>Complete</title>
</head>

<body>
	<p>コンプリート</p>
	<!-- 5.8.4JSPからModelに格納したJavaオブジェクトへアクセスする実装例 -->
	<c:choose>
		<c:when test="${empty account}">
			<span>アカウントID1:
				<c:out value="${param.accountId}" />
			</span> <br>
			<span>アカウント名：
				<c:out value="${param.name}" />
			</span> <br>
		</c:when>
		<c:otherwise>
			<span>アカウントID:
				<c:out value="${account.accountId}" />
			</span> <br>
			<span>アカウント名：
				<c:out value="${account.name}" />
			</span> <br>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/auth/login">リクエストパスへのフォワードの確認</a><br>
	<a href="${pageContext.request.contextPath}">ホームへ</a>
</body>

</html>