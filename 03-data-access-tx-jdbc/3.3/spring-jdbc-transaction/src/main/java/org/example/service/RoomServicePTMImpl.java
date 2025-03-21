package org.example.service;

import org.example.dao.JdbcRoomDao;
import org.example.model.Equipment;
import org.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Service("roomServicePTM")
public class RoomServicePTMImpl implements RoomService {
	// 3.3.3.1. PlatformTransactionManagerを利用した明示的トランザクション制御
	// 3.3.3.1.1. Serviceの実装
	// (1)
	@Autowired
	PlatformTransactionManager txManager;
	@Autowired
	JdbcRoomDao jdbcRoomDao;

	// for compile
	@Override
	public Room getRoom(String roomId) {
		return jdbcRoomDao.getRoomById(roomId);
	}

	@Override
	public void insertRoom(Room room) {
		// (2)
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		// (3)
		def.setName("InsertRoomWithEquipmentTx");
		// (4)
		def.setReadOnly(false);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// (5)
		TransactionStatus status = txManager.getTransaction(def);
		try {
			jdbcRoomDao.insertRoom(room);
			List<Equipment> equipmentList = room.getEquipmentList();
			for (Equipment item : equipmentList) {
				jdbcRoomDao.insertEquipment(item);
			}
		} catch (Exception e) {
			// (6)
			txManager.rollback(status);
			throw new DataAccessException("error occurred by insert room", e) {
			};
		}
		// (7)
		txManager.commit(status);
	}
}
