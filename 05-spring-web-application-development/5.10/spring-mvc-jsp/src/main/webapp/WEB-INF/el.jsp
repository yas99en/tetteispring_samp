<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <title>EL(Expression Language)</title>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/includes/header.jsp" %>
</header>
<div>
    <span id="messageString">${messageString}</span>
    
	<!-- ↓ JavaBeansのtextプロパティを参照 --> 
	<span id="message">${message.text}</span>
	<!-- ↓ リストの先頭(0番目)の要素を参照 -->
	<span id="message">${messages[0].text}</span>
	<!-- ↓ マップ内のsportキーを参照 -->
	<span id="hobby">${hobbyCodeList.sport}</span>
	<!-- ↓ マップ内のキー名に「.」が含まれる場合は['キー名']形式で参照 -->
	<span id="messagesMap">${messagesMap['guidance.termsOfUse']}</span>
</div>
</body>
</html>
