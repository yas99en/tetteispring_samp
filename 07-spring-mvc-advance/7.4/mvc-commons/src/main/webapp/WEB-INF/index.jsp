<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>Demo</title>
</head>

<body>
    <h1>Demo</h1>
    
    <p>7.4.1.2. Spring提供のサーブレットフィルタ</p>
    <p>7.4.2. HandlerInterceptorの利用</p>
    <code>curl -L localhost:8080/mvc-commons</code>
    <p>7.4.3. @ControllerAdviceの利用</p>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/arith">ArithmeticException</a>
        </li>
    </ul>
    <p>7.4.4. HandlerMethodArgumentResolverの利用</p>
    <ul>
        <li>
            <c:out value="userAgent : ${userAgent}" />
        </li>
        <li>
            <c:out value="sessionId : ${sessionId}" />
        </li>
    </ul>
    <p>
        <c:out value="${now}" />
    </p>
</body>

</html>
