package com.jin.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	private String name;
	private String phone;
	private Date date;

	private String email;
	private String group;
	private String memo;

	public MyDataMongo(String name, String id, String phone, String email, String group, String memo) {

		super();
		this.name = name;
		this.phone = phone;
		this.date = new Date();
		this.id = id;
		this.email = email;
		this.group = group;
		this.memo = memo;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getgroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
