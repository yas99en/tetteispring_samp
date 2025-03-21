package org.example;

import org.example.configuration.AppConfig;
import org.example.model.Room;
import org.example.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // DBからテーブル情報が取得できることを確認します。
        // 取得処理の詳細については本書の3.2章以降で説明します。
        RoomService roomService = context.getBean(RoomService.class);
        Room room = roomService.getRoom("1");
        System.out.printf("roomName:%s, capacity:%d", room.getRoomName(), room.getCapacity());

        ((ConfigurableApplicationContext) context).close();
    }
}