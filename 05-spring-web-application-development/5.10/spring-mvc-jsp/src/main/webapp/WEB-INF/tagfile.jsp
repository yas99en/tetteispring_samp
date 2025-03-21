<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <title>タグファイル</title>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/includes/header.jsp" %>
</header>

<myTags:printTokens tokensString="スポーツ,映画,音楽" />

</body>
</html>
