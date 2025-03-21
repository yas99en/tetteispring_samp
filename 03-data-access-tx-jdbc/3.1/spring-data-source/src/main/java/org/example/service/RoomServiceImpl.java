package org.example.service;

import org.example.dao.JdbcRoomDao;
import org.example.model.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    JdbcRoomDao jdbcRoomDao;
    
    public RoomServiceImpl(JdbcRoomDao jdbcRoomDao) {
    	this.jdbcRoomDao = jdbcRoomDao;
    }

    @Override
    public Room getRoom(String roomId) {
        return jdbcRoomDao.getRoomById(roomId);
    }
}
