package org.example;

import org.example.dao.JdbcRoomDao;
import org.springframework.context.ApplicationContext;

public class CleanUp {
    public static void clean(ApplicationContext context) {

        // 3.3.2.3. 前処理
        JdbcRoomDao dao = context.getBean("jdbcRoomDao", JdbcRoomDao.class);
        dao.deleteEquipmentById("eq0001");
        dao.deleteRoomById("C001");

        // 3.3.3.1. 前処理
        dao.deleteEquipmentById("eq0002");
        dao.deleteRoomById("C002");

        // 3.3.3.2. 前処理
        dao.deleteEquipmentById("eq0003");
        dao.deleteRoomById("C003");
    }
}