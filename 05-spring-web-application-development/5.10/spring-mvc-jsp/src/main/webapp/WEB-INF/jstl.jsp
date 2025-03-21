<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <title>JSTL</title>
</head>
<body>
<header>
	<c:import url="/WEB-INF/includes/header.jsp" />
</header>
<span>${fn:escapeXml(message.text)}</span><br>

<fmt:setLocale value="ja_JP" variant="JP"/>
<fmt:formatNumber value="${10000}" type="currency" currencyCode="JPY"/><br>

</body>
</html>
