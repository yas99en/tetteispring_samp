package org.example.model;

public class Equipment {
	private String equipmentId;
	private String roomId;
	private String equipmentName;
	private int equipmentCount;
	private String equipmentRemarks;

	public Equipment(String equipmentId, String roomId, String equipmentName, int equipmentCount,
			String equipmentRemarks) {
		this.equipmentId = equipmentId;
		this.roomId = roomId;
		this.equipmentName = equipmentName;
		this.equipmentCount = equipmentCount;
		this.equipmentRemarks = equipmentRemarks;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getEquipmentCount() {
		return equipmentCount;
	}

	public void setEquipmentCount(int equipmentCount) {
		this.equipmentCount = equipmentCount;
	}

	public String getEquipmentRemarks() {
		return equipmentRemarks;
	}

	public void setEquipmentRemarks(String equipmentRemarks) {
		this.equipmentRemarks = equipmentRemarks;
	}
}
