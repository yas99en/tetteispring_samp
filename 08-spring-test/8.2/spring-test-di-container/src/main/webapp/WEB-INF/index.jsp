<!DOCTYPE html>
<html lang="ja-JP">
	<head>
		<title>8.2. DIコンテナ管理のBeanに対するテスト</title>
	</head>
	<body>
		<h1>8.2. DIコンテナ管理のBeanに対するテスト</h1>
		<ul>
			<li>
				<h3>8.2. DIコンテナ管理のBeanに対するテスト、8.2.1. Beanの単体テスト</h3>
				<p>動作確認方法:</p>
				<p>MessageServiceTest.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.2.1. Bean定義ファイルの作成、8.2.2.2. テストケースの作成と実行、8.2.4. DIコンテナのコンフィギュレーション</h3>
				<p>動作確認方法:</p>
				<p>MessageServiceIntegrationTest1.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.4.1. デフォルトのBean定義ファイル</h3>
				<p>動作確認方法:</p>
				<p>MessageServiceIntegrationTest2.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.4.2. Webアプリケーション向けのDIコンテナのコンフィギュレーション</h3>
				<p>動作確認方法:</p>
				<p>WebApplicationIntegrationTest.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.5.2. DIコンテナの破棄</h3>
				<p>動作確認方法:</p>
				<p>MessageServiceIntegrationTest1.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.6. プロファイルの指定</h3>
				<p>動作確認方法:</p>
				<p>サーバー上で実行時、環境変数等を用いて環境を切り替えつつ、default環境ではPostgreSQL、dev環境ではH2が接続先データベースに選択されていることを確認する。</p>
				<p>現在の接続先データベース「${dataSource}」</p>
				<p>テストについて、WebApplicationIntegrationTest.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.7. テスト用のプロパティ値の指定、8.2.7.1. アノテーションに直接指定</h3>
				<p>動作確認方法:</p>
				<p>AuthenticationServiceIntegrationTest1.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.2.7.2. プロパティファイルに指定</h3>
				<p>動作確認方法:</p>
				<p>AuthenticationServiceIntegrationTest2.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
		</ul>
	</body>
</html>