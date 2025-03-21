package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.Room;

//10.4.2. JpaRepository Repositoryインターフェイスの定義例
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
