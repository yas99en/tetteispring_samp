package org.example.service;

import org.example.model.Equipment;
import org.example.dao.JdbcRoomDao;
import org.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//(1)
@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {
	// 3.3.2.3.2. トランザクション対象とするメソッドの実装
	// (2)
	@Autowired
	JdbcRoomDao jdbcRoomDao;

	// (3)
	@Transactional(readOnly = true)
	@Override
	public Room getRoom(String roomId) {
		return jdbcRoomDao.getRoomById(roomId);
	}

	// (4)
	@Override
	public void insertRoom(Room room) {
		jdbcRoomDao.insertRoom(room);
		List<Equipment> equipmentList = room.getEquipmentList();
		for (Equipment item : equipmentList) {
			jdbcRoomDao.insertEquipment(item);
		}
	}
}
