package com.example.app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;
import com.example.domain.service.RoomServiceImpl;

@Controller
public class RoomController {

	private RoomServiceImpl roomService;

	public RoomController(RoomServiceImpl roomService) {
		this.roomService = roomService;
	}

	@GetMapping("room1")
	public String room1(Model model) {

		// 10.5.3. 10.5.5. SELECT文(findById)が実行され、部屋情報が取得できること
		System.out.println("10.5.3. 10.5.5.:" + roomService.getRoom(1).getRoomName());

		return "room";
	}

	@GetMapping("room2")
	public String room2(Model model) {

		// 10.5.4 トランザクション有効になっていることの確認
		// 正常系：コミット
		roomService.createRoom(4, "RoomD", 20);
		// 異常系：ロールバック
		try {
			roomService.createRoomWithRollback(5, "RoomE", 40);
		} catch (Exception e) {
			System.out.println("rollback");
		}
		// RoomDが登録されていて、RoomEが登録されていないこと
		List<Room> rooms = roomService.getRoomsAll();
		System.out.println("10.5.4.:");
		rooms.forEach(room -> System.out.println(room.getRoomName()));

		return "room";
	}

	@GetMapping("room3")
	public String room3(Model model) {

		// 10.5.6 トランザクション終了後にLAZYフェッチでデータが取得できることを確認
		Room roomEntity = roomService.getRoomEntity(1);
		List<Equipment> equipmentsEntity = roomEntity.getEquipments();
		System.out.println("10.5.6.: " + equipmentsEntity.size());

		return "room";
	}
}
