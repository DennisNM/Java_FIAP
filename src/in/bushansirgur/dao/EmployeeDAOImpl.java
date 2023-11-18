package in.bushansirgur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import in.bushansirgur.model.Employee;
import in.bushansirgur.model.ListFinances;
import in.bushansirgur.model.user_id;
import in.bushansirgur.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	@Override
	public List<ListFinances> getFinances(int user_id) {
		
		List<ListFinances> list = new ArrayList();		
		

		user_id id = new user_id();
		System.out.println(id.getId());
		
		System.out.println(list);
		try {

			String sql = "SELECT * FROM tbl_Finances where user_id =" + user_id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
			ListFinances finances  = new ListFinances();
				finances.setId(resultSet.getInt("id"));
				finances.setName_finance(resultSet.getString("name_finance"));
				finances.setUser_id(resultSet.getInt("user_id"));
				finances.setValue(resultSet.getFloat("value"));
				finances.setType_value(resultSet.getString("type_value"));
				list.add(finances);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		
		return list;
	}
	
	public ListFinances getSingleFinances(int id) {
				
		try {
			String sql = "SELECT * FROM tbl_Finances where id =" + id;

			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			ListFinances finances  = new ListFinances();
			if(resultSet.next()) {
				finances.setId(resultSet.getInt("id"));
				finances.setName_finance(resultSet.getString("name_finance"));
				finances.setUser_id(resultSet.getInt("user_id"));
				finances.setValue(resultSet.getFloat("value"));
				finances.setType_value(resultSet.getString("type_value"));
			}
		return finances;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	public	boolean save(ListFinances finances) {
		try {
			user_id id = new user_id();
			boolean flag = false;
			String sql = "INSERT INTO tbl_Finances(NAME_FINANCE, USER_ID, TYPE_VALUE,VALUE)VALUES"
					+ "('"+finances.getName_finance()+"', "+id.getId()+", '"+finances.getType_value()+"', "+finances.getValue()+")";

			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			flag = true;
		return flag;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}
	
	public	boolean deleteFinances(int finances_id) {
		
		try {
			user_id id = new user_id();
			boolean flag = false;
			String sql = "DELETE FROM tbl_Finances WHERE id =" + finances_id;

			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			flag = true;
		return flag;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

	public	boolean updateFiances(ListFinances finances) {
		try {
			user_id id = new user_id();
			boolean flag = false;
			String sql = "UPDATE tbl_Finances SET NAME_FINANCE = '" + finances.getName_finance() + "', "
			        + "TYPE_VALUE = '" + finances.getType_value() + "', "
			        + "VALUE = " + finances.getValue() + " "
			        + "WHERE id = '" + finances.getId() + "'";

			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			flag = true;
		return flag;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	
	
}
	@Override
	public Employee get(int id) {
		Employee employee = null;
		try {
			employee = new Employee();
			String sql = "SELECT * FROM tbl_employee where id="+id;
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return employee;
	}

	@Override
	public boolean save(Employee e) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO tbl_employee(name, department, dob)VALUES"
					+ "('"+e.getName()+"', '"+e.getDepartment()+"', '"+e.getDob()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM tbl_employee where id="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Employee employee) {
		boolean flag = false;
		try {
			String sql = "UPDATE tbl_employee SET name = '"+employee.getName()+"', "
					+ "department = '"+employee.getDepartment()+"', dob = '"+employee.getDob()+"' where id="+employee.getId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
