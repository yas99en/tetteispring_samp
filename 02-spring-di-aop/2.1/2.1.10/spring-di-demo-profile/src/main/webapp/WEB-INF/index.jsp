<!DOCTYPE html>
<html lang="ja-JP">
	<head>
		<title>2.1.10. コンフィギュレーションのプロファイル化</title>
	</head>
	<body>
		<h1>2.1.10. コンフィギュレーションのプロファイル化</h1>
		<ul>
			<li>
				<h3>2.1.10.1. プロファイルの定義方法、2.1.10.2. 使用するプロファイルの選択方法</h3>
				<p>動作確認方法:</p>
				<p>
					「web.xml（パス：spring-di-demo-profile\src\main\webapp\WEB-INF\web.xml）」の「spring.profiles.active」の値を
					「production」または「development」または「test」に設定する
				</p>
				<p>
					Webアプリケーション（spring-di-demo-profile）をデプロイして「http://localhost:8080/spring-di-demo-profile/」というURLにアクセスし、
					production環境下、development環境下、test環境下それぞれでの正しい情報がコンソールに表示されることを確認する。
				</p>
			</li>
		</ul>
	</body>
</html>