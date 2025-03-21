package com.example.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ReservableRoom implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDate reservedDate;
	private String roomId;
	private List<Reservation> reservations;

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate = reservedDate;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	

	private static final String FORMAT = "[RESERVABLE_ROOM] reservedDate:%-8s | roomId:%-3s";
	@Override
	public String toString() {
		return String.format(FORMAT, reservedDate, roomId);
	}
}
