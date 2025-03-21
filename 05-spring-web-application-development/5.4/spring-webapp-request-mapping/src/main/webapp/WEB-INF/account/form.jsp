<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <title>登録画面</title>
</head>

<body>
    <h1>登録画面</h1>
    <form:form modelAttribute="accountCreateForm" method="post"
        action="${pageContext.request.contextPath}/accounts/create">
        <form:label path="name">名前:</form:label>
        <form:input path="name" />
        <form:errors path="name" />
        <br>
        <form:label path="tel">電話番号:</form:label>
        <form:input path="tel" />
        <form:errors path="tel" />
        <br>
        <form:label path="dateOfBirth">生年月日:</form:label>
        <form:input path="dateOfBirth" />
        <form:errors path="dateOfBirth" />
        <br>
        <form:label path="email">電子メール:</form:label>
        <form:input path="email" />
        <form:errors path="email" />
        <br>
        <form:button name="confirm">確認</form:button>
    </form:form>
</body>

</html>