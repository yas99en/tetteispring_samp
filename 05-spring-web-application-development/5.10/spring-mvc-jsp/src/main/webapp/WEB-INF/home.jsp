<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <title>ホーム</title>
</head>
<body>
<h1>ホーム</h1>
<ul>
    <li><a href="<c:url value="/scriptlet/"/>">スクリプトレット</a></li>
    <li><a href="<c:url value="/taglib/"/>">タグライブラリ</a></li>
    <li><a href="<c:url value="/tagfile/"/>">タグファイル</a></li>
    <li><a href="<c:url value="/el"/>">EL(Expression Language)</a></li>
    <li><a href="<c:url value="/elfunction/"/>">EL関数</a></li>
    <li><a href="<c:url value="/jstl/"/>">JSTLの利用</a></li>

</ul>
<footer>
    <%@ include file="includes/footer.jsp" %>
</footer>
</body>
</html>
