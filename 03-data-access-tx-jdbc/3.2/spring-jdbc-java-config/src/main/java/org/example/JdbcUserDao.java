package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 3.2.2限定で利用するDao
 */
@Component
public class JdbcUserDao {
     @Autowired
     JdbcTemplate jdbcTemplate;

     public String findUserName(String userId) {
         String sql = "SELECT user_name FROM usr WHERE user_id = ?";
         return jdbcTemplate.queryForObject(sql, String.class, userId);
     }
}
