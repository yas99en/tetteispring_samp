package com.example.domain.repository;

import java.util.List;

import com.example.domain.model.Room;

// 10.6.5. Repositoryへのカスタムメソッドの追加 カスタムメソッドの定義例
public interface RoomRepositoryCustom {
	List<Room> findByRangeWithCapacity(Integer minCapacity, Integer maxCapacity);
}
