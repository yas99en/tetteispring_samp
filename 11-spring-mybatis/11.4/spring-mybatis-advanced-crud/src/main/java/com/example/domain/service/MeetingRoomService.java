package com.example.domain.service;

import java.util.List;

import com.example.domain.model.MeetingRoom;

public interface MeetingRoomService {
	
	public List<MeetingRoom> findByCriteria(String roomId, String roomName, Integer capacity);
	
	public List<MeetingRoom> findByCapacityClass(String capacityClass);
	
	public List<MeetingRoom> findByRoomIds(List<String> roomIds);
	
	public boolean update(String roomId, String roomName, Integer capacity);
	
	public MeetingRoom findOne(String meetingRoomId);
	
	public MeetingRoom selectJoinMeetingRoom(String meetingRoomId);
	
	public List<MeetingRoom> findAll();
	
	public void collectAll();
}
