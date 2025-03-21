<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.7-sample</title>
</head>

<body>

	<h1>入力チェックの切替 サンプル</h1>
    <form:form modelAttribute="accountSwitchCheckForm">
    	<span>タイプ：</span>
		<input name="type" type="radio" value="1" checked="checked" />
		<span>無料会員</span>
		<input name="type" type="radio" value="2" />
		<span>有料会員</span>
		<br><br>
		
		<span>カード番号：</span>
		<input type="text" name="cardNo" id="cardNo" />
		<input type="hidden" name="confirm" />
		&nbsp; <form:errors path="cardNo" /><br><br>
		
		<input value="確認" type="submit"/><br>
	</form:form>
	<br>
	
	<div id="messages">
		<form:errors path="*" />
	</div>
	
	<span>
		書籍の5.7.7の内容を本サンプルで確認できます。<br>
	</span>
	
</body>

</html>
