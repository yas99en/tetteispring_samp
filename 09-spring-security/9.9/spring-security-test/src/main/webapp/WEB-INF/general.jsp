<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>security</title>
</head>
<body>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<div id="wrapper">
		<h3>ログイン成功(general)</h3>
		<a href="<c:url value="/login" />">ログイン画面へ戻る</a>
	</div>
	
	<sec:authorize access="hasRole('ADMIN')">
 		<h2>ADMINの場合のみ表示される</h2>
 	</sec:authorize>
 	
 	<ul>
	 <sec:authorize url="/admin">
		 <li>
		 	<a href="<c:url value='/admin' />">アカウント管理(admin)</a>
		 </li>
	 </sec:authorize> 
	</ul>
	
</body>
</html>