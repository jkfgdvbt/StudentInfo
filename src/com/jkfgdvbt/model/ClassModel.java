package com.jkfgdvbt.model;

/**
 * 班级信息表
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月9日
 */

public class ClassModel {
	private int id;
	private String name;
	private String info;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
