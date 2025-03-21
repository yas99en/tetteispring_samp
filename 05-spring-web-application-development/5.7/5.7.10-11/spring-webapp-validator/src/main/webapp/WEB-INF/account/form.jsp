<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>5.7-sample</title>
</head>
<body>
	<form:form modelAttribute="accountCreateForm">

		<span>タイプ：</span>
		<input type="radio" name="type" value="1" checked="checked" />
		<span>無料会員</span>
		<input type="radio" name="type" value="2" />
		<span>有料会員</span><br><br>
		
		<span>カード番号：</span>
		<input type="text" name="cardNo" id="cardNo" /><br><br>
		
		<input value="確認" type="submit" />
	</form:form>

	<p>
		<c:out value="${confirm}" />
		<c:out value="${output}" />
	</p>
	
</body>
</html>