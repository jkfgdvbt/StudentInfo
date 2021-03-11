package com.jkfgdvbt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 与数据库建立连接
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月1日
 */

public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_student?useUnicode=true&characterEncoding=utf8"; //数据库连接地址
	private String dbUserName = "root"; //用户名
	private String dbPassword = ""; //密码
	private String jdbcName = "com.mysql.jdbc.Driver"; //驱动名称
	
	/**
	 * 
	 * 获取数据库连接
	 * @return
	 */
	
	/*
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	public Connection getCon() {// ctrl+shift+o 导入包 java.
		try {
			Class.forName(jdbcName);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/*
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 * 
	 * 
	 */
	 public void closeCon(Connection con) throws Exception {
		 if(con != null) {
			 con.close();
		 }
	 }
	 
	 public static void main(String[] args) {
		 DbUtil dbUtil = new DbUtil();
		 try {
			 dbUtil.getCon();
			 System.out.println("数据库连接成功！");
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("数据库连接失败");
		 }
	 }
	
}
