<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="tokensString" type="java.lang.String" required="true"%>

<!-- タグファイルの作成例(/WEB-INF/tags/printTokens.tag) -->

<c:forEach var="token" items="${tokensString}">
    <c:out value="${token}" /><br>
</c:forEach>

