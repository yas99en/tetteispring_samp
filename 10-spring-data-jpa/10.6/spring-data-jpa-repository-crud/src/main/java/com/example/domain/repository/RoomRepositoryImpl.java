package com.example.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.example.domain.model.Room;

public class RoomRepositoryImpl implements RoomRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Room> findByRangeWithCapacity(Integer minCapacity, Integer maxCapacity) {

		String query = "SELECT r FROM Room r WHERE r.capacity >= :minCapacity AND r.capacity <= :maxCapacity";

		TypedQuery<Room> typedQuery = entityManager.createQuery(query, Room.class);

		typedQuery.setParameter("minCapacity", minCapacity);
		typedQuery.setParameter("maxCapacity", maxCapacity);

		List<Room> rooms = typedQuery.getResultList();
		return rooms;
	}

}
