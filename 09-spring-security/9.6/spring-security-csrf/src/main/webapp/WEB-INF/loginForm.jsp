<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>security</title>
</head>
<body>
	<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sec"
		uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	<div id="wrapper">
		<h3>ログインフォーム</h3>
		<c:if test="${param.containsKey('error')}">
			<span style="color: red;"> <c:out
					value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</span>
		</c:if>
		<c:url var="loginUrl" value="/login" />
		
		<!-- 9.6.4. CSRF対策機能とSpring MVCとの連携 -->
		<form:form action="${loginUrl}">
			<table>
				<tr>
					<td><label for="username">ユーザー名</label></td>
					<td><input type="text" id="username" name="username"></td>
				</tr>
				<tr>
					<td><label for="password">パスワード</label></td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button>ログイン</button></td>
				</tr>
			</table>
		</form:form>

		<a href = "/spring-security-csrf/resources/testpage">/resources/** 配下のページにアクセス</a>
	</div>
</body>
</html>