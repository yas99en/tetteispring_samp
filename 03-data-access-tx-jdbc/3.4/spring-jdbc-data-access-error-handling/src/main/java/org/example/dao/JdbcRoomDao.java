package org.example.dao;

import java.util.Map;

import org.example.model.Room;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JdbcRoomDao {

    JdbcTemplate jdbcTemplate;
    
    public JdbcRoomDao(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }

    public Room getRoomForUpdate(String roomId) {
        String sql = "SELECT room_id, room_name, capacity FROM room WHERE room_id = ?";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql, roomId);
        Room room = new Room();
        room.setRoomId((String) result.get("room_id"));
        room.setRoomName((String) result.get("room_name"));
        room.setCapacity((Integer) result.get("capacity"));
        return room;
    }

    @Transactional
    public int insertRoom(Room room) {
        String sql = "INSERT INTO room(room_id, room_name, capacity)"
                + " VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql, room.getRoomId(),
                room.getRoomName(), room.getCapacity());
    }

}

