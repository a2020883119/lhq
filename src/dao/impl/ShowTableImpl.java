package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.ShowTableDao;
import db.DBCon;
import entity.Student;

public class ShowTableImpl implements ShowTableDao{
	public boolean insertData(Student stu) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		int id = getNextId();
		stu.setId(id);
		try {
			sql = "insert into showtable values(?, ?, ?, ?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, stu.getId());
			st.setString(2, stu.getName());
			st.setString(3, stu.getClas());
			st.setString(4, stu.getAddr());
			rs = st.executeQuery();

				flag = true;

			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public int getNextId(){
		int id = 0;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		try {
			String sql = "select count(*) from showtable";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				if(rs.getInt(1) != 0){
					sql = "select max(id) from showtable";
					st = conn.prepareStatement(sql);
					rs = st.executeQuery();
					while(rs.next()){
						id = rs.getInt(1);
					}
				}
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id++;
		return id;
	}
	public List getStuList() {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = "select * from showtable order by id";
		Student stu = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				stu = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(stu);
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteData(int id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = null;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		boolean flag = false;
		try {
			if(exists(id)){
				sql = "delete showtable where id = ?";
				st = conn.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
				flag = true;
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = "select * from showtable where id = ? order by id";
		boolean flag = false;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				flag = true;
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean updateData(Student stu) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		String sql = null;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		boolean flag = false;
		try {
			if(exists(stu.getId())){
				sql = "update showtable set name = ? , class = ?, addr = ? where id = ?";
				st = conn.prepareStatement(sql);
				st.setString(1, stu.getName());
				st.setString(2, stu.getClas());
				st.setString(3, stu.getAddr());
				st.setInt(4, stu.getId());
				st.executeUpdate();
				flag = true;
			}
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public List getQueryStuList(Student stu) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = " select * from showtable where 1 = 1 ";
		String endSql;
		endSql = " order by id ";
		if(stu.getId() != 0){
			sql += "and id = " + stu.getId();
		}
		if(!("".equals(stu.getName())) && stu.getName() != null){
			sql += "and name = '" + stu.getName() + "' ";
		}
		if(!("".equals(stu.getClas())) && stu.getClas() != null){
			sql += "and class = '" + stu.getClas() + "' ";
		}
		if(!("".equals(stu.getAddr())) && stu.getAddr() != null){
			sql += "and addr = '" + stu.getAddr() + "' ";
		}
		sql += endSql;
		Student stuu = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				stuu = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(stuu);
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean usernameExists(String username) {
		// TODO Auto-generated method stub
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		String sql = "select * from showtable_users where username = ?";
		boolean flag = false;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				flag = true;
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean login(String username, String password){
		boolean flag = false;
		Connection conn = new DBCon().getConn();
		PreparedStatement prst;
		try {
			String sql = "SELECT * FROM showtable_users WHERE username = ?";
			prst = conn.prepareStatement(sql);
			prst.setString(1, username);
			ResultSet rs = prst.executeQuery();
			if(rs.next()){
					if(password.equals(rs.getString("password"))){
						flag = true;
					}
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public boolean insertUser(String username ,String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(usernameExists(username)){
			return flag;
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = null;
		DBCon db = new DBCon();
		Connection conn = db.getConn();
		try {
			sql = "insert into showtable_users values(?, ?)";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			while(rs.next()){
				flag = true;
			}
			db.safeClose(rs);
			db.safeClose(st);
			db.safeClose(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
