package com.example.app;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;
import com.example.domain.service.RoomService;

@Controller
public class RoomController {
	
	private RoomService roomService;
	
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("room")
	public String room(Model model) {
		Room res1 = roomService.getRoomById(1);
		model.addAttribute("RoomById", res1.getRoomName()); // ルーム名

		List<Equipment> res2 = roomService.getEquipmentsInRoom(2);
		model.addAttribute("EquipmentsInRoom", res2.size()); // Equipmentの数
		
		Room res3 = roomService.getRoomOfEquipment(3);
		model.addAttribute("RoomOfEquipment", res3.getRoomName()); // Equipmentに関連するルーム名
		
		List<Room> res4 = roomService.getRoomsByName("RoomA"); // ルーム名での検索結果
		for (Room room: res4) {
			System.out.println("ルーム名での検索結果を表示: " + room.getRoomName());
		}
		
		return "room";
	}
	
}
