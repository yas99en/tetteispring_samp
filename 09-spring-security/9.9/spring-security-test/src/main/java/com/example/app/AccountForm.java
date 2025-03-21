package com.example.app;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountForm implements Serializable { 
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	@Size(min=2, max=10)
	private String name;
	
	@NotNull
	private Integer age;

	@NotNull
	@NotEmpty
	private String comment;
	
	@NotNull
	private String nullDummy;

	public String getNullDummy() {
		return nullDummy;
	}

	public void setNullDummy(String nullDummy) {
		this.nullDummy = nullDummy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
