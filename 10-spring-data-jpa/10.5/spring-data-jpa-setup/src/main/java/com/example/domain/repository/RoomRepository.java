package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
