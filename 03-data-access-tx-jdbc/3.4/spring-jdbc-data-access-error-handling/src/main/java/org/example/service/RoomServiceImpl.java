package org.example.service;

import org.example.dao.JdbcRoomDao;
import org.example.exception.NotFoundRoomIdException;
import org.example.model.Room;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    JdbcRoomDao jdbcRoomDao;
    
    public RoomServiceImpl(JdbcRoomDao jdbcRoomDao) {
    	this.jdbcRoomDao = jdbcRoomDao;
    }

    // 3.4.2.1. データアクセス例外のハンドリングを行なう実装例
    @Override
    public Room getRoomForUpdate(String roomId) {
        Room room = null;
        try {
            // (1)
            room = jdbcRoomDao.getRoomForUpdate(roomId);
            // (2)
        } catch (DataRetrievalFailureException e) {
            // (3)
            throw new NotFoundRoomIdException("roomId=" + roomId, e);
        }
        return room;
    }

    @Override
    public void insertRoom(Room room) {
        jdbcRoomDao.insertRoom(room);
    }

}
