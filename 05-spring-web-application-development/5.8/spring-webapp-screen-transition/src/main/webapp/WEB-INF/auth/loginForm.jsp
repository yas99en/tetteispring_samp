<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
<meta charset="UTF-8">
<title>フォワードのチェック</title>
</head>
<body>
	<h2>フォワード画面のチェック</h2>
	<span>ブラウザのURLが/auth/authenticateになっておらず、Controller側で指定した値になっていればOK。</span>
	
	<a href="${pageContext.request.contextPath}">ホームへ</a>
</body>
</html>