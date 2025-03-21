package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.MeetingRoomRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	@Autowired
	MeetingRoomRepository meetingRoomRepository;

	// 14.2.6.2. サービスクラスの作成 RoomService.java
	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_ReservedDateOrderByReservableRoomId_RoomIdAsc(date);
	}

	// 14.2.7.2. サービスクラスの作成 RoomService.java
	public MeetingRoom findMeetingRoom(Integer roomId) {
		MeetingRoom meetingRoom = meetingRoomRepository.findById(roomId).orElse(null);
		if (meetingRoom == null) {
			// 対象のmeeting roomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== meeting room not found ===");
		}
		return meetingRoom;
	}
	
}