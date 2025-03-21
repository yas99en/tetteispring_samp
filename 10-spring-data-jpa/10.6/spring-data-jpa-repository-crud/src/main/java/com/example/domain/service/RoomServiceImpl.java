package com.example.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;
import com.example.domain.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;

	// 10.6.1. Spring Data JPA標準のCRUD操作 CRUD操作の実装例
	@Override
	@Transactional(readOnly = true)
	public Room getRoom(Integer id) {
		Room room = roomRepository.findById(id).orElse(null);
		if (room == null) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		return room;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getRoomsAll() {
		return roomRepository.findAll(Sort.by("roomId").ascending());
	}

	@Override
	@Transactional
	public Room createRoom(String roomName, Integer capacity) {
		Room room = new Room();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		return roomRepository.save(room);
	}

	@Override
	@Transactional
	public Room updateRoomName(Integer id, String roomName) {
		Room room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

	@Override
	@Transactional
	public void deleteRoom(Integer id) {
		roomRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> findByRangeWithCapacity(Integer minCapacity, Integer maxCapacity) {
		List<Room> rooms = roomRepository.findByRangeWithCapacity(minCapacity, maxCapacity);
		return rooms;
	}

	// 10.6.2.1. @Queryを使用する方法
	@Override
	@Transactional(readOnly = true)
	public List<Room> findByRoomName(String roomName) {
		List<Room> rooms = roomRepository.findByRoomName(roomName);
		if (rooms.isEmpty()) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		return rooms;
	}

	@Override
	@Transactional
	public Integer updateCapacityAll(Integer capacity) {
		Integer cnt = roomRepository.updateCapacityAll(capacity);
		if (cnt == 0) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		return cnt;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> findByRoomNameLike(String roomName) {
		List<Room> rooms = roomRepository.findByRoomNameLike(roomName);
		if (rooms.isEmpty()) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		return rooms;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> findByCreatedDate(LocalDateTime createdDate) {
		List<Room> rooms = roomRepository.findByCreatedDate(createdDate);
		if (rooms.isEmpty()) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
			System.out.println("=== room not found ===");
		}
		return rooms;
	}

	// 10.6.2.2. メソッド名からクエリを生成する方法
	@Override
	@Transactional(readOnly = true)
	public List<Room> findByRoomNameAndCapacity(String roomName, Integer capacity) {
		List<Room> rooms = roomRepository.findByRoomNameAndCapacity(roomName, capacity);
		return rooms;
	}

	// 10.6.3. 排他制御 悲観ロックの使用例
	@Override
	@Transactional
	public List<Room> updateRoomWithPessimisticLock(Integer capacity) {
		List<Room> rooms = roomRepository.findAll();

		try {
			// 10秒待機
			Thread.sleep(10000);
			// 更新処理
			rooms.forEach(room -> room.setCapacity(room.getCapacity() + capacity));
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return rooms;
	}

	// 10.6.3. 排他制御 悲観ロックの使用例の動作確認用メソッド
	@Override
	@Transactional
	public List<Room> checkupdateRoomWithPessimisticLock(Integer capacity) {
		List<Room> rooms = roomRepository.findAll();
		rooms.forEach(room -> room.setCapacity(room.getCapacity() + capacity));
		return rooms;
	}

	// 10.6.4. ページネーションの使用例
	@Override
	@Transactional
	public List<Room> searchRoomByRoomIdAsc(int min, int max, int page, int size) {
		Sort sort = Sort.by("roomName").ascending();
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Room> rooms = roomRepository.findByIdBetween(min, max, pageable);
		System.out.println("10.6.4. トータルページ数 : " + rooms.getTotalPages());
		return rooms.getContent();
	}

}
