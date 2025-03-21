<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.7-sample</title>
</head>

<body>

	<h1>入力チェック サンプル</h1>
    <form:form modelAttribute="accountInputValueCheckForm"> 
    	<span>必須チェック</span><form:input path="item1" /> &nbsp; <form:errors path="item1" /><br>
    	<span>桁数(サイズ)チェック</span><form:input path="item2" /> &nbsp; <form:errors path="item2" /><br>
    	<span>文字種チェック</span><form:input path="item3" /> &nbsp; <form:errors path="item3" /><br>
    	<span>数値の範囲チェック</span><form:input path="item4" /> &nbsp; <form:errors path="item4" /><br>
    	<span>日時の妥当性チェック</span><form:input path="item5" type="date" /> &nbsp; <form:errors path="item5" /><br>
    	<span>真偽値チェック</span><form:input path="item6" /> &nbsp; <form:errors path="item6" /><br>
    	<span>数値の範囲チェック</span><form:input path="item7" /> &nbsp; <form:errors path="item7" /><br>
		<input value="入力チェック" type="submit"/><br>
	</form:form>
	<br>
	
	<span>
		書籍の5.7.4の内容を本サンプルで確認できます。<br>
		<br>
		このサンプルでは、各項目に以下の入力制限が入っています。<br>
		<ul>
    		<li>必須チェック：未入力の場合エラー</li>
    		<li>桁数(サイズ)チェック：50文字以上の場合はエラー</li>
    		<li>文字種チェック：英数字以外はエラー</li>
    		<li>数値の範囲チェック：1〜100以外の数値はエラー</li>
    		<li>日時の妥当性チェック：未来日付の場合はエラー</li>
    		<li>真偽値チェック：trueでない場合はエラー</li>
    		<li>数値の範囲チェック：−99.99から99.99の範囲でない場合はエラー</li>
    	</ul>
	</span>
	
</body>

</html>
