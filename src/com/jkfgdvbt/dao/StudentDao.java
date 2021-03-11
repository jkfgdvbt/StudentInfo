package com.jkfgdvbt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jkfgdvbt.model.AdminModel;
import com.jkfgdvbt.model.ClassModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.model.StudentModel;
import com.jkfgdvbt.util.StringUtil;

/**
 * 学生连接数据库
 * 
 * StudentInfo
 * @author jkfgdvbt
 * 2021年2月27日
 */

public class StudentDao extends BaseDao {
	public boolean addStudent(StudentModel student) {
		String sql = "insert into s_student values(null,?,?,?,?)";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, student.getName());
			prst.setInt(2, student.getClassId());
			prst.setString(3, student.getPassword());
			prst.setString(4, student.getSex());
			if(prst.executeUpdate() > 0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<StudentModel> getStudentList(StudentModel student) {
		List<StudentModel> retList = new ArrayList<StudentModel>();
		StringBuffer sql = new StringBuffer("select * from s_student");
		if(!StringUtil.isEmpty(student.getName())) {
			sql.append(" and name like '%" + student.getName() + "%'");
		}
		if(student.getClassId() != 0) {
			sql.append(" and classId =" + student.getClassId());
		}
		PreparedStatement prst;
		try {
			prst = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = prst.executeQuery();
			while(executeQuery.next()) {
				StudentModel s = new StudentModel();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));
				s.setClassId(executeQuery.getInt("classId"));
				s.setPassword(executeQuery.getString("password"));
				s.setSex(executeQuery.getString("sex"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean delete(int id) {
		String sql = "delete from s_student where id =?";
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

	public boolean update(StudentModel student) {
		String sql = "update s_student set name=?, classId=?, sex=?, password=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassId());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getPassword());
			preparedStatement.setInt(5, student.getId());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String editPassword(StudentModel student, String newPassword) {
		String sql = "select * from s_student where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, student.getId());
			prst.setString(2, student.getPassword());
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
		String sqlString = "update s_student set password = ? where id = ?";
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
	
	public StudentModel login(StudentModel student) {
		String sql = "select * from s_student where name=? and password=?";
		StudentModel studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, student.getName());
			prst.setString(2, student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				studentRst = new StudentModel();
				studentRst.setId(executeQuery.getInt("id"));
				studentRst.setName(executeQuery.getString("name"));
				studentRst.setPassword(executeQuery.getString("password"));
				studentRst.setSex(executeQuery.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}
}
