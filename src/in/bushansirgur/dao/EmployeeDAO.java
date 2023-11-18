package in.bushansirgur.dao;

import java.util.List;

import in.bushansirgur.model.Employee;
import in.bushansirgur.model.ListFinances;

public interface EmployeeDAO {
	
	List<ListFinances> getFinances(int user_id);
	
	ListFinances getSingleFinances(int user_id);
	
	boolean save(ListFinances finances);
	
	boolean deleteFinances(int finances_id);
	
	boolean updateFiances(ListFinances finances);

	Employee get(int id);
	
	boolean save(Employee employee);
	
	boolean delete(int id);
	
	boolean update(Employee employee);
}
