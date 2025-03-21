package com.example.app;

import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;
import com.example.domain.service.RoomService;

@Controller
public class RoomController {

	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	// 11.3.2. マッピングファイルの作成
	@GetMapping("findRoomsWithCDATA")
	public String findRoomsWithCDATA(Model model) {
		List<MeetingRoom> res = roomService.findRoomsWithCDATA();
		System.out.println("11.3.2. マッピングファイルの作成");
		System.out.println("「capacity >= 30」のものを抽出");
		res.forEach(r -> System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", r.getRoomId(), r.getRoomName(), r.getCapacity()));
		return "room";
	}

	// 11.3.3.1. バインド変数の利用
	@GetMapping("findOne")
	public String findOne(Model model) {
		MeetingRoom res = roomService.findOne("1");
		System.out.println("11.3.3.1. バインド変数の利用");
		System.out.println("「room_id == 1」のものを抽出");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", res.getRoomId(), res.getRoomName(), res.getCapacity());
		return "room";
	}

	// 11.3.3.2. 置換変数の利用
	@GetMapping("findAll")
	public String findAll(Model model) {
		List<MeetingRoom> res = roomService.findAll("room_name");
		System.out.println("11.3.3.2. 置換変数の利用");
		System.out.println("「room_name」でソートして全件抽出");
		res.forEach(r -> System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", r.getRoomId(), r.getRoomName(), r.getCapacity()));
		return "room";
	}

	// 11.3.4.2. 引数が1つでJavaBeanの場合
	@GetMapping("create")
	public String create(Model model) {
		List<MeetingRoom> res = roomService.findAll("room_id");
		// idで昇順にソートする
		res.sort((room1, room2) -> Integer.parseInt(room1.getRoomId()) - Integer.parseInt(room2.getRoomId()));
		Integer roomId = Integer.parseInt(res.get(res.size() -1).getRoomId()) + 1;
		MeetingRoom insertRoom = new MeetingRoom();
		insertRoom.setRoomId(roomId.toString());
		insertRoom.setRoomName("Room" + roomId);
		insertRoom.setCapacity(100);
		roomService.create(insertRoom);
		MeetingRoom res2 = roomService.findOne(roomId.toString());
		System.out.println("11.3.4.2. 引数が1つでJavaBeanの場合");
		System.out.println("以下を追加");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", res2.getRoomId(), res2.getRoomName(), res2.getCapacity());
		return "room";
	}

	// 11.3.4.3. 引数が2つ以上の場合
	@GetMapping("createMoreArguments")
	public String createMoreArguments(Model model) {
		List<MeetingRoom> res = roomService.findAll("room_id");
		// idで昇順にソートする
		res.sort((room1, room2) -> Integer.parseInt(room1.getRoomId()) - Integer.parseInt(room2.getRoomId()));
		Integer roomId = Integer.parseInt(res.get(res.size() -1).getRoomId()) + 1;
		roomService.createMoreArguments(roomId.toString(), "Room" + roomId, 100);
		MeetingRoom res2 = roomService.findOne(roomId.toString());
		System.out.println("11.3.4.3. 引数が2つ以上の場合");
		System.out.println("以下を追加");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", res2.getRoomId(), res2.getRoomName(), res2.getCapacity());
		return "room";
	}

	// 11.3.4.3. 引数が2つ以上の場合 JavaBean
	@GetMapping("findAllByCriteria")
	public String findAllByCriteria(Model model) {
		MeetingRoomCriteria criteria = new MeetingRoomCriteria();
		criteria.setCapacity(50);
		List<MeetingRoom> res = roomService.findAllByCriteria(criteria, "capacity");
		System.out.println("11.3.4.3. 引数が2つ以上の場合 JavaBean");
		System.out.println("「capacity」でソートして「capacity >= 50」のものを抽出");
		res.forEach(r -> System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", r.getRoomId(), r.getRoomName(), r.getCapacity()));
		return "room";
	}

	// 11.3.4.4. MyBatis提供の特殊クラスの扱い RowBounds
	@GetMapping("findRangeByCapacity")
	public String findRangeByCapacity(Model model) {
		// 第一引数はスキップ件数、第二引数は最大取得件数を指定する
		RowBounds rowBounds = new RowBounds(0, 100);
		List<MeetingRoom> res = roomService.findRangeByCapacity(100, rowBounds);
		System.out.println("11.3.4.4. MyBatis提供の特殊クラスの扱い RowBounds");
		System.out.println("「スキップ件数0」かつ「最大取得件数100」として「capacity >= 100」のものを抽出");
		res.forEach(r -> System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", r.getRoomId(), r.getRoomName(), r.getCapacity()));
		return "room";
	}

	// 11.3.4.4. MyBatis提供の特殊クラスの扱い ResultHandler
	@GetMapping("collectByCapacity")
	public String collectByCapacity(Model model) {
		ResultHandler<MeetingRoom> resultHandler = new ResultHandler<MeetingRoom>() {
			@Override
			public void handleResult(ResultContext<? extends MeetingRoom> resultContext) {
				MeetingRoom meetingRoom = resultContext.getResultObject();
				StringBuilder sb = new StringBuilder();
				sb.append("room_id:" + meetingRoom.getRoomId());
				sb.append(", ");
				sb.append("room_name:" + meetingRoom.getRoomName());
				sb.append(", ");
				sb.append("capacity:" + meetingRoom.getCapacity());
				System.out.println(sb);
			}
		};
		System.out.println("11.3.4.4. MyBatis提供の特殊クラスの扱い ResultHandler");
		System.out.println("「capacity >= 100」のものを抽出");
		roomService.collectByCapacity(100, resultHandler);
		return "room";
	}

	// 11.3.5.2. ResultSetとJavaBeanの明示的なマッピング
	@GetMapping("findOneWithResultMap")
	public String findOneWithResultMap(Model model) {
		MeetingRoom res = roomService.findOneWithResultMap("3");
		System.out.println("11.3.5.2. ResultSetとJavaBeanの明示的なマッピング");
		System.out.println("「room_id == 3」のものを抽出");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", res.getRoomId(), res.getRoomName(), res.getCapacity());
		return "room";
	}

	// 11.3.6.1. キー取得機能の利用
	@GetMapping("createByXMLWithSelectKey")
	public String createByXMLWithSelectKey(Model model) {
		MeetingRoom room = roomService.createByXMLWithSelectKey("RoomF", 70);
		System.out.println("11.3.6.1. キー取得機能の利用");
		System.out.println("以下を追加（なお自動生成キーは他のRoomIdと形式が異なるため追加後に削除）");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", room.getRoomId(), room.getRoomName(), room.getCapacity());
		// 自動生成キーは他のRoomIdと形式が異なるため、削除
		roomService.delete(room.getRoomId());
		return "room";
	}

	// 11.3.6.2. ID列の利用
	@GetMapping("createByXMLWithGeneratedKeys")
	public String createByXMLWithGeneratedKeys(Model model) {
		MeetingRoom room = roomService.createByXMLWithGeneratedKeys("RoomH", 90);
		System.out.println("11.3.6.2. ID列の利用");
		System.out.println("以下を追加");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", room.getRoomId(), room.getRoomName(), room.getCapacity());
		return "room";
	}

	// 11.3.7. UPDATE操作の実装
	@GetMapping("update")
	public String update(Model model) {
		MeetingRoom mr = new MeetingRoom();
		mr.setRoomId("1");
		mr.setRoomName("upd test");
		mr.setCapacity(25);
		boolean updateRes = roomService.update(mr);
		System.out.println("11.3.7. UPDATE操作の実装");
		System.out.printf("更新対象: room_id:%s, room_name:%s, capacity:%d%n", mr.getRoomId(), mr.getRoomName(), mr.getCapacity());
		System.out.println("更新結果: " + updateRes);
		return "room";
	}

	// 11.3.8. DELETE操作の実装
	@GetMapping("delete")
	public String delete(Model model) {
		List<MeetingRoom> res = roomService.findAll("room_id");
		// idで昇順にソートする
		res.sort((room1, room2) -> Integer.parseInt(room1.getRoomId()) - Integer.parseInt(room2.getRoomId()));
		Integer roomId = Integer.parseInt(res.get(res.size() -1).getRoomId()) + 1;
		MeetingRoom insertRoom = new MeetingRoom();
		insertRoom.setRoomId(roomId.toString());
		insertRoom.setRoomName("Room" + roomId);
		insertRoom.setCapacity(100);
		// 削除対象を追加して用意する
		roomService.create(insertRoom);
		boolean deleteRes = roomService.delete(roomId.toString());
		System.out.println("11.3.8. DELETE操作の実装");
		System.out.printf("削除対象（削除用に用意）: room_id:%s, room_name:%s, capacity:%d%n", insertRoom.getRoomId(), insertRoom.getRoomName(), insertRoom.getCapacity());
		System.out.println("削除結果: " + deleteRes);
		return "room";
	}
	
}
