package mrs.app.room;

import java.time.LocalDate;
import java.util.List;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 14.2.6.3. コントローラクラスおよびHTMLの作成 RoomsController.java
@Controller
@RequestMapping("rooms")
public class RoomsController {
	
	@Autowired
	RoomService roomService;
	
	// 14.2.6.3. コントローラクラスおよびHTMLの作成 listRoomsメソッドの共通化
	@RequestMapping(value = "{date}", method = RequestMethod.GET)
	String listRooms(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
		List<ReservableRoom> rooms = roomService.findReservableRooms(date);
		model.addAttribute("rooms", rooms);
		return "room/listRooms";
	}

	// 14.2.6.3. コントローラクラスおよびHTMLの作成 listRoomsメソッドの共通化
	@RequestMapping(method = RequestMethod.GET)
	String listRooms(Model model) {
		LocalDate today = LocalDate.now();
		model.addAttribute("date", today);
		return listRooms(today, model);
	}
	
}