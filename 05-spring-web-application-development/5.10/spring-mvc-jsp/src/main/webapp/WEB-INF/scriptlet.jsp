<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <title>スクリプトレット</title>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/includes/header.jsp" %>
</header>

<% for (String hobby : java.util.Arrays.asList("スポーツ", "映画", "音楽")) { %>
    <%= hobby %><br>
<% } %>

</body>
</html>
