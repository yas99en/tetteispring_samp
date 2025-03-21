package com.example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;
import com.example.domain.service.RoomService;

@Controller
public class RoomController {
	
	private RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("room")
	public String room(Model model) {
		
		// ルームを1件取得する
		// 動作確認を行なう場合は、「新しいルームを作成する」、「ルーム名を更新する」、「ルームを削除する」の箇所をコメントアウトしてください。
		Room res = roomService.getRoom(1);
		model.addAttribute("ROOM", res.getRoomName());

		// 新しいルームを作成する
		// 動作確認を行なう場合は、「ルームを1件取得する」、「ルーム名を更新する」、「ルームを削除する」の箇所をコメントアウをしてください。
		Room res4 = roomService.createRoom("RoomZ", 40);
		model.addAttribute("NewRoomName", res4.getRoomName());
		model.addAttribute("NewRoomCapacity", res4.getCapacity());
		
		// ルーム名を更新する
		// 動作確認を行なう場合は、「ルームを1件取得する」、「新しいルームを作成する」、「ルームを削除する」の箇所をコメントアウトしてください。
		Room res5 = roomService.updateRoomName(3, "RoomRename");
		model.addAttribute("UpdateRoomName", res5.getRoomName());
		
		// ルームを削除する
		// 動作確認を行なう場合は、「ルームを1件取得する」、「新しいルームを作成する」、「ルーム名を更新する」の箇所をコメントアウトしてください。
		roomService.deleteRoom(3);

		return "room";
	}
	
	@GetMapping("room1")
	public String room1() {
		List<Room> res = roomService.getRoomsByNameFetch("RoomA");
		for(Equipment equipment : res.get(0).getEquipments())
		{
			System.out.println("10.2.2 JOIN FETCH ルームに紐づく備品を表示 ： " + equipment.getEquipmentName());
		}

		Integer updateRes = roomService.updateCapacityAll(100);
		System.out.println("10.2.2 更新JPQL 更新件数 ： " + updateRes);
		return "room";
	}
	
	@GetMapping("room2")
	public String room2(Model model) {
		// 楽観ロック
		// 動作確認を行なう場合は、「悲観ロック」の箇所をコメントアウトしてください。
		Room res = roomService.updateRoomWithOptimisticLock(2, "RoomD");
		model.addAttribute("UpdateRoomName", res.getRoomName());
		// 悲観ロック
		// 動作確認を行なう場合は、「楽観ロック」、Room.javaの「10.2.3.1. 楽観ロック 楽観ロックの使用例」の箇所をコメントアウトしてください。
//		Room res = roomService.updateRoomWithPessimisticLock(1, 10);
//		model.addAttribute("UpdateCapacity", res.getCapacity().toString());
		return "room";
	}

	@GetMapping("exclusion")
	public String exclusion(Model model) {
		// 楽観ロック
		// 動作確認を行なう場合は、「悲観ロック」の箇所をコメントアウトしてください。
		Room res2 = roomService.checkUpdateRoomOptimisticLock(2, "RoomD_e");
		model.addAttribute("UpdateRoomName", res2.getRoomName());
		// 悲観ロック
		// 動作確認を行なう場合は、「楽観ロック」の箇所をコメントアウトしてください。
//		Room res2 = roomService.updateRoomWithPessimisticLock(1, 20);
//		model.addAttribute("UpdateCapacity", res2.getCapacity().toString());
		return "room";
	}
}
