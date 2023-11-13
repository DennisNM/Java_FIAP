package in.bushansirgur.dao;

import java.util.List;

import in.bushansirgur.model.Employee;
import in.bushansirgur.model.ListFinances;

public interface EmployeeDAO {
	
	List<ListFinances> getFinances(int user_id);
	
	Employee get(int id);
	
	boolean save(Employee employee);
	
	boolean delete(int id);
	
	boolean update(Employee employee);
}
