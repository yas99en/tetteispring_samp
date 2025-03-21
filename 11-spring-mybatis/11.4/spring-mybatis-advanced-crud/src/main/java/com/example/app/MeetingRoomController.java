package com.example.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.model.MeetingRoom;
import com.example.domain.model.ReservableRoom;
import com.example.domain.service.MeetingRoomService;

@Controller
@RequestMapping("room")
public class MeetingRoomController {

	private MeetingRoomService meetingRoomService;
	
	private static final String ROOM_JSP = "room";
	
	public MeetingRoomController(MeetingRoomService meetingRoomService) {
		this.meetingRoomService = meetingRoomService;
	}
	
	// 11.4.1.1.　<where>、<if>の実装例 を検証
	@GetMapping("find-by-criteria")
	public String findByCriteria(Model model) {
		System.out.println("11.4.1.1. <where>、<if>の実装例 を検証");
		
		System.out.println("すべて指定なし(null)");
		List<MeetingRoom> roomListByNoConditions = meetingRoomService.findByCriteria(null, null, null);
		System.out.println("↑<where>内の<if>がすべてfalseとなるため、WHERE句自体発行されない");
		roomListByNoConditions.forEach(System.out::println);
		
		System.out.println("roomIdのみ指定");
		List<MeetingRoom> roomListByRoomId = meetingRoomService.findByCriteria("1", null, null);
		roomListByRoomId.forEach(System.out::println);
		
		System.out.println("roomNameのみ指定");
		List<MeetingRoom> roomListByRoomName = meetingRoomService.findByCriteria(null, "RoomB", null);
		roomListByRoomName.forEach(System.out::println);
		
		System.out.println("capacityのみ指定");
		List<MeetingRoom> roomListByCapacity = meetingRoomService.findByCriteria(null, null, 60);
		roomListByCapacity.forEach(System.out::println);
		
		return ROOM_JSP;
	}
	
	// 11.4.1.2. <choose>の実装例 を検証
	@GetMapping("find-by-capacity-class")
	public String findByCapacityClass(Model model) {
		System.out.println("11.4.1.2. <choose>の実装例 を検証");
		
		System.out.println("引数にsmallを指定");
		List<MeetingRoom> roomListBySmallCapacity = meetingRoomService.findByCapacityClass("small");
		roomListBySmallCapacity.forEach(System.out::println);
		
		System.out.println("引数にmiddleを指定");
		List<MeetingRoom> roomListByMiddleCapacity = meetingRoomService.findByCapacityClass("middle");
		roomListByMiddleCapacity.forEach(System.out::println);
		
		System.out.println("引数にlargeを指定(small, middle以外)");
		List<MeetingRoom> roomListByLargeCapacity = meetingRoomService.findByCapacityClass("large");
		roomListByLargeCapacity.forEach(System.out::println);
		
		return ROOM_JSP;
	}
	
	// 11.4.1.3. <foreach>の実装例 を検証
	@GetMapping("find-by-room-ids")
	public String findByRoomIds(Model model) {
		System.out.println("11.4.1.3. <foreach>の実装例 を検証");
		
		System.out.println("roomIdのリストを1,4,11で指定");
		List<MeetingRoom> roomListByRoomIds = meetingRoomService.findByRoomIds(Arrays.asList("1", "4", "11"));
		roomListByRoomIds.forEach(System.out::println);
		
		return ROOM_JSP;
	}
	
	// 11.4.1.4. <set>の実装例 を検証
	@GetMapping("update")
	public String update(Model model) {
		System.out.println("11.4.1.4. <set>の実装例 を検証");
		
		System.out.println("roomNameとcapacityを更新");
		boolean result = meetingRoomService.update("1", "RoomAA", 50);
		System.out.println("更新結果: " + result);	
		
		return ROOM_JSP;
	}
	
	// 11.4.3.1. 主テーブルと関連テーブルのレコードを別々に取得してマッピングする方法 を検証
	@GetMapping("find-one")
	public String findOne(Model model) {
		System.out.println("11.4.3.1. 主テーブルと関連テーブルのレコードを別々に取得してマッピングする方法 を検証");

		MeetingRoom room = meetingRoomService.findOne("2");
		System.out.println(room);
		List<ReservableRoom> reservableRooms = room.getReservableRooms();
		
		// 3秒スリープ
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		reservableRooms.forEach(rRoom -> {
			System.out.println(rRoom);
			rRoom.getReservations().forEach(System.out::println);
			System.out.println("↑遅延フェッチを設定している場合、ここでreservation取得のSELECT文が実行される");
		});
		
		return ROOM_JSP;
	}
	
	// 11.4.3.2. テーブル結合を利用して関連オブジェクトをマッピングする方法 を検証
	@GetMapping("select-join-meeting-room")
	public String selectJoinMeetingRoom(Model model) {
		System.out.println("11.4.3.2. テーブル結合を利用して関連オブジェクトをマッピングする方法 を検証");
		
		MeetingRoom room = meetingRoomService.selectJoinMeetingRoom("2");
		System.out.println(room);
		List<ReservableRoom> reservableRooms = room.getReservableRooms();
		reservableRooms.forEach(System.out::println);
		return ROOM_JSP;
	}
	
	// 11.4.4. RowBoundsを利用した範囲検索 を検証
	@GetMapping("find-all")
	public String findAll(Model model) {
		System.out.println("11.4.3.2. テーブル結合を利用して関連オブジェクトをマッピングする方法 を検証");
		
		// メソッド名はfindAllとしていますが、実処理はmeeting_roomテーブルの6番目から最大で5つの要素(6～10件目)を格納したListを取得しています。
		List<MeetingRoom> rooms = meetingRoomService.findAll();
		rooms.forEach(System.out::println);
		return ROOM_JSP;
	}
	
	// 11.4.5. ResultHandlerによる検索結果の処理 を検証
	@GetMapping("collect-all")
	public String collectAll(Model model) {
		System.out.println("11.4.3.2. テーブル結合を利用して関連オブジェクトをマッピングする方法 を検証");
		
		// コンソール出力処理はサービスクラスで実装
		meetingRoomService.collectAll();
		return ROOM_JSP;
	}
}
