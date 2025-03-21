package com.example.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>, RoomRepositoryCustom {

	// 10.6.2.1. @Queryを使用する方法
	// @Queryの使用例
	@Query("SELECT r FROM Room r WHERE r.roomName = :roomName")
	List<Room> findByRoomName(@Param("roomName") String roomName);

	@Modifying
	@Query("UPDATE Room r SET r.capacity = :capacity")
	Integer updateCapacityAll(@Param("capacity") Integer capacity);

	// @Queryで許容されているJPQLの例
	@Query("SELECT r FROM Room r WHERE r.roomName LIKE %:roomName")
	List<Room> findByRoomNameLike(@Param("roomName") String roomName);

	// SpELを埋め込んだJPQLの例
	@Query("SELECT e FROM #{#entityName} e WHERE e.createdDate = :createdDate")
	<T> List<T> findByCreatedDate(@Param("createdDate") LocalDateTime createdDate);

	// 10.6.2.2. メソッド名からクエリを生成する方法
	// メソッド名からクエリを生成する例
	List<Room> findByRoomNameAndCapacity(String roomName, Integer capacity);

	// 10.6.3. 排他制御
	// 悲観ロックの定義例
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	List<Room> findAll();
	
	// 10.6.4. ページネーション
	// ページネーションの使用例
	@Query("SELECT r FROM Room r WHERE r.roomId BETWEEN ?1 and ?2")
    Page<Room> findByIdBetween(int min, int max, Pageable pageable);

}
