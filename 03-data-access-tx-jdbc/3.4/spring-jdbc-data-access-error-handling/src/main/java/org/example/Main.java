package org.example;

import java.sql.SQLException;

import org.example.configuration.TransactionManagerConfig;
import org.example.exception.NotFoundRoomIdException;
import org.example.model.Room;
import org.example.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionManagerConfig.class);
        RoomService roomService = context.getBean("roomService", RoomService.class);
        
        {
	        // 3.4.2.1. データアクセス例外のハンドリングを行なう実装例
        	System.out.println("3.4.2.1. データアクセス例外のハンドリングを行なう実装例");        	
	        Room result = null;
	        try {
	        	result = roomService.getRoomForUpdate("NotExistRoomId");
	        } catch (NotFoundRoomIdException e) {
	        	System.out.println("Tossed NotFoundRoomIdException : " + e.getMessage());
	        }
	        System.out.println(result != null ? "Results obtained." : "Results not obtained.");
	        System.out.println("↑ NotFoundRoomIdExceptionのエラーメッセージが表示されること");
        }
        
        System.out.println();
        
        {
	        // 3.4.3. データアクセス例外の変換ルールのカスタマイズ
        	System.out.println("3.4.3. データアクセス例外の変換ルールのカスタマイズ");
	        Room newRoom = new Room();
	        newRoom.setRoomId("ExistId"); // 既にDBに登録されているRoomId
	        newRoom.setRoomName("ExistRoom");
	        newRoom.setCapacity(10);
	
	        try {
	        	// PostgreSQLの一意性違反(23505)となり、
	        	// カスタマイズした変換ルールによりDataIntegrityViolationExceptionがthrowされる。
	            roomService.insertRoom(newRoom);
	        } catch (DuplicateKeyException e) {
	            ((ConfigurableApplicationContext)context).close();
	            throw new IllegalStateException("Failed. DuplicateKeyException is not expected.");
	        } catch (DataIntegrityViolationException e) {
	            System.out.println(e.getMessage());
	            SQLException se = (SQLException) e.getCause();
	            System.out.println(se.getSQLState());
	            System.out.println("↑ 一意制約のエラーメッセージ、エラーコード(23505)が表示されていること");
	        }
        }
        
        ((ConfigurableApplicationContext)context).close();
    }
}