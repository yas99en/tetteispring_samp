<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>5.11</title>
</head>
<body>

	<form:form modelAttribute="accountForm">
		ユーザー名:<form:input path="username"/><br> 
		パスワード:<form:password path="password"/><br> 
		
		<spring:eval expression="@hobbyCodeList" var="hobbyCodeList"/> 
		趣味:<form:checkboxes path="hobbies" items="${hobbyCodeList}" /><br> 
		
		<spring:eval expression="@genderCodeList" var="genderCodeList"/> 
		性別:<form:radiobuttons path="gender" items="${genderCodeList}" /> 
		    <!-- form:radiobuttonを使った場合の書き方。こちらでも可能。 -->
			<!-- 
			<form:radiobutton path="gender" value="men" label="男性" /> 
			<form:radiobutton path="gender" value="women" label="女性" />
			 -->
		<form:hidden path="gender" /><br> 
		
		<spring:eval expression="@prefectureCodeListForNorthKanto" var="prefectureCodeListForNorthKanto"/>
		<spring:eval expression="@prefectureCodeListForSouthKanto" var="prefectureCodeListForSouthKanto"/>
		お住まい:	<form:select path="livingPrefecture">
					<form:option value="" label="--選択してください--"/>
					<optgroup label="北関東">
						<form:options items="${prefectureCodeListForNorthKanto}"/>
					</optgroup>
					<optgroup label="南関東">
						<form:options items="${prefectureCodeListForSouthKanto}"/> 
					</optgroup>
				</form:select><br> 
		
		<form:label path="opinionsAndRequests">ご意見・ご要望</form:label>: 
		<form:textarea path="opinionsAndRequests"/><br> 
		
		利用規約:	<form:checkbox path="agreement" value="true" label="同意する"/> 
		<form:errors path="agreement" /><br> 
		
		<form:button>確認</form:button>
	</form:form>
 	
</body>
</html>