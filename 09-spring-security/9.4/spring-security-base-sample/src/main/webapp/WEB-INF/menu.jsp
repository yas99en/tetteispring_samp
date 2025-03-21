<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>security</title>
</head>
<body>
	<div id="wrapper">
		<h3>ログイン成功</h3>
		<%-- 本書ではuuidとなっているが本サンプルではuserNameとする --%>
		<span>9.4.10 認証情報へのアクセス</span><br /> <span> ようこそ、 <sec:authentication
				property="principal.account.username" /> さん。
		</span><br />
		<br /> <span>9.4.11 認証処理とSpring MVCの連携</span><br /> <span>account.username
			: ${account.username}</span><br />
	</div>
	<form action="<c:url value='/logout'/>" method="post">
		<sec:csrfInput />
		<button>ログアウト</button>
	</form>
</body>
</html>