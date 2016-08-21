package dao;

import java.util.List;

import entity.Student;

public interface ShowTableDao {
	public boolean insertData(Student stu);
	public int getNextId();
	public List getStuList();
	public boolean deleteData(int id);
	public boolean exists(int id);
	public boolean updateData(Student stu);
	public List getQueryStuList(Student stu);
	public boolean usernameExists(String username);
	public boolean login(String username, String password);
	public boolean insertUser(String username ,String password);
}
