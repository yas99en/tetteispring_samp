package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

//(1)
public class RoomListResultSetExtractor implements ResultSetExtractor<List<Room>> {

	// (2)
	@Override
	public List<Room> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// (3)
		Map<String, Room> map = new LinkedHashMap<>();
		// (4)
		while (rs.next()) {
			String roomId = rs.getString("room_id");
			Room room = map.getOrDefault(roomId, new Room(roomId, rs.getString("room_name"), rs.getInt("capacity")));
			map.put(roomId, room);

			// (5)
			String equipmentId = rs.getString("equipment_id");
			if (equipmentId != null) {
				Equipment equipment = new Equipment();
				equipment.setEquipmentId(equipmentId);
				equipment.setRoomId(roomId);
				equipment.setEquipmentName(rs.getString("equipment_name"));
				equipment.setEquipmentCount(rs.getInt("equipment_count"));
				equipment.setEquipmentRemarks(rs.getString("equipment_remarks"));
				room.getEquipmentList().add(equipment);
			}
		}

		// (6)
		if (map.size() == 0) {
			throw new EmptyResultDataAccessException(1);
		}
		// (7)
		return new ArrayList<>(map.values());
	}
}