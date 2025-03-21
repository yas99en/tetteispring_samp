<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
<meta charset="UTF-8">
<title>Viewとのデータ連携</title>
</head>
<body>
	<h2>データ連携先ページ</h2>
	<span>アカウントID:<c:out value="${account.accountId}" /> </span><br>
	<span>アカウント名：<c:out value="${account.name}" /> </span><br>
	
	<a href="${pageContext.request.contextPath}">ホームへ</a>
</body>
</html>