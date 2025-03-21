<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>security</title>
</head>
<body>
	<div id="wrapper">
		<h2>ログイン成功</h2>
		<p>
			権限にあったページのみ遷移可能<br>※ADMINでログインした場合はどちらのページにも遷移可能
		</p>
		<p>
			※「9.5.5.3. メソッド実行後に適用するアクセスポリシーの指定」の適用後、管理者ユーザーのみページ遷移可能
		</p>
		<!-- 9.5.5 メソッドへの認可 の動作確認は「一般」押下すると確認できます。実装内容の詳細はGeneralController.javaを参照してください。 -->
		<ul>
			<li><a href="<c:url value="/admin/" />">管理</a><br />
			<li><a href="<c:url value="/general/" />">一般</a><br /></li>
		</ul>

		<!-- 9.5.6 JSPの画面項目への認可 -->
		<sec:authorize access="hasRole('ADMIN')">
			<h2>管理者メニュー</h2>
		</sec:authorize>
		<ul>
			<sec:authorize url="/admin">
				<li><a href="<c:url value='/admin' />">アカウント管理</a></li>
			</sec:authorize>
		</ul>

		<form action="<c:url value='/logout'/>" method="post">
			<sec:csrfInput />
			<button>ログアウト</button>
		</form>
	</div>
</body>
</html>