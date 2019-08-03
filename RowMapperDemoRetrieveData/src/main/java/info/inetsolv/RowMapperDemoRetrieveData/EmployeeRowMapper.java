package info.inetsolv.RowMapperDemoRetrieveData;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee employee = new Employee();
		employee.setEno(rs.getInt("eno"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}
}
