package com.jin.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	private String name;
	private int phone;
	private Date date;

	private String email;
	private String group;
	private String memo;

	public MyDataMongo(String name, String id, int phone, String email, String group, String memo) {

		super();
		this.name = name;
		this.phone = phone;
		this.date = new Date();
		this.id = id;
		this.email = email;
		this.group = group;
		this.memo = memo;
	}
