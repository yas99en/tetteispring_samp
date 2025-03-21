<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>security</title>
</head>
<body>
	<div id="wrapper">
		<h3>ログイン成功</h3>
		<h4>認可を有効にした場合権限にあったページしか飛べない</h4>
		<a href="<c:url value="/admin/" />">管理</a><br/>
		<a href="<c:url value="/general/" />">一般</a><br/>	
		
		<form action="<c:url value='/logout'/>" method="post">
			<sec:csrfInput />
			<button>ログアウト</button>
		</form>
	</div>
</body>
</html>