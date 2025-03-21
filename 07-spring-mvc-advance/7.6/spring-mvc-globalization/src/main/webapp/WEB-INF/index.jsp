<!DOCTYPE html>
<html lang="ja-JP">
	<head>
		<meta charset="utf-8" />
		<title>7.6 国際化</title>
	</head>
	<body>
		<!-- 7.6.2.ロケールの利用 JSPの実装例 -->
		<spring:message code="title.home"/>
		<!-- 7.6.3.3. ロケール切り替え用の画面要素の表示 ロケールの切り替えをリンクで行う場合の実装例 -->
		<a href="?locale=en">English</a>
		<a href="?locale=ja">Japanese</a>
		<form action="make">
			<input name="scope" value="daily" hidden=true />
			<input type="submit" value="ロケールの利用" />
		</form>
	</body>
</html>