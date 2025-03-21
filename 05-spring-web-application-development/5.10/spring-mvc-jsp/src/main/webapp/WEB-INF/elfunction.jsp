<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<span>${fn:escapeXml(form.memo)}</span><br>
</div>
</body>
</html>
