package com.example.domain.model;

import java.io.Serializable;
import java.util.List;

public class MeetingRoom implements Serializable {
	private static final long serialVersionUID = 1L; 

	private String roomId;
	private String roomName;
	private Integer capacity;
	private List<ReservableRoom> reservableRooms;
	
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	public List<ReservableRoom> getReservableRooms() {
		return reservableRooms;
	}
	public void setReservableRooms(List<ReservableRoom> reservableRooms) {
		this.reservableRooms = reservableRooms;
	}
	
	
	private static final String FORMAT = "[MEETING_ROOM] roomId:%-3s | roomName:%-8s | capacity:%3d";
	@Override
	public String toString() {
		return String.format(FORMAT, roomId, roomName, capacity);
	}
}
