<!DOCTYPE html>
<html lang="ja-JP">
<head>
<title>Spring Data JPA</title>
</head>
<body>
	<h2>Spring Data JPA</h2>
	<p>10.6.1. 動作確認</p>
	<ul>
		<li><a href="<c:url value="/getRoom" />">findById 検証</a></li>
		<li><a href="<c:url value="/getRoomFault" />">findById 検証（取得失敗）</a></li>
		<li><a href="<c:url value="/getRoomsAll" />">findAll 検証</a></li>
		<li><a href="<c:url value="/createRoom" />">save 検証</a></li>
		<li><a href="<c:url value="/updateRoomName" />">update 検証</a></li>
		<li><a href="<c:url value="/deleteRoom" />">deleteById 検証</a></li>
	</ul>
	<p>10.6.2.1. 動作確認</p>
	<ul>
		<li><a href="<c:url value="/findByRoomName" />">findByRoomName 検証</a></li>
		<li><a href="<c:url value="/updateCapacityAll" />">updateCapacityAll 検証</a></li>
		<li><a href="<c:url value="/findByRoomNameLike" />">findByRoomNameLike 検証</a></li>
		<li><a href="<c:url value="/findByCreatedDate" />">findByCreatedDate 検証</a></li>
	</ul>
	<p>10.6.2.2. 動作確認</p>
	<ul>
		<li><a href="<c:url value="/findByRoomNameAndCapacity" />">メソッド名からクエリを生成する例
				検証</a></li>
	</ul>
	<p>10.6.3. 動作確認<br>2つのタブを表示して、それぞれのリンクを押下してください。</p>
	<ul>
		<li><a href="<c:url value="/room" />">排他制御 検証(リンク1)</a></li>
		<li><a href="<c:url value="/exclusion" />">排他制御 検証(リンク2)</a></li>
	</ul>
	<p>10.6.4. 動作確認</p>
	<ul>
		<li><a href="<c:url value="/searchRoomByRoomIdAsc" />">ページネーション 検証</a></li>
	</ul>
	<p>10.6.5. 動作確認</p>
	<ul>
		<li><a href="<c:url value="/findRoomCustom" />">カスタムメソッド 検証</a></li>
	</ul>
	<p>10.6.6. 動作確認</p>
	<ul>
		<li><a href="<c:url value="/room1" />">監査情報の付与(作成) 検証</a></li>
		<li><a href="<c:url value="/room2" />">監査情報の付与(更新) 検証</a></li>
	</ul>
</body>
</html>
