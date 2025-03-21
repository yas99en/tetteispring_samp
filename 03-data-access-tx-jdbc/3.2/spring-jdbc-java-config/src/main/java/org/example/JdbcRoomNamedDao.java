package org.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

// (1)
@Component
public class JdbcRoomNamedDao {

	// (2)
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public String findRoomNameById(String roomId) {
		// (3)
		String sql = "SELECT room_name FROM room WHERE room_id = :roomId";
		// (4)
		Map<String, Object> params = new HashMap<>();
		params.put("roomId", roomId);
		// (5)
		return namedParameterJdbcTemplate.queryForObject(sql, params, String.class);
	}

	// 3.2.2.5.1. SqlParameterSourceを利用したパラメータの設定
	public String findRoomNameByIdUseSqlParameterSource(String roomId, String roomName, int capacity) {
		String sql = "SELECT room_name FROM room WHERE room_id = :roomId";
		// 本書ではaddValueに固定値を指定しているが、本サンプルではパラメータとして受け取った値を設定する
		MapSqlParameterSource map = new MapSqlParameterSource().addValue("roomId", roomId)
				.addValue("roomName", roomName).addValue("capacity", capacity);
		return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
	}

	public String findRoomNameByIdUseBeanPropertySqlParameterSource(String roomId, String roomName, int capacity) {
		String sql = "SELECT room_name FROM room WHERE room_id = :roomId";
		// 本書ではコンストラクタに固定値を指定しているが、本サンプルではパラメータとして受け取った値を設定する
		Room room = new Room(roomId, roomName, capacity);

		BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(room);
		return namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
	}
}