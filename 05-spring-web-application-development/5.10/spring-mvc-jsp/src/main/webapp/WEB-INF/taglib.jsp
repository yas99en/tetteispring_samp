<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <title>タグライブラリ</title>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/includes/header.jsp" %>
</header>
<c:forEach var="hobby" items="スポーツ,映画,音楽">
    <c:out value="${hobby}" /><br>
</c:forEach>

</body>
</html>
