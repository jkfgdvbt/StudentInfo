package com.jkfgdvbt.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.jkfgdvbt.util.DbUtil;

/**
 * 创建数据库连接对象
 * 整个项目与数据库打交道都用这一个对象
 * 父类
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月1日
 */

public class BaseDao {
	protected Connection con = new DbUtil().getCon();
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
