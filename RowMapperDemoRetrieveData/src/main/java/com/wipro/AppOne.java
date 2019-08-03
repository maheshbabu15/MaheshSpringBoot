package com.wipro;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppOne {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring.xml");
		JdbcTemplate jdbcTemplate = container.getBean(JdbcTemplate.class);
		
		String sql = "select * from student_tbl";
		List<Student> studentList = jdbcTemplate.query(sql,new StudentRowMapper());
		studentList.forEach(student -> {
			System.out.println(student.getSno());
			System.out.println(student.getName());
			System.out.println(student.getSalary());
			System.out.println(student.getClass());
		});
		
		((AbstractApplicationContext)container).close();
	}
}
