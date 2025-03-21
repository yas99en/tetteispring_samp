<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<meta charset="UTF-8">
	<title>5.12</title>
	<!-- 5.12.9 JavaScriptエスケープのみ行なうJSPの実装例 -->
	<script>
		var message = "<spring:escapeBody javaScriptEscape="true">${message1}</spring:escapeBody>";
	</script>
	<!-- 5.12.8 エスケープ有無のデフォルトの上書き -->
	<spring:htmlEscape defaultHtmlEscape="true"/>
</head>
<body>
	<h2>5.12.4 入力チェックエラーの判定</h2>
	それぞれの項目に値を入力し、確認ボタンを押下してください。<br />
	入力チェックエラーがある場合、エラー内容が確認ボタンの下に出力されます。
	<form:form modelAttribute="accountCreateForm">
		<span>名前 : </span>
		<form:input type="text" path="name" />
		<br />
		<span>誕生日 : </span>
		<form:input type="text" path="dateOfBirth" />
		<br />
		<span>誕生日(nested) : </span>
		<form:input type="text" path="accountCreateNestedForm.dateOfBirthNested" />
		5.12.5 spring:nestedPath併用時の動作確認用
		<br />
		<br />
		<strong>5.12.5 バインディング情報(BindStatus)の取得</strong><br /> 
		上記の「誕生日」「誕生日(nested)」に値を入力し、確認ボタンを押下してください。<br /> 
		「誕生日」に入力した値を取得 : 
		<spring:bind path="accountCreateForm.dateOfBirth">${status.displayValue}</spring:bind>
		<br />
		「誕生日(nested)」に入力した値を取得 :  
		<!-- pathが書籍記載のものと異なっていますが、上述のspring:bindの実装確認と同時に確認するために別のpathを指定しています。 -->
		<spring:nestedPath path="accountCreateNestedForm">
			<spring:bind path="dateOfBirthNested">${status.displayValue}</spring:bind>
		</spring:nestedPath>
		<br />
		<br />
		<strong>5.12.6 BindStatusと連携した文字列変換</strong><br /> 
		<form:select path="departureDate">
			<c:forEach items="${targetDateList}" var="targetDate">
				<spring:transform value="${targetDate}" var="formattedTargetDate" />
				<!-- 値の変換 -->
				<form:option value="${formattedTargetDate}">${formattedTargetDate}</form:option>
			</c:forEach>
		</form:select>
		<br />
		<br />
		<input value="確認" type="submit" />
		<br />
		<br />
	</form:form>
	<spring:hasBindErrors name="accountCreateForm">
		<div id="errorMessages">
			<p>入力値に誤りがあります。</p>
			<ul>
				<c:forEach items="${errors.allErrors}" var="error">
					<li><spring:message message="${error}" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>
	<br />
	
	<strong>5.12.8 エスケープ有無のデフォルトの上書き</strong><br />
	<span>エスケープテスト : </span>
	<spring:message code="escape.text" /><br />
	エスケープが有効(true)の場合は、spanタグが文字列として表示されます。<br />
	<br />
	<strong>5.12.9 出力値のエスケープ</strong><br />
	<ul>
		<li>
			<!-- 5.12.9 HTMLエスケープのみ行なうJSPの実装例 -->
			HTMLエスケープのみ行なうJSPの実装例 : <spring:escapeBody htmlEscape="true">${message2}</spring:escapeBody><br />
			エスケープが有効(true)の場合は、大なり小なり記号が表示されます。<br /><br />
		</li>
		<li>
			<!-- 5.12.9 HTMLエスケープ + JavaScriptエスケープを行なうJSPの実装例 -->
			HTMLエスケープ + JavaScriptエスケープを行なうJSPの実装例 : 開発者ツールのSourcesにてエスケープされていることを確認してください。<br />
			エスケープが有効(true)の場合は、ボタン押下で表示するポップアップに指定した文字列が表示されます。<br />
			<button type="submit" onclick="return confirm(
				'<spring:escapeBody htmlEscape='true' javaScriptEscape='true'>${message3}</spring:escapeBody>')">
				終了
			</button>
		</li>
	</ul>
	<br />
	<a href="/spring-webapp-spring-taglib">ホームへ</a>
</body>
</html>