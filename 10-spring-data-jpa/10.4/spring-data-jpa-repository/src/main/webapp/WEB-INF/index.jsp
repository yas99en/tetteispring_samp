<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>Spring Data JPA</title>
</head>
<body>
	<h2>Spring Data JPA</h2>
	<p>10.4.3の動作確認をするには、排他エラーを発生させる必要があります。</p>
	<p>確認方法</p>
	<ol>
		<li>2つのタブで当画面を表示する。</li>
		<li>片方は「room情報取得」をクリックし、もう片方は「排他制御確認」をクリックする。</li>
		<li>「排他制御確認」のクリックにて、DB情報が更新される。</li>
		<li>「room情報取得」では、エラーとなりDB更新がされない。</li>
		<li>コンソール画面にて「OptimisticLockingFailureException」をキャッチしている旨を確認する。</li>
	</ol>
	<a href="<c:url value="/room" />">room情報取得</a>
	<a href="<c:url value="/exclusion" />">排他制御確認</a>
</body>
</html>
