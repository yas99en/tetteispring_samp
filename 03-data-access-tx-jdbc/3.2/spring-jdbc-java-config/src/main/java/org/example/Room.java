package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Room {
    private  String roomId;
    private  String roomName;
    private  int capacity;
    private List<Equipment> equipmentList;

    public Room(String roomId, String roomName, int capacity) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.equipmentList = new ArrayList<>();
    }

    public List<Equipment> getEquipmentList() {
        return this.equipmentList;
    }

    Room() {
        this.roomId = "";
        this.roomName = "";
        this.capacity = 0;
        this.equipmentList = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }
    public String getRoomName() {
        return roomName;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
