<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>Demo</title>
</head>

<body>
    <h1>Demo</h1>
    アップロード先はcom/example/app/FileUploadController.javaのUPLOAD_PATHに定義します。<br>
    Windowsの場合、デフォルトではC:\upload_test配下にアップロードされます。<br>
    お使いの環境にあわせてアップロード先を変更ししてください。<br><br>
    <form:form modelAttribute="fileUploadForm" enctype="multipart/form-data">
    ファイル : <form:input path="file" type="file" /><br>
    <form:button>アップロード</form:button>
</form:form>
</body>

</html>
