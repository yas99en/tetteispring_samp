<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.7-sample</title>
</head>

<body>

	<h1>入力チェック サンプル</h1>
    <form:form modelAttribute="accountSearchForm"> 
		<span>名前</span><form:input path="name" /> &nbsp; <form:errors path="name" /><br>
		<span>TEL</span><form:input path="tel" /> &nbsp; <form:errors path="tel" /><br>
		<span>誕生日</span><form:input path="dateOfBirth" type="date" /> &nbsp; <form:errors path="dateOfBirth" /><br> 
		<span>E-Mail</span><form:input path="email" type="email" /> &nbsp; <form:errors path="email" /><br><br>
		<input value="確認" type="submit"/><br><br>
		
		<!-- 5.7.8 すべてのエラーメッセージをまとめて表示 -->
		<div id="messages">
			<form:errors path="*" />
		</div>
	</form:form>
	<br>
	
	<span>
		書籍の5.7.1〜5.7.3, 5.7.8 と 5.7.4の一部の内容を本サンプルで確認できます。<br>
		<br>
		このサンプルでは、各項目に以下の入力制限が入っています。<br>
		<ul>
    		<li>名前：1〜50文字以内で入力、それ以外はエラー</li>
    		<li>TEL：9〜11文字かつ数字で入力、それ以外はエラー</li>
    		<li>誕生日：未入力の場合エラー</li>
    		<li>E-Mail：9〜256文字で入力、それ以外はエラー</li>
    	</ul>
    	エラーでない場合は、次画面へ遷移します。<br>
	</span>
	
</body>

</html>
