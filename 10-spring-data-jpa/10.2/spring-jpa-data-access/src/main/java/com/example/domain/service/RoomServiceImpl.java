package com.example.domain.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@PersistenceContext
	private EntityManager entityManager;

	//10.2.1. JPAによるCRUD操作　JPAによるCRUD操作の実装例
	// Roomを1件取得する
	@Override
	@Transactional(readOnly = true)
	public Room getRoom(Integer id) {
		Room room = entityManager.find(Room.class, id);
		if (room == null) {
			// 対象のroomが存在しない場合の処理
			// 本来は例外処理を実装するが、本書では省略
		    System.out.println("=== room not found ===");
		}
		return room;
	}

	//10.2.1. JPAによるCRUD操作　JPAによるCRUD操作の実装例
	// 新しいルームを作成する
	@Override
	@Transactional
	public Room createRoom(String roomName, Integer capacity) {
		Room room = new Room();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		entityManager.persist(room);
		return room;
	}

	//10.2.1. JPAによるCRUD操作　JPAによるCRUD操作の実装例
	// ルーム名を更新する
	@Override
	@Transactional
	public Room updateRoomName(Integer id, String roomName) {
		Room room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

	//10.2.1. JPAによるCRUD操作　JPAによるCRUD操作の実装例
	// ルームを削除する
	@Override
	@Transactional
	public void deleteRoom(Integer id) {
		Room room = getRoom(id);
		entityManager.remove(room);
	}
	
	// 10.2.2. JPAによるJPQLを用いたデータアクセス JOIN FETCHを用いた関連Entityのフェッチ読み込み
	@Override
	@Transactional(readOnly = true)
	public List<Room> getRoomsByNameFetch(String roomName) {
		String jpql = "SELECT DISTINCT r FROM Room r LEFT JOIN FETCH r.equipments " +
										"WHERE r.roomName = :roomName";
		TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
		query.setParameter("roomName", roomName);
		return query.getResultList();
	}

	// 10.2.2.1. データベースの更新 更新系JPQLの利用例
	@Override
	@Transactional
	public Integer updateCapacityAll(Integer capacity) {
		String jpql = "UPDATE Room r SET r.capacity = :capacity";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("capacity", capacity);
		return query.executeUpdate();
	}
	
	// 10.2.3.1. 楽観ロック 楽観ロックの使用例
	@Override
	@Transactional
	public Room updateRoomWithOptimisticLock(Integer id, String roomName) {
		Room room = entityManager.find(Room.class, id);
		entityManager.lock(room, LockModeType.OPTIMISTIC);
		try {
			// 5秒待機
			Thread.sleep(5000);
			// 更新処理
			room.setRoomName(roomName);
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return room;
	}

	// 10.2.3.2. 悲観ロック 悲観ロックの使用例
	@Override
	@Transactional
	public Room updateRoomWithPessimisticLock(Integer id, Integer capacity) {
		Room room = entityManager.find(Room.class, id);
		try {
	        entityManager.lock(room, LockModeType.PESSIMISTIC_READ);
	    } catch (PessimisticLockException e) { 
	    	e.printStackTrace();
	    } catch (LockTimeoutException e) {
	    	e.printStackTrace();
	    }
		try {
			// 10秒待機
			Thread.sleep(10000);
			// 更新処理
			room.setCapacity(room.getCapacity() + capacity);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return room;
	}
	
	// 楽観ロック確認
	@Override
	@Transactional
	public Room checkUpdateRoomOptimisticLock(Integer id, String roomName) {
		Room room = getRoom(id);
		room.setRoomName(roomName);
		return room;
	}

}
