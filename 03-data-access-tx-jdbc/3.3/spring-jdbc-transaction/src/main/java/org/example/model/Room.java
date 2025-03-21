package org.example.model;

import java.util.List;

public class Room {
	private String roomId;
	private String roomName;
	private int capacity;
	private List<Equipment> equipmentList;

	public Room() {
	}

	public Room(String roomId, String roomName, int capacity, List<Equipment> equipmentList) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.capacity = capacity;
		this.equipmentList = equipmentList;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}
}
