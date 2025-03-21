<!DOCTYPE html>
<html lang="ja-JP">
	<head>
		<title>8.3. データベースアクセスを伴う処理のテスト</title>
	</head>
	<body>
		<h1>8.3. データベースアクセスを伴う処理のテスト</h1>
		<ul>
			<li>
				<h3>8.3.1. テスト用のデータソースの設定</h3>
				<p>動作確認方法:</p>
				<p>サーバー上で実行時、PostgreSQLが接続先データベースに選択されていることを確認する。</p>
				<p>現在の接続先データベース「${dataSource}」</p>
				<p>テストについて、AccountRepositoryTest1.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.3.2. テストデータのセットアップ</h3>
				<p>動作確認方法:</p>
				<p>AccountRepositoryTest1.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.3.3.1. トランザクション境界の移動</h3>
				<p>動作確認方法:</p>
				<p>AccountRepositoryTest2.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.3.3.2. トランザクション境界でのロールバック/コミットの制御</h3>
				<p>動作確認方法:</p>
				<p>AccountRepositoryTest3.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
				<p>AccountRepositoryTest4.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.3.3.3. 永続コンテキストのフラッシュ</h3>
				<p>動作確認方法:</p>
				<p>AccountRepositoryTest5.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
				<p>AccountRepositoryTest6.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
			<li>
				<h3>8.3.4. テーブルの中身の検証</h3>
				<p>動作確認方法:</p>
				<p>AccountRepositoryTest1.javaを右クリックしてメニューを表示し、[Run As]->[JUnit Test]を選択してテストを実行し、成功することを確認する。</p>
			</li>
		</ul>
	</body>
</html>