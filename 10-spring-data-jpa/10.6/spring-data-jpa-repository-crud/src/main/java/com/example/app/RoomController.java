package com.example.app;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.Room;
import com.example.domain.service.RoomService;

@Controller
public class RoomController {

	private RoomService roomService;

	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	// 10.6.1. findById 検証
	@GetMapping("getRoom")
	public String getRoom(Model model) {

		Room room = roomService.getRoom(2);
		System.out.println("10.6.1:findById 検証");
		System.out.printf("room_id:%d room_name:%s capacity:%d\n", room.getRoomId(), room.getRoomName(),
				room.getCapacity());
		return "room";
	}

	// 10.6.1. findById 検証（取得失敗）
	@GetMapping("getRoomFault")
	public String getRoomFault(Model model) {

		Room room = roomService.getRoom(100);
		System.out.println("10.6.1:findById null 検証");
		System.out.println("10.6.1:room:" + room);
		return "room";
	}

	// 10.6.1. findAll 検証
	@GetMapping("getRoomsAll")
	public String getRoomsAll(Model model) {

		List<Room> rooms = roomService.getRoomsAll();
		System.out.println("10.6.1 findAll 検証");
		System.out.println("10.6.1:count:" + rooms.size());
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s\n", r.getRoomId(), r.getRoomName()));
		return "room";
	}

	// 10.6.1. save 検証
	@GetMapping("createRoom")
	public String createRoom(Model model) {
		Room room = roomService.createRoom("RoomE", 150);
		System.out.println("10.6.1:create 検証");
		System.out.printf("room_id:%d room_name:%s capacity:%d\n", room.getRoomId(), room.getRoomName(),
				room.getCapacity());
		return "room";
	}

	// 10.6.1. update 検証
	@GetMapping("updateRoomName")
	public String updateRoomName(Model model) {
		roomService.updateRoomName(2, "RoomB_Mod@");
		Room room = roomService.getRoom(2);
		System.out.println("10.6.1:update 検証");
		System.out.printf("room_id:%d room_name:%s capacity:%d\n", room.getRoomId(), room.getRoomName(),
				room.getCapacity());
		return "room";
	}

	// 10.6.1. deleteById 検証
	@GetMapping("deleteRoom")
	public String deleteRoom(Model model) {
		int delId = 10;
		roomService.deleteRoom(delId);
		Room room = roomService.getRoom(delId);
		System.out.println("10.6.1:delete 検証");
		System.out.println("10.6.1:room:" + room);
		List<Room> rooms = roomService.getRoomsAll();
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s\n", r.getRoomId(), r.getRoomName()));
		return "room";
	}

	// 10.6.2.1. findByRoomName 検証
	@GetMapping("findByRoomName")
	public String findByRoomName(Model model) {
		List<Room> rooms = roomService.findByRoomName("RoomC");
		System.out.println("10.6.2:findByRoomName 検証");
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s\n", r.getRoomId(), r.getRoomName()));
		return "room";
	}

	// 10.6.2.1. updateCapacityAll 検証
	@GetMapping("updateCapacityAll")
	public String updateCapacityAll(Model model) {
		Integer cnt = roomService.updateCapacityAll(40);
		System.out.println("10.6.2:updateCapacityAll 検証");
		System.out.println(cnt);
		return "room";
	}

	// 10.6.2.1. @Queryで許容されているJPQLの例 検証
	@GetMapping("findByRoomNameLike")
	public String findByRoomNameLike(Model model) {
		List<Room> rooms = roomService.findByRoomNameLike("D");
		System.out.println("10.6.2:findByRoomNameLike 検証");
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s\n", r.getRoomId(), r.getRoomName()));
		return "room";
	}

	// 10.6.2.1. SpELを埋め込んだJPQLの例
	@GetMapping("findByCreatedDate")
	public String findByCreatedDate(Model model) {
		String strTime = "2024-08-09T13:23:57.118898";
		List<Room> rooms = roomService.findByCreatedDate(LocalDateTime.parse(strTime));
		System.out.println("10.6.2:findByCreatedDate 検証");
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s\n", r.getRoomId(), r.getRoomName()));
		return "room";
	}

