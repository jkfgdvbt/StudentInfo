package com.jkfgdvbt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.util.StringUtil;

/**
 * 班级信息与数据库的操作
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月9日
 */

public class ClassDao extends BaseDao {
	public boolean addClass(ClassModel scl) {
		String sql = "insert into s_class values(null, ?, ?)";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, scl.getName());
			prst.setString(2, scl.getInfo());
			if(prst.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ClassModel> getClassList(ClassModel studentClass) {
		List<ClassModel> retList = new ArrayList<ClassModel>();
		String sqlString = "select * from s_class";
		if(!StringUtil.isEmpty(studentClass.getName())) {
			sqlString += " where name like '%" + studentClass.getName() + "%'";
		}
		PreparedStatement prst;
		try {
			prst = con.prepareStatement(sqlString);
			ResultSet executeQuery = prst.executeQuery();
			while(executeQuery.next()) {
				ClassModel sc = new ClassModel();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean delete(int id) {
		String sql = "delete from s_class where id =?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(ClassModel sc) {
		String sql = "update s_class set name=?, info=? where s_class.id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
