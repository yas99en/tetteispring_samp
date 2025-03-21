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
		
		<!-- 9.6.2.1. HTMLフォーム使用時のトークン値の連携 -->
		<form action="<c:url value='/logout'/>" method="post">
			<sec:csrfInput /> <!-- hidden要素としてCSRFトークン値を埋め込む -->
			<button>ログアウト</button>
		</form>
	</div>
</body>
</html>