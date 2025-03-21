<!DOCTYPE html>
<html lang="ja-JP">
<head>
    <!-- 5.12.2 MessageSourceに定義した値が出力される-->
	<title><spring:message code="title.home"/></title>
	<!-- 5.12.3 指定したテーマが出力される-->
	<spring:theme code="stylesheet" var="stylesheet"/>
	<link rel="stylesheet" href="<c:url value='/resources/${stylesheet}'/>">
</head>
<body>
    <h2>5.12 Springの汎用タグライブラリの利用</h2>
    <ul>
        <li><strong>5.12.1 タグライブラリのセットアップ</strong><br/>
        	include.jspにタグライブラリの読み込み定義を追加しています。<br/>
        	<br/>
        </li>
        <li><strong>5.12.2 ロケール別のメッセージの出力</strong><br/>
        	メッセージの定義 : ブラウザでページのタイトルを確認してください。<br/>
	          プレースホルダ : <spring:message code="guidance.passwordValidPolicy" arguments="90"/><br/>
	          プレースホルダ複数 : <spring:message code="multi.placeholder">
				<spring:argument value="argument1"/>
				<spring:argument value="argument2"/>
			</spring:message><br/>
	        <br/>
	    </li>
	    <li><strong>5.12.3 テーマ別のメッセージの出力</strong><br/>
	        テーマ別確認 : <a href="?theme=default">テーマ1</a>  <a href="?theme=default2">テーマ2</a><br/>
	        クリックすると属性ファイルが変更され、背景色が変わります。HTMLの出力は開発者ツールにて確認してください。<br/>
	        <br/>
	    </li>
	    <li><strong>5.12.4 入力チェックエラーの判定</strong><br/>
        	入力ビュー(createForm)へ <a href="create">リンク</a><br/>
        	遷移先でフォームに値を入力し、確認ボタンを押下すると入力チェックが実行されます。意図的にエラーを表示させて確認してください。<br/>
	        <br/>
	    </li>
	    <li><strong>5.12.5 バインディング情報（BindStatus）の取得</strong><br/>
        	入力ビュー(createForm)へ <a href="create">リンク</a><br/>
        	遷移先でフォームに値を入力し、確認ボタンを押下してください。バインディング情報として取得した値が表示されることを確認してください。<br/>
	        <br/>
	    </li>
	    <li><strong>5.12.6 BindStatusと連携した文字列変換</strong><br/>
        	入力ビュー(createForm)へ <a href="create">リンク</a><br/>
        	遷移先でプルダウンリストの値の表示形式を確認してください。<br/>
	        <br/>
	    </li>
		<li><strong>5.12.7 URLの生成</strong><br />
			下記の結果を確認してください。<br/>
			<spring:url value="/users/{userId}" var="userUrl">
				<spring:param name="userId" value="${userId}" />
			</spring:url>
			<a href="${userUrl}"><c:out value="${userId}" /></a><br />
			<br />
		</li>
		<li><strong>5.12.8 エスケープ有無のデフォルトの上書き</strong><br/>
        	入力ビュー(createForm)へ <a href="create">リンク</a><br/>
        	遷移先でHTMLタグが文字列表示されていることを確認してください(エスケープが有効(true)の場合、タグ表記が文字列として認識されるため)。<br/>
	        <br/>
	    </li>
	    <li><strong>5.12.9 出力値のエスケープ</strong><br/>
        	入力ビュー(createForm)へ <a href="create">リンク</a><br/>
            リンク押下後にポップアップが表示されないことを確認してください(JavaScriptエスケープが有効(true)の場合、文字列として認識されるため)。<br/>
	        <br/>
	    </li>
	    <li><strong>5.12.10 SpELの実行結果の取得</strong><br/>
	    	下記の結果を確認してください。<br/>
        	<spring:message code="guidance.passwordValidPolicy">
			    <spring:argument>
					<spring:eval expression="@appSettings.passwordValidDays"/>
				</spring:argument>
			</spring:message>
	        <br/>
	        <br/>
	    </li>
      <li><strong>5.12.11 リクエストマッピング情報と連携したURLの生成</strong><br/>
      	STSではspring:mvcUrl関数が認識できずエラー表示になるため、コメントアウトしています。<br/>
    		動作確認の際はコメントアウトを外して確認してください。
    <!--    <a href="${spring:mvcUrl('MC#view').build()}">メニューへ</a><br/>
	        <br/>-->
	        <!-- URIテンプレートのパス変数に引数値を埋め込む -->
    <!--  	<a href="${spring:mvcUrl('UC#viewDetail').arg(0, userId).build()}">
				<c:out value="${userId}"/>
			</a><br/> 
	    </li>-->
    </ul>

</body>
</html>