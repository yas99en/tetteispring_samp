package com.example.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;
import com.example.domain.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	private RoomRepository roomRepository;

	public RoomServiceImpl(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@Transactional(readOnly = true)
	public Room getRoom(Integer id) {
		Room room = new Room();
		Optional<Room> roomOpt = roomRepository.findById(id);
		// 対象のroomが取得できた場合のみ設定して返却する
		roomOpt.ifPresent(x -> {
			room.setRoomId(x.getRoomId());
			room.setRoomName(x.getRoomName());
			room.setCapacity(x.getCapacity());
		});
		if (!roomOpt.isPresent()) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		return room;
	}

	@Transactional(readOnly = true)
	public Room getRoomEntity(Integer id) {
		Optional<Room> roomOpt = roomRepository.findById(id);
		if (!roomOpt.isPresent()) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		// RoomEntityを返却する
		return roomOpt.orElse(new Room());
	}

	@Transactional(readOnly = true)
	public List<Room> getRoomsAll() {
		return roomRepository.findAll();
	}

	@Transactional
	public Room createRoom(Integer roomId, String roomName, Integer capacity) {
		Room room = new Room();
		room.setRoomId(roomId);
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		return roomRepository.save(room);
	}

	@Transactional
	public Room createRoomWithRollback(Integer roomId, String roomName, Integer capacity) {
		Room room = new Room();
		room.setRoomId(roomId);
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		roomRepository.save(room);
		throw new RuntimeException();
	}

	@Transactional
	public Room updateRoomName(Integer id, String roomName) {
		Room room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

	@Transactional
	public void deleteRoom(Integer id) {
		roomRepository.deleteById(id);
	}
}
