package org.example.service;

import org.example.model.Room;

public interface RoomService {
    Room getRoomForUpdate(String roomId);
    void insertRoom(Room room);
}
