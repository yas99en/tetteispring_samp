<!DOCTYPE html>
<html lang="ja-JP">
<head>
	<title>11.4. MyBatisでの応用的なCRUD操作</title>
</head>
<body>
	<h1>11.4. MyBatisでの応用的なCRUD操作 動作確認</h1>
	<h2>11.4.1.1. &lt;where&gt;、&lt;if&gt;の実装例</h2>
	<ul>
		<li><a href="<c:url value="/room/find-by-criteria" />">findByCriteriaメソッドを検証</a></li>
	</ul>

	<h2>11.4.1.2. &lt;choose&gt;の実装例</h2>
	<ul>
		<li><a href="<c:url value="/room/find-by-capacity-class" />">findByCapacityClassメソッドを検証</a></li>
	</ul>
	
	<h2>11.4.1.3. &lt;foreach&gt;の実装例</h2>
	<ul>
		<li><a href="<c:url value="/room/find-by-room-ids" />">findByRoomIdsメソッドを検証</a></li>
	</ul>
	
	<h2>11.4.1.4. &lt;set&gt;の実装例</h2>
	<ul>
		<li><a href="<c:url value="/room/update" />">updateメソッドを検証</a></li>
	</ul>
	
	<h2>11.4.3.1. 主テーブルと関連テーブルのレコードを別々に取得してマッピングする方法</h2>
	<ul>
		<li><a href="<c:url value="/room/find-one" />">findOneメソッドを検証</a></li>
	</ul>
	
	<h2>11.4.3.2. テーブル結合を利用して関連オブジェクトをマッピングする方法</h2>
	<ul>
		<li><a href="<c:url value="/room/select-join-meeting-room" />">selectJoinMeetingRoomメソッドを検証</a></li>
	</ul>
	
	<h2>11.4.4. RowBoundsを利用した範囲検索</h2>
	<ul>
		<li><a href="<c:url value="/room/find-all" />">findAllメソッドを検証</a></li>
	</ul>
	
	<h2>11.4.5. ResultHandlerによる検索結果の処理</h2>
	<ul>
		<li><a href="<c:url value="/room/collect-all" />">collectAllメソッドを検証</a></li>
	</ul>
</body>
</html>
