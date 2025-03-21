package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JdbcRoomDao {
	// (1)
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 一部メソッド名が書籍と異なります 書籍内で同一のメソッド名(引数も同じ)で内部処理を変えて説明する方式をとっており、
	 * sampleコードとしては同一メソッド名定義できないため '元のメソッド名UseXXXXX'というメソッド名に変えています
	 * XXXXXはメソッド内で利用しているものや書籍の見出しになっているキーワード
	 */

	// 3.2.2.3. Java標準データ型による1項目の取得
	public int findMaxCapacity() {
		String sql = "SELECT MAX(capacity) FROM room";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	// 3.2.2.4. バインド変数を利用したSQL
	public String findRoomNameById(String roomId) {
		// (1)
		String sql = "SELECT room_name FROM room WHERE room_id = ?";
		// (2)
		return jdbcTemplate.queryForObject(sql, String.class, roomId);
	}

	// 3.2.2.6. 1行の検索結果を取得
	// (1)
	public Room getRoomById(String roomId) {
		// (2)
		String sql = "SELECT room_id, room_name, capacity FROM room WHERE room_id = ?";
		// (3)
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, roomId);
		Room room = new Room();
		// (4)
		room.setRoomId((String) result.get("room_id"));
		room.setRoomName((String) result.get("room_name"));
		room.setCapacity((Integer) result.get("capacity"));
		return room;
	}

	// 3.2.2.7. 複数行の検索結果を取得
	// (1)
	public List<Room> getAllRoom() {
		// (2)
		String sql = "SELECT room_id, room_name, capacity FROM room";
		// (3)
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Room> roomList = new ArrayList<>();
		for (Map<String, Object> result : resultList) {
			Room room = new Room();
			// (4)
			room.setRoomId((String) result.get("room_id"));
			room.setRoomName((String) result.get("room_name"));
			room.setCapacity((Integer) result.get("capacity"));
			roomList.add(room);
		}
		return roomList;
	}

	// 3.2.2.8. 検索結果が0件の場合
	// パターン1. queryForListで検索結果が0件の場合は空のリストが返される
	public List<Room> cannotGetRooms() {
		String sql = "SELECT room_id, room_name, capacity FROM room WHERE capacity > 100000";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Room> roomList = new ArrayList<>();
		for (Map<String, Object> result : resultList) {
			Room room = new Room();
			room.setRoomId((String) result.get("room_id"));
			room.setRoomName((String) result.get("room_name"));
			room.setCapacity((Integer) result.get("capacity"));
			roomList.add(room);
		}
		return roomList;
	}

	// パターン2, queryForList以外では例外エラーが発生する
	public String exceptionShouldOccurred() {
		String sql = "SELECT room_id, room_name, capacity FROM room WHERE room_id = ?";
		try {
			Map<String, Object> result = jdbcTemplate.queryForMap(sql, "NOT_EXISTS");
			Room room = new Room();
			room.setRoomId((String) result.get("room_id"));
			room.setRoomName((String) result.get("room_name"));
			room.setCapacity((Integer) result.get("capacity"));
			return "No Exception";
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
			return e.getClass().getName();
		}
	}

	// 3.2.2.9. テーブルを更新する処理(Insert、Update、Delete)
	// (2)
	@Transactional
	// (3)
	public int insertRoom(Room room) {
		// (4)
		String sql = "INSERT INTO room(room_id, room_name, capacity)" + " VALUES(?, ?, ?)";
		// (5)
		return jdbcTemplate.update(sql, room.getRoomId(), room.getRoomName(), room.getCapacity());
	}

	// (2)
	@Transactional
	public int updateRoomById(Room room) {
		String sql = "UPDATE room SET room_name=?, capacity=?" + " WHERE room_id=?";
		// (6)
		return jdbcTemplate.update(sql, room.getRoomName(), room.getCapacity(), room.getRoomId());
	}

	// (2)
	@Transactional
	public int deleteRoomById(String roomId) {
		String sql = "DELETE FROM room WHERE room_id=?";
		// (6)
		return jdbcTemplate.update(sql, roomId);
	}

	// 3.2.3.1. RowMapperの実装
	// (注)書籍ではgetRoomByIdです
	// (1)
	public Room getRoomByIdUseRowMapper(String roomId) {
		// (2)
		String sql = "SELECT room_id, room_name, capacity" + " FROM room WHERE room_id = ?";
		// (3)
		RoomRowMapper rowMapper = new RoomRowMapper();
		// (4)
		return jdbcTemplate.queryForObject(sql, rowMapper, roomId);
	}

	// (注)書籍ではgetAllRoomです
	// (5)
	public List<Room> getAllRoomUseRowMapper() {
		// (2)
		String sql = "SELECT room_id, room_name, capacity FROM room";
		// (3)
		RoomRowMapper rowMapper = new RoomRowMapper();
		// (6)
		return jdbcTemplate.query(sql, rowMapper);
	}

	// 3.2.3.1.3. ラムダ式を利用したDaoクラスの実装
	// (注)書籍ではgetAllRoomです
	public List<Room> getAllRoomUseLambda() {
		String sql = "SELECT room_id, room_name, capacity FROM room";
		// (1)
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Room room = new Room();
			room.setRoomId(rs.getString("room_id"));
			room.setRoomName(rs.getString("room_name"));
			room.setCapacity(rs.getInt("capacity"));
			return room;
		});
	}

	// 3.2.3.1.4. BeanPropertyRowMapperを利用したDaoクラスの実装
	public Room getRoomUseBeanPropertyById(String roomId) {
		String sql = "SELECT room_id, room_name, capacity" + " FROM room WHERE room_id = ?";
		// (1)
		RowMapper<Room> rowMapper = new BeanPropertyRowMapper<>(Room.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, roomId);
	}

	// 3.2.3.2.1. ResultSetExtractorクラスの実装
	// (1)
	public List<Room> getAllRoomWithEquipment() {
		// (2)
		String sql = "SELECT r.room_id, r.room_name, r.capacity,"
				+ " e.equipment_id, e.equipment_name, e.equipment_count,"
				+ " e.equipment_remarks FROM room r LEFT JOIN equipment e" + " ON r.room_id = e.room_id";
		// (3)
		RoomListResultSetExtractor extractor = new RoomListResultSetExtractor();
		// (4)
		return jdbcTemplate.query(sql, extractor);
	}

	// (5)
	public Room getRoomWithEquipmentById(String roomId) {
		// (2)
		String sql = "SELECT r.room_id, r.room_name, r.capacity,"
				+ " e.equipment_id, e.equipment_name, e.equipment_count,"
				+ " e.equipment_remarks FROM room r LEFT JOIN equipment e"
				+ " ON r.room_id = e.room_id WHERE r.room_id = ?";
		// (3)
		RoomListResultSetExtractor extractor = new RoomListResultSetExtractor();
		// (6)
		List<Room> roomList = jdbcTemplate.query(sql, extractor, roomId);
		// (7)
		return roomList.get(0);
	}

	// 3.2.3.3. RowCallbackHandlerの実装
	// (1)
	public void reportRooms() throws IOException {
		File csvFile = File.createTempFile("room_", ".csv");
		// IDEのRun実行だとフォルダ直下に出力されません
		// 出力先のパスを確認する場合は下記コメントを外してください
		// System.out.println("CSV出力先:"+csvFile.getAbsolutePath());
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(csvFile), StandardCharsets.UTF_8.name()))) {
			// (2)
			String sql = "SELECT room_id, room_name, capacity FROM room ORDER BY room_id";
			// (3)
			RoomRowCallbackHandler handler = new RoomRowCallbackHandler(writer);
			// (4)
			jdbcTemplate.query(sql, handler);
		}
	}
}
