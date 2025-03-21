package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		Room res = roomService.findOne(1);
		System.out.println("「room_id == 1」のものを抽出");
		System.out.printf("room_id:%s, room_name:%s, capacity:%d%n", res.getRoomId(), res.getRoomName(), res.getCapacity());

		return "room";
	}
}
