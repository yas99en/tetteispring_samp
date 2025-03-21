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
		<%-- 9.4.2.4. デフォルト動作のカスタマイズ 認証パスを"/authenticate"に変更 --%>
		<c:url var="loginUrl" value="/authenticate" />
		<form:form action="${loginUrl}">
			<table>
				<tr>
					<td><label for="username">ユーザー名</label></td>
					<%-- 9.4.2.4. デフォルト動作のカスタマイズ ユーザー名のリクエストパラメータを"uid"に変更 --%>
					<td><input type="text" id="uid" name="uid"></td>
				</tr>
				<tr>
					<td><label for="password">パスワード</label></td>
					<%-- 9.4.2.4. デフォルト動作のカスタマイズ パスワードのリクエストパラメータを"pwd"に変更 --%>
					<td><input type="password" id="pwd" name="pwd"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button>ログイン</button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>