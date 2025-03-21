<!DOCTYPE html>
<html lang="ja-JP">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 9.6.2.2. Ajax使用時の連携 -->
		<sec:csrfMetaTags /> <!-- HTMLのmeta要素としてCSRFトークンの情報を出力 -->
		<title>Logout Success</title>
	</head>
	<body>
		<h1>Logout Success</h1>
		
		<a href="<c:url value="/login" />">ログイン画面へ戻る</a>
		
		<br>
		<a href="javascript:ajaxSendMessage()">Ajaxでメッセージを送信</a>
		
		<script src="<c:url value="/static/js/jquery-3.6.1.min.js" />"></script>
		<script type="text/javascript">
		
		// 9.6.2.2. Ajax使用時の連携
		$(function () {
			var headerName = $("meta[name='_csrf_header']").attr("content");
			var tokenValue = $("meta[name='_csrf']").attr("content");
			//　Ajax通信で不正なCSRFトークンが設定されている場合の検証をする際は、こちらの変数を有効にしてください。
			//var tokenValue = 'dummyToken';
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(headerName, tokenValue); // CSRFトークン値の設定
			});
			
			// 上記設定を行うことで、当画面からAJAX通信を実行した際にCSRFトークンヘッダーが設定される。
		});
		
		// Ajax検証用
		function ajaxSendMessage() {
			$.ajax({
				url: '<c:url value="/api/message" />',
				type: 'POST',
				data: JSON.stringify({
					message: 'hello world!!'
				}),
				contentType: 'application/json'
			}).done((data) => {
				console.log('ajax saccess');
			}).fail((jqXHR, textStatus, errorThrown) => {
				console.log('ajax failed');
			});
		}
		</script>
	</body>
</html>
