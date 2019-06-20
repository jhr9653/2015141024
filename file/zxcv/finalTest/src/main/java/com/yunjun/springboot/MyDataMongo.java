package com.yunjun.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id; 				//아이디
	private String group;			//소속
	private String name;			//이름			
	private String email;			//이메일			
	private String memo;			//메모
	private String phone1;			//전화번호 앞자리
	private String phone2;			//전화번호 중간자리
	private String phone3;			//전화번호 끝자리
	private Date   Date;			//작성날짜
	
	
	public MyDataMongo(String name, String group , String email, String memo, 
					   String phone1, String phone2, String phone3) {
		this.name = name;
		this.group = group;
		this.email = email;
		this.memo = memo;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.Date = new Date();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}


	public Date getDate() {
		return Date;
	}


	public void setDate(Date Date) {
		this.Date = Date;
	}
}

