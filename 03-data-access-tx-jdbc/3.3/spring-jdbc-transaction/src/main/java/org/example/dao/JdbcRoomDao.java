package org.example.dao;

import org.example.model.Equipment;
import org.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
public class JdbcRoomDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Room getRoomById(String roomId) {
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

    public int insertEquipment(Equipment equipment) {
        String sql = "INSERT INTO equipment VALUES (?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql,
                equipment.getEquipmentId(),
                equipment.getRoomId(),
                equipment.getEquipmentName(),
                equipment.getEquipmentCount(),
                equipment.getEquipmentRemarks());
    }

    // 掃除用
    @Transactional
    public int deleteRoomById(String roomId) {
        String sql = "DELETE FROM room WHERE room_id=?";
        return jdbcTemplate.update(sql, roomId);
    }

    // 掃除用
    @Transactional
    public int deleteEquipmentById(String equipmentId) {
        String sql = "DELETE FROM equipment WHERE equipment_id=?";
        return jdbcTemplate.update(sql, equipmentId);
    }


}

