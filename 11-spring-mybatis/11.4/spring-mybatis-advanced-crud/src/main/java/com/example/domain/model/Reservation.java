package com.example.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer reservationId;
	private LocalTime endTime;
	private LocalTime startTime;
	private LocalDate reservedDate;
	private String roomId;
	private String userId;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate = reservedDate;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	private static final String FORMAT = "[RESERVATION] reservation_id:%d | roomId:%s | reserved_date:%s | start_time:%s | end_time:%s";
	@Override
	public String toString() {
		return String.format(FORMAT, reservationId, roomId, reservedDate, startTime, endTime);
	}
}
