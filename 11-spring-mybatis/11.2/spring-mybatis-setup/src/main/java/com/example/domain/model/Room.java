package com.example.domain.model;

import java.io.Serializable;

public class Room implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private Integer roomId;
	
	private String roomName;
	
	private Integer capacity;
	
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
}
