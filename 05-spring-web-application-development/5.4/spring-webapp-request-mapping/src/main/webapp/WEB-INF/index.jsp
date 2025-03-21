<!DOCTYPE html>
<html lang="ja-JP">

<head>
    <meta charset="utf-8" />
    <title>5.4 リクエストマッピング</title>
    <script>
        const demoUser = {
            name: "John Doe",
            tel: "03-1111-1111",
            dateOfBirth: "2000/1/1",
            email: "john@example.com",
        };
        function testFetchingJSON(el, address, headers = {}, body = demoUser) {
            const url = "${pageContext.request.contextPath}/accounts/" + address;
            const init = { method: "POST", headers, body: JSON.stringify(body) };
            fetch(url, init)
                .then((response) => response.json())
                .then((data) => {
                    el.appendChild(document.createTextNode(JSON.stringify(data)));
                    el.appendChild(document.createElement("br"));
                });
        }
        function demoRequestHeader() {
            testFetchingJSON(
                document.querySelector("#result-request-header-demo"),
                "request-header-demo/create",
                { "Content-Type": "application/json", "X-Migration": "true" },
            );
        }
        function demoContentType() {
            testFetchingJSON(
                document.querySelector("#result-content-type-demo"),
                "content-type-demo/create",
                { "Content-Type": "application/json" },
            );
        }
        function demoAccept() {
            testFetchingJSON(
                document.querySelector("#result-accept-demo"),
                "accept-demo/create",
                { "Content-Type": "application/json", "Accept": "application/json" },
            );
        }
    </script>
</head>

<body>
    <h1>5.4 リクエストマッピング</h1>
    <section>
        <h2>5.4.1 リクエストパスの使用</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/accounts/me/email">リクエストパスの指定例</a></li>
            <li><a href="${pageContext.request.contextPath}/accounts/me/email2">リクエストパスの複数指定例 (1)</a></li>
            <li><a href="${pageContext.request.contextPath}/accounts/my/email2">リクエストパスの複数指定例 (2)</a></li>
        </ul>
    </section>
    <section>
        <h2>5.4.2 パスパターンの使用</h2>
        <a href="${pageContext.request.contextPath}/accounts/JohnDoe">
            URIテンプレート形式のパスパターンの指定例
        </a>
        <c:out value="(${pageContext.request.contextPath}/accounts/{UserID})" />
    </section>
    <section>
        <h2>5.4.4 リクエストパラメータの使用</h2>
        <a href="${pageContext.request.contextPath}/accounts/create?form=">リクエストパラメータを使用したリクエストマッピングの指定例</a>
    </section>
    <section>
        <h2>5.4.5 リクエストヘッダーの使用、5.4.6 Content-Typeヘッダーの使用、5.4.7 Acceptヘッダーの使用</h2>
        <ul>
            <li>
                リクエストヘッダーの指定例
                <button onclick="demoRequestHeader()">テスト</button>
                <div id="result-request-header-demo"></div>
            </li>
            <li>
                Content-Typeの指定例
                <button onclick="demoContentType()">テスト</button>
                <div id="result-content-type-demo"></div>
            </li>
            <li>
                Acceptの指定例
                <button onclick="demoAccept()">テスト</button>
                <div id="result-accept-demo"></div>
            </li>
        </ul>
    </section>
</body>

</html>