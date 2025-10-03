package com.example.domain.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "room")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_room_id_seq")
    @SequenceGenerator(name = "room_room_id_seq", sequenceName = "room_room_id_seq", allocationSize = 1)
	@Column(name = "room_id")
	private Integer roomId;
	
	@Column(name = "room_name")
	private String roomName;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	// 10.2.3.1. 楽観ロック 楽観ロックの使用例
	@Version
	@Column(name = "version")
	private Integer version;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Equipment> equipments;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	

}
