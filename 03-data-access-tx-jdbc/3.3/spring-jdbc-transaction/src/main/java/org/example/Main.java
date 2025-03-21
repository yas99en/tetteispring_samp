package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.example.configuration.TransactionManagerConfig;
import org.example.model.Equipment;
import org.example.model.Room;
import org.example.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(TransactionManagerConfig.class);
		// 起動前に前回データ消去
		CleanUp.clean(context);

		// 3.3.1.2.1. 基本的な設定方法 / 3.3.2.3. 基本的な使い方
		doBasicTransaction(context);

		// 3.3.3.1. PlatformTransactionManagerを利用した明示的トランザクション制御
		doPlatformTransaction(context);

		// 3.3.3.2. TransactionTemplateを利用した明示的トランザクション制御
		doTransactionTemplate(context);
	}

	/**
	 * 3.3.1.2.1. 基本的な設定方法 / 3.3.2.3. 基本的な使い方
	 * 
	 * @param context
	 */
	private static void doBasicTransaction(ApplicationContext context) {
		logger.info("3.3.1.2.1. 基本的な設定方法 / 3.3.2.3. 基本的な使い方");
		RoomService roomService = context.getBean("roomService", RoomService.class);
		List<Equipment> equipmentList = new ArrayList<>();
		equipmentList.add(new Equipment("eq0001", "C001", "ソファ", 1, "部屋備え付けです"));
		Room newRoom = new Room("C001", "ExampleRoom", 10, equipmentList);
		roomService.insertRoom(newRoom);
		Room result = roomService.getRoom("C001");
		logger.info(String.format("room_id:%s room_name:%s capacity:%d", result.getRoomId(), result.getRoomName(),
				result.getCapacity()));
	}

	/**
	 * 3.3.3.1. PlatformTransactionManagerを利用した明示的トランザクション制御
	 * 
	 * @param context
	 */
	private static void doPlatformTransaction(ApplicationContext context) {
		logger.info("3.3.3.1. PlatformTransactionManagerを利用した明示的トランザクション制御");
		RoomService roomService = context.getBean("roomServicePTM", RoomService.class);
		List<Equipment> equipmentList = new ArrayList<>();
		equipmentList.add(new Equipment("eq0002", "C002", "EPSONプロジェクタ", 1, "部屋備え付けです"));
		Room newRoom = new Room("C002", "ExampleRoom2", 20, equipmentList);
		roomService.insertRoom(newRoom);
		Room result = roomService.getRoom("C002");
		logger.info(String.format("room_id:%s room_name:%s capacity:%d", result.getRoomId(), result.getRoomName(),
				result.getCapacity()));
	}

	/**
	 * 3.3.3.2. TransactionTemplateを利用した明示的トランザクション制御
	 * 
	 * @param context
	 */
	public static void doTransactionTemplate(ApplicationContext context) {
		logger.info("3.3.3.2. TransactionTemplateを利用した明示的トランザクション制御");
		RoomService roomService = context.getBean("roomServiceTT", RoomService.class);
		List<Equipment> equipmentList = new ArrayList<>();
		equipmentList.add(new Equipment("eq0003", "C003", "ワイヤレスマイク", 2, "部屋備え付けです"));
		Room newRoom = new Room("C003", "ExampleRoom3", 30, equipmentList);
		roomService.insertRoom(newRoom);
		Room result = roomService.getRoom("C003");
		logger.info(String.format("room_id:%s room_name:%s capacity:%d", result.getRoomId(), result.getRoomName(),
				result.getCapacity()));
	}
}