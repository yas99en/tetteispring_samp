<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <title>登録確認画面</title>
</head>

<body>
    <h1>登録確認画面</h1>
    <form:form modelAttribute="accountCreateForm" method="post"
        action="${pageContext.request.contextPath}/accounts/create">
        <form:label path="name">名前:</form:label>
        <form:hidden path="name" />
        <c:out value="${accountCreateForm.name}" />
        <br>
        <form:label path="tel">電話番号:</form:label>
        <form:hidden path="tel" />
        <c:out value="${accountCreateForm.tel}" />
        <br>
        <form:label path="dateOfBirth">生年月日:</form:label>
        <form:hidden path="dateOfBirth" />
        <fmt:formatDate pattern="yyyy/MM/dd" value="${accountCreateForm.dateOfBirth}" />
        <br>
        <form:label path="email">電子メール:</form:label>
        <form:hidden path="email" />
        <c:out value="${accountCreateForm.email}" />
        <br>
        <form:button name="redo">戻る</form:button>
        <form:button name="create">登録</form:button>
    </form:form>
</body>

</html>