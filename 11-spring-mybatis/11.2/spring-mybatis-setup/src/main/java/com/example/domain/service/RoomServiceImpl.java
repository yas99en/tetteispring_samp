package com.example.domain.service;

import org.springframework.stereotype.Service;

import com.example.domain.mapper.MeetingRoomMapper;
import com.example.domain.model.Room;

@Service
public class RoomServiceImpl implements RoomService {

	private final MeetingRoomMapper meetingRoomMapper;

	public RoomServiceImpl(MeetingRoomMapper meetingRoomMapper) {
		this.meetingRoomMapper = meetingRoomMapper;
	}
	
	@Override
	public Room findOne(Integer id) {
		return meetingRoomMapper.findOne(id);
	}
}
