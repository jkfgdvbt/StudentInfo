package com.jkfgdvbt.model;

/**
 * 管理员表
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年1月31日
 */

public class AdminModel{
	private int id;
	private String name;
	private String password;
	private String createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
