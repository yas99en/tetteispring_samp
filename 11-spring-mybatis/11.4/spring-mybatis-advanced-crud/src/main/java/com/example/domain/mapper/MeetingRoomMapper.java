package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

public interface MeetingRoomMapper {
	
	// 11.4.1.1. <where>、<if>の実装例 Mapperメソッドの定義例
	List<MeetingRoom> findByCriteria(MeetingRoomCriteria criteria);
	
	// 11.4.1.2. <choose>の実装例 Mapperメソッドの定義例
	List<MeetingRoom> findByCapacityClass(@Param("capacityClass") String capacityClass);
	
	// 11.4.1.3. <foreach>の実装例 Mapperメソッドの定義例
	List<MeetingRoom> findByRoomIds(List<String> roomIds);
	
	// 11.4.1.4. <set>の実装例 Mapperメソッドの定義例
	boolean update(MeetingRoom meetingRoom);
	
	MeetingRoom findOne(String meetingRoomId);
	
	MeetingRoom selectJoinMeetingRoom(String roomId);
	
	// 11.4.4. RowBoundsを利用した範囲検索　Mapperインターフェイスの定義例
	List<MeetingRoom> findAll(RowBounds rowBounds);
	
	// 11.4.5. ResultHandlerによる検索結果の処理　Mapperインターフェイスの定義例
	void collectAll(ResultHandler<MeetingRoom> resultHandler);
}
