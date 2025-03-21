package com.example.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.domain.model.Room;

public interface RoomService {

	public Room getRoom(Integer id);

	public List<Room> getRoomsAll();

	public Room createRoom(String roomName, Integer capacity);

	public Room updateRoomName(Integer id, String roomName);

	public void deleteRoom(Integer id);

	public List<Room> findByRangeWithCapacity(Integer minCapacity, Integer maxCapacity);

	public List<Room> findByRoomName(String roomName);

	public Integer updateCapacityAll(Integer capacity);

	public List<Room> findByRoomNameLike(String roomName);

	public List<Room> findByCreatedDate(LocalDateTime createdDate);

	public List<Room> findByRoomNameAndCapacity(String roomName, Integer capacity);

	public List<Room> updateRoomWithPessimisticLock(Integer capacity);

	public List<Room> checkupdateRoomWithPessimisticLock(Integer capacity);

	public List<Room> searchRoomByRoomIdAsc(int min, int max, int page, int size);

}
