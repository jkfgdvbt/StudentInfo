package com.jkfgdvbt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jkfgdvbt.model.AdminModel;

/**
 * 管理员登录
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月1日
 */

public class AdminDao extends BaseDao {
	public AdminModel login(AdminModel admin) {
		String sql = "select * from s_admin where name=? and password=?";
		AdminModel adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				adminRst = new AdminModel();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	}
	public String editPassword(AdminModel admin, String newPassword) {
		String sql = "select * from s_admin where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()) {
				String retString = "旧密码错误";
				return retString;
			}
			id = executeQuery.getInt("id");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		String retString = "密码修改失败";
		String sqlString = "update s_admin set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);//把sql语句传给数据库操作对象
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0) {
				retString = "密码修改成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retString;
	}
	
}
