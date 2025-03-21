package com.example.domain.mapper;

import com.example.domain.model.Room;

public interface MeetingRoomMapper {
	Room findOne(Integer roomId);
}
