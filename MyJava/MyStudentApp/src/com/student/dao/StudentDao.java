package com.student.dao;

import java.util.List;
import com.student.model.Student;

public interface StudentDao {
	
	String insert_sql = "insert into student(name, major, grade) values (?,?,?)";
	String update_sql = "update student set major=?, grade=? where id=?";
	String delete_sql = "delete from student where id=?";
	String select_sql = "select id, name, major, grade from student";
	
	public int insertStudent(Student s);
	public int deleteStudent(Student s);
	public int updateStudent(Student s);
	public List<Student>selectAllStudent();

}
