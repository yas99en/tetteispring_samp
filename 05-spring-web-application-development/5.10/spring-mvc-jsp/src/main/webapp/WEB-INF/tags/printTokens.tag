<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="tokensString" type="java.lang.String" required="true"%>

<!-- タグファイルの作成例(/WEB-INF/tags/printTokens.tag) -->

<c:forEach var="token" items="${tokensString}">
    <c:out value="${token}" /><br>
</c:forEach>

