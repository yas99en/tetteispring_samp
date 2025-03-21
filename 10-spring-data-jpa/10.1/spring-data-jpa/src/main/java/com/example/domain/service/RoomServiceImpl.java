package com.example.domain.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Equipment;
import com.example.domain.model.Room;

@Service
public class RoomServiceImpl implements RoomService {
	
	@PersistenceContext
	private EntityManager entityManager;

	// 10.1.1. ORM(Object-Relational Mapping)とJPAの概念 JPAを使用したコード例
	@Override
	@Transactional(readOnly = true)
	public Room getRoomById(Integer roomId) {
		Room room = entityManager.find(Room.class, roomId);
		if (room == null) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
		    System.out.println("=== room not found ===");
		}
		return room;
	}
	
	// 10.1.5. 関連 関連の関係にあるEntityへアクセスする実装例
	@Override
	@Transactional(readOnly = true)
	public List<Equipment> getEquipmentsInRoom(Integer roomId) {
		Room room = entityManager.find(Room.class, roomId);
		return room.getEquipments();
	}
	
	// 10.1.5. 関連 関連の関係にあるEntityへアクセスする実装例
	@Override
	@Transactional(readOnly = true)
	public Room getRoomOfEquipment(Integer equipmentId) {
		Equipment equipment = entityManager.find(Equipment.class, equipmentId);
		return equipment.getRoom();
	}
	
	// 10.1.6. JPQL (Java Persistence Query Language) 基本的なJPQLの使用例
	@Override
	@Transactional(readOnly = true)
	public List<Room> getRoomsByName(String roomName) {
		String jpql = "SELECT r FROM Room r WHERE r.roomName = :roomName";
		TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
		query.setParameter("roomName", roomName);
		return query.getResultList();
	}
	
}
