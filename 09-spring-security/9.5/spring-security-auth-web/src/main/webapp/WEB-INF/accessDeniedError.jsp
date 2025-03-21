<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>security</title>
</head>
<body>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

	<div id="wrapper">
		<h3>認可エラー</h3>
		<a href="<c:url value="/login" />">ログイン画面へ戻る</a>
	</div>

</body>
</html>