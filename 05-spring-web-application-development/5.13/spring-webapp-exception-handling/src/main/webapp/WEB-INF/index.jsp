<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.13 例外ハンドリング</title>
</head>

<body>
    <h1>5.13 例外ハンドリング</h1>
    <section>
        <h2>5.13.3 サーブレットコンテナのエラーページ機能の利用</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/internal-server-error">ステータスコードを使用して遷移先を指定する際の設定例</a></li>
            <li><a href="${pageContext.request.contextPath}/teapot">
                    デフォルトの遷移先を指定する際の設定例(Servlet 3.1以上のサーブレットコンテナで利用可能)</a></li>
            <li><a href="${pageContext.request.contextPath}/exception-type-hierarchy">型階層を意識した遷移先の指定例</a></li>
        </ul>
    </section>
    <section>
        <h2>5.13.5 @ExceptionHandlerメソッドの利用</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/common-exception-handler-throughout-app">共通的な例外ハンドラの実装例</a></li>
        </ul>
    </section>
    <section>
        <h2>5.13.6 @ResponseStatusを指定した例外クラスの利用</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/response-status">@ResponseStatusを付与した例外クラスの作成例</a></li>
        </ul>
    </section>
</body>

</html>