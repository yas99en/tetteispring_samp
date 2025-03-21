package com.example.domain.service;

import java.util.List;

import com.example.domain.model.Room;

public interface RoomService {
	public Room getRoom(Integer id);

	public Room createRoom(String roomName, Integer capacity);

	public Room updateRoomName(Integer id, String roomName);

	public void deleteRoom(Integer id);

	public List<Room> getRoomsByNameFetch(String roomName);

	public Integer updateCapacityAll(Integer capacity);

	public Room updateRoomWithOptimisticLock(Integer id, String roomName);

	public Room updateRoomWithPessimisticLock(Integer id, Integer capacity);

	public Room checkUpdateRoomOptimisticLock(Integer id, String roomName);
}
