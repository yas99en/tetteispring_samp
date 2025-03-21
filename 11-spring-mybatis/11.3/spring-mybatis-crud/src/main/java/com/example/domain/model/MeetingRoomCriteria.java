package com.example.domain.model;

import java.io.Serializable;

// 11.3.4.3. 引数が2つ以上の場合 JavaBeanの定義例
public class MeetingRoomCriteria implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	private Integer capacity;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
}
