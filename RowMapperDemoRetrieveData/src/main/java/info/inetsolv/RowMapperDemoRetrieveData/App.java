package info.inetsolv.RowMapperDemoRetrieveData;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App  {
 
public static void main( String[] args )
 {
	ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("spring.xml"); 
	JdbcTemplate jdbcTemplate = container.getBean(JdbcTemplate.class);
	
	String sql = "select * from emp_tbl";
	List<Employee> emplist= jdbcTemplate.query(sql, new EmployeeRowMapper());
	emplist.forEach(employee -> {
		System.out.println(employee.getEno());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getClass());
	});
	
	
	((AbstractApplicationContext)container).close();
    }
}
