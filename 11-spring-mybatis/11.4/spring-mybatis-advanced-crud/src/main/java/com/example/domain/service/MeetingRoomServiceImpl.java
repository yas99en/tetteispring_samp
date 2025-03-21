package com.example.domain.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.example.domain.mapper.MeetingRoomMapper;
import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

	private final MeetingRoomMapper meetingRoomMapper;

	public MeetingRoomServiceImpl(MeetingRoomMapper meetingRoomMapper) {
		this.meetingRoomMapper = meetingRoomMapper;
	}
	
	@Override
	public List<MeetingRoom> findByCriteria(String roomId, String roomName, Integer capacity) {
		MeetingRoomCriteria criteria = new MeetingRoomCriteria();
		criteria.setRoomId(roomId);
		criteria.setRoomName(roomName);
		criteria.setCapacity(capacity);
		return meetingRoomMapper.findByCriteria(criteria);
	}
	
	@Override
	public List<MeetingRoom> findByCapacityClass(String capacityClass) {
		return meetingRoomMapper.findByCapacityClass(capacityClass);
	}
	
	@Override
	public List<MeetingRoom> findByRoomIds(List<String> roomIds) {
		return meetingRoomMapper.findByRoomIds(roomIds);
	}
	
	@Override
	public boolean update(String roomId, String roomName, Integer capacity) {
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setRoomId(roomId);
		meetingRoom.setRoomName(roomName);
		meetingRoom.setCapacity(capacity);
		return meetingRoomMapper.update(meetingRoom);
	}
	
	@Override
	public MeetingRoom findOne(String meetingRoomId) {
		// 11.4.3. 1対1と1対多のマッピング MyBatisの機能を利用する方法で実現する際の実装例
		MeetingRoom meetingRoom = meetingRoomMapper.findOne(meetingRoomId);
		return meetingRoom;
	}
	
	@Override
	public MeetingRoom selectJoinMeetingRoom(String meetingRoomId) {
		MeetingRoom meetingRoom = meetingRoomMapper.selectJoinMeetingRoom(meetingRoomId);
		return meetingRoom;
	}
	
	@Override
	public List<MeetingRoom> findAll() {
		// 11.4.4. RowBoundsを利用した範囲検索　Mapperメソッドの呼び出し例
		RowBounds rowBounds = new RowBounds(5, 5);
		List<MeetingRoom> meetingRooms = meetingRoomMapper.findAll(rowBounds);
		return meetingRooms;
	}
	
	@Override
	public void collectAll() {
		// 11.4.5. ResultHandlerによる検索結果の処理　Mapperメソッドの呼び出し例
		meetingRoomMapper.collectAll(context -> {
			Integer resultPositon = context.getResultCount();
			MeetingRoom meetingRoom = context.getResultObject();
			System.out.println(resultPositon + "件目");
			System.out.println(meetingRoom);
		});
	}
}