	// 10.6.2.2 メソッド名からクエリを生成する例
	@GetMapping("findByRoomNameAndCapacity")
	public String findByRoomNameAndCapacity(Model model) {
		List<Room> rooms = roomService.findByRoomNameAndCapacity("RoomD", 40);
		System.out.println("10.6.2.2:メソッド名からクエリを生成する例 検証");
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s\n", r.getRoomId(), r.getRoomName()));
		return "room";
	}

	// 10.6.3. 排他制御
	@GetMapping("room")
	public String room(Model model) {
		// 10.6.3. 悲観ロックの使用例 capacity更新
		List<Room> rooms = roomService.updateRoomWithPessimisticLock(10);
		System.out.println("10.6.3:排他制御 検証");
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s capacity:%d\n", r.getRoomId(), r.getRoomName(),
				r.getCapacity()));
		return "room";
	}

	@GetMapping("exclusion")
	public String exclusion(Model model) {
		// 10.6.3. 悲観ロックの確認用 capacity更新
		List<Room> rooms = roomService.checkupdateRoomWithPessimisticLock(20);
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s capacity:%d\n", r.getRoomId(), r.getRoomName(),
				r.getCapacity()));
		return "room";
	}

	// 10.6.4. ページネーションの使用例
	@GetMapping("searchRoomByRoomIdAsc")
	public String searchRoomByRoomIdAsc(Model model) {
		// 引数は 検索条件1、検索条件2、取得したいデータのページ番号、1ページあたりの件数 を指定する。
		List<Room> rooms = roomService.searchRoomByRoomIdAsc(1, 5, 0, 3);
		System.out.println("10.6.4:ページネーション 検証  1ページあたりの件数として指定した分だけRoomを表示");
		rooms.forEach(
				r -> System.out.printf("room_id:%d room_name:%s capacity:%d\n", r.getRoomId(), r.getRoomName(),
						r.getCapacity()));
		return "room";
	}

	// 10.6.5. Repositoryへのカスタムメソッドの追加
	@GetMapping("findRoomCustom")
	public String findRoomCustom(Model model) {
		List<Room> rooms = roomService.findByRangeWithCapacity(100, 500);
		System.out.println("10.6.5:カスタムメソッド 検証");
		rooms.forEach(r -> System.out.printf("room_id:%d room_name:%s capacity:%d\n", r.getRoomId(), r.getRoomName(),
				r.getCapacity()));
		return "room";
	}
	
	// 10.6.6. 監査情報の付与
	// VM引数に"user.name"を指定して実行してください(例：-Duser.name="test_user")
	@GetMapping("room1")
	public String room1(Model model) {
		// データ登録時にcreated_by, created_date2, last_modified_by, last_modified_dateが登録されることを確認する。
		roomService.createRoom("RoomX", 40);
		List<Room> rooms = roomService.findByRoomName("RoomX");
		System.out.println("10.6.6:createRoom 検証");
		rooms.forEach(r -> System.out.printf(
				"room_id:%d room_name:%s created_by:%s created_date2:%s last_modified_by:%s last_modified_date:%s\n",
				r.getRoomId(), r.getRoomName(), r.getCreatedBy(), r.getCreatedDate2(), r.getLastModifiedBy(),
				r.getLastModifiedDate()));
		return "room";
	}
	
	@GetMapping("room2")
	public String room2(Model model) {
		// データ更新時にlast_modified_by, last_modified_dateが更新されることを確認する。
		roomService.updateRoomName(4, "RoomD_2");
		List<Room> rooms = roomService.findByRoomName("RoomD_2");
		System.out.println("10.6.6:updateRoomName 検証");
		rooms.forEach(r -> System.out.printf(
				"room_id:%d room_name:%s created_by:%s created_date2:%s last_modified_by:%s last_modified_date:%s\n",
				r.getRoomId(), r.getRoomName(), r.getCreatedBy(), r.getCreatedDate2(), r.getLastModifiedBy(),
				r.getLastModifiedDate()));
		return "room";
	}
}
