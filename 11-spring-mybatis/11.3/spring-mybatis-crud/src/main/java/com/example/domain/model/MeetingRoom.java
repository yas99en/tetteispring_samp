package com.example.domain.model;

import java.io.Serializable;

// 11.3.4.2. 引数が1つでJavaBeanの場合 JavaBeanの定義例
public class MeetingRoom implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	private String roomId;

	private String roomName;

	private Integer capacity;

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
	
}
