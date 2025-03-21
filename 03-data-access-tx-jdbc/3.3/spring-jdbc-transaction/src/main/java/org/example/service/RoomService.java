package org.example.service;

import org.example.model.Room;

public interface RoomService {
	Room getRoom(String roomId);

	void insertRoom(Room room);
}
