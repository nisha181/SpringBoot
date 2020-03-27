package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<Student> findAll() {
		String query = "select * from studentss";
		return jt.query(query, (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getString(3)));

	}

	@Override
	public List<Student> findByName(Student student) {
		String sql="select * from studentss where name=?";
		EmployeeRowMapper rowmapper=new EmployeeRowMapper();
		List<Student> list=jt.query(sql, rowmapper,student.getName());
		return list;
	}

	@Override
	public int create(Student student) {
			int result=jt.update("insert into studentss values(?,?,?)",student.getId(),student.getName(),student.getCourse());
			return result;
	}

	@Override
	public int update(Student student) {
		int result=jt.update("update studentss set name=?,course=? where id=?",student.getName(),student.getCourse(),student.getId());
		return result;		
	}

	@Override
	public int delete(int id) {
		int result=jt.update("delete from studentss where id=?",id);
		return result;
	}

	@Override
	public int countStudent() {
		return findAll().size();
	}

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

}
