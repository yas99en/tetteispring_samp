<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>Demo</title>
</head>

<body>
    <h1>Demo</h1>
    <dl>
        <dt>content type</dt>
        <dd>
            <c:out value="${contentType}" />
        </dd>
        <dt>parameter name</dt>
        <dd>
            <c:out value="${parameterName}" />
        </dd>
        <dt>original filename</dt>
        <dd>
            <c:out value="${originalFilename}" />
        </dd>
        <dt>file size</dt>
        <dd>
            <c:out value="${fileSize}" />
        </dd>
        <dt>upload filepath</dt>
        <dd>
            <c:out value="${uploadFile}" />
        </dd>
    </dl>
</body>

</html>
