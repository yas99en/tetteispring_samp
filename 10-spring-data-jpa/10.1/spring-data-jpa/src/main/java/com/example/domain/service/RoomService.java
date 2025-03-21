package com.example.domain.service;

import java.util.List;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

public interface RoomService {
	
	// 10.1.1. ORM(Object-Relational Mapping)とJPAの概念 JPAを使用したコード例
	Room getRoomById(Integer roomId);
	
	// 10.1.5. 関連 関連の関係にあるEntityへアクセスする実装例
	List<Equipment> getEquipmentsInRoom(Integer roomId);
	
	// 10.1.5. 関連 関連の関係にあるEntityへアクセスする実装例
	Room getRoomOfEquipment(Integer equipmentId);
	
	// 10.1.6. JPQL (Java Persistence Query Language) 基本的なJPQLの使用例
	List<Room> getRoomsByName(String roomName);
	
}
