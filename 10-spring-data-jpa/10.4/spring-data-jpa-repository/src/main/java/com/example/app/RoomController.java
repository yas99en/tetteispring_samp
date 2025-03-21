package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.model.Room;
import com.example.domain.service.RoomServiceImpl;

@Controller
public class RoomController {

	private RoomServiceImpl roomService;
	
	@Autowired
	public RoomController(RoomServiceImpl roomService) {
		this.roomService = roomService;
	}

	@GetMapping("room")
	public String room(Model model) {
		Room res = roomService.updateRoomWithOptimisticLock(1, "RoomD");
		model.addAttribute("Room", res.getRoomName());
		return "room";
	}

	@GetMapping("exclusion")
	public String exclusion(Model model) {
		Room res2 = roomService.checkUpdateRoomOptimisticLock(1, "RoomD_e");
		model.addAttribute("Room", res2.getRoomName());
		return "room";
	}
}
