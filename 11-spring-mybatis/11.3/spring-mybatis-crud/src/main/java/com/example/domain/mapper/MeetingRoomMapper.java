package com.example.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.example.domain.model.MeetingRoom;
import com.example.domain.model.MeetingRoomCriteria;

// 11.3.1. Mapperインターフェイスの作成 Mapperインターフェイスの作成例
public interface MeetingRoomMapper {

	// 11.3.2. マッピングファイルの作成 
	List<MeetingRoom> findRoomsWithCDATA();

	// 11.3.3.1. バインド変数の利用
	MeetingRoom findOne(String roomId);

	// 11.3.3.2. 置換変数の利用
	List<MeetingRoom> findAll(String column);

	// 11.3.4.2. 引数が1つでJavaBeanの場合 Mapperメソッドの定義例
	void create(MeetingRoom room);

	// 11.3.4.3. 引数が2つ以上の場合 Mapperメソッドの定義例
	void createMoreArguments(
		@Param("roomId") String roomId,
		@Param("roomName") String roomName,
		@Param("capacity") int capacity);

	// 11.3.4.3. 引数が2つ以上の場合 Mapperメソッドの定義例 JavaBean
	List<MeetingRoom> findAllByCriteria(
		@Param("criteria") MeetingRoomCriteria criteria,
		@Param("orderByColumn") String column);

	// 11.3.4.4. MyBatis提供の特殊クラスの扱い Mapperメソッドの定義例 RowBounds
	List<MeetingRoom> findRangeByCapacity(int capacity, RowBounds rowBounds);

	// 11.3.4.4. MyBatis提供の特殊クラスの扱い Mapperメソッドの定義例 ResultHandler
	void collectByCapacity(int capacity, ResultHandler<MeetingRoom> resultHandler);

	// 11.3.5.2. ResultSetとJavaBeanの明示的なマッピング
	MeetingRoom findOneWithResultMap(String roomId);

	// 11.3.6.1. キー取得機能の利用
	void createByXMLWithSelectKey(MeetingRoom meetingRoom);

	// 11.3.6.2. ID列の利用
	void createByXMLWithGeneratedKeys(MeetingRoom meetingRoom);

	// 11.3.7. UPDATE操作の実装
	boolean update(MeetingRoom meetingRoom);

	// 11.3.8. DELETE操作の実装
	boolean delete(String roomId);
}
