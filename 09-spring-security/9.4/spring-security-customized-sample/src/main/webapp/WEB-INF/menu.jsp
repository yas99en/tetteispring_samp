<!DOCTYPE html>
<%-- 9.4.3.2. デフォルト動作のカスタマイズ 認証成功時に遷移するデフォルトのパスの変更 --%>
<html lang="ja-JP">
<head>
<title>security</title>
</head>
<body>
	<div id="wrapper">
		<h3>ログイン成功</h3>
		<br />
		<%-- 9.4.8.3. デフォルト動作のカスタマイズ --%>
		<form action="<c:url value='/auth/logout'/>" method="post">
			<sec:csrfInput />
			<button>ログアウト</button>
		</form>
		<br />
	</div>
</body>
</html>