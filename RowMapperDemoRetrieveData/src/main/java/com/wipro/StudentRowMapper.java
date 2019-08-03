package com.wipro;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
 
		 Student student = new Student();
		 student.setSno(rs.getInt("sno"));
		 student.setName(rs.getString("name"));
		 student.setSalary(rs.getDouble("salary"));
		return student;
	}
}
