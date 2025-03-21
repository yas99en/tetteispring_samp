package com.example.domain.service;

import java.util.List;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.mapper.MeetingRoomMapper;
import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

// 11.3.9. Mapperオブジェクトの利用 Mapperインターフェイスの利用例
@Transactional
@Service
public class RoomService {

	@Autowired
	MeetingRoomMapper meetingRoomMapper;

	// 11.3.2. マッピングファイルの作成 
	public List<MeetingRoom> findRoomsWithCDATA() {
		return meetingRoomMapper.findRoomsWithCDATA();
	}

	// 11.3.3.1. バインド変数の利用
	public MeetingRoom findOne(String id) {
		return meetingRoomMapper.findOne(id);
	}

	// 11.3.3.2. 置換変数の利用
	public List<MeetingRoom> findAll(String column) {
		return meetingRoomMapper.findAll(column);
	}

	// 11.3.4.2. 引数が1つでJavaBeanの場合
	public void create(MeetingRoom room) {
		meetingRoomMapper.create(room);
	}

	// 11.3.4.3. 引数が2つ以上の場合
	public void createMoreArguments(String roomId, String roomName, Integer capacity) {
		meetingRoomMapper.createMoreArguments(roomId, roomName, capacity);
	}

	// 11.3.4.3. 引数が2つ以上の場合 JavaBean
	public List<MeetingRoom> findAllByCriteria(MeetingRoomCriteria criteria, String column) {
		return meetingRoomMapper.findAllByCriteria(criteria, column);
	}

	// 11.3.4.4. MyBatis提供の特殊クラスの扱い RowBounds
	public List<MeetingRoom> findRangeByCapacity(Integer capacity, RowBounds rowBounds) {
		return meetingRoomMapper.findRangeByCapacity(capacity, rowBounds);
	}

	// 11.3.4.4. MyBatis提供の特殊クラスの扱い ResultHandler
	public void collectByCapacity(Integer capacity, ResultHandler<MeetingRoom> resultHandler) {
		meetingRoomMapper.collectByCapacity(capacity, resultHandler);
	}

	// 11.3.5.2. ResultSetとJavaBeanの明示的なマッピング
	public MeetingRoom findOneWithResultMap(String id) {
		return meetingRoomMapper.findOneWithResultMap(id);
	}

	// 11.3.6.1. キー取得機能の利用
	public MeetingRoom createByXMLWithSelectKey(String roomName, Integer capacity) {
		MeetingRoom newRoom = new MeetingRoom();
		newRoom.setRoomName(roomName);
		newRoom.setCapacity(capacity);
		this.meetingRoomMapper.createByXMLWithSelectKey(newRoom);
		return newRoom;
	}

	// 11.3.6.2. ID列の利用
	public MeetingRoom createByXMLWithGeneratedKeys(String roomName, Integer capacity) {
		MeetingRoom newRoom = new MeetingRoom();
		newRoom.setRoomName(roomName);
		newRoom.setCapacity(capacity);
		this.meetingRoomMapper.createByXMLWithGeneratedKeys(newRoom);
		return newRoom;
	}

	// 11.3.7. UPDATE操作の実装
	public boolean update(MeetingRoom meetingRoom) {
		return meetingRoomMapper.update(meetingRoom);
	}

	// 11.3.8. DELETE操作の実装
	public boolean delete(String roomId) {
		return meetingRoomMapper.delete(roomId);
	}
	
}
