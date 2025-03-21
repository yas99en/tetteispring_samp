package org.example.service;

import org.example.dao.JdbcRoomDao;
import org.example.model.Equipment;
import org.example.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service("roomServiceTT")
public class RoomServiceTTImpl implements RoomService {
    // 3.3.3.2. TransactionTemplateを利用した明示的トランザクション制御
    // 3.3.3.2.1. Serviceの実装
    // (1)
    @Autowired
    TransactionTemplate transactionTemplate;
    @Autowired
    JdbcRoomDao jdbcRoomDao;

    // for compile
    @Override
    public Room getRoom(String roomId) {
        return jdbcRoomDao.getRoomById(roomId);
    }

    @Override
    public void insertRoom(final Room room) {
        // (2)
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            // (3)
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                // (4)
                jdbcRoomDao.insertRoom(room);
                List<Equipment> equipmentList = room.getEquipmentList();
                for (Equipment item : equipmentList) {
                    jdbcRoomDao.insertEquipment(item);
                }
            }
        });
    }
}
