package in.bushansirgur.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.bushansirgur.dao.EmployeeDAO;
import in.bushansirgur.dao.EmployeeDAOImpl;
import in.bushansirgur.model.Employee;
import in.bushansirgur.model.ListFinances;
import in.bushansirgur.model.user_id;

public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	EmployeeDAO employeeDAO = null;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listEmployee(request, response);
				break;
				
			case "EDIT":
				getSingleEmployee(request, response);
				break;
				
			case "DELETE":
				deleteEmployee(request, response);
				break;
				
			default:
				listEmployee(request, response);
				break;
				
		}
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean check =	employeeDAO.deleteFinances(Integer.parseInt(id));
		
		if(check) {
			request.setAttribute("NOTIFICATION", "Employee Deleted Successfully!");
		}
		
		listEmployee(request, response);
	}

	private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
	//	Employee theEmployee = employeeDAO.get(Integer.parseInt(id));
		ListFinances finaceEmployee = employeeDAO.getSingleFinances(Integer.parseInt(id));
		request.setAttribute("employee", finaceEmployee);
		
		dispatcher = request.getRequestDispatcher("/views/employee-form.jsp");
		
		dispatcher.forward(request, response);
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	user_id id = new user_id();
		List<ListFinances> list  = employeeDAO.getFinances(id.getId());
		request.setAttribute("list", list);
		System.out.println(list);
		
		dispatcher = request.getRequestDispatcher("/views/employee-list.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");	
		
		ListFinances finance = new ListFinances();
		
		finance.setName_finance(request.getParameter("name"));
		finance.setType_value(request.getParameter("employeeType"));
		finance.setValue(Float.parseFloat(request.getParameter("dob")));
		
		if(id.isEmpty() || id == null) {
			
			if(employeeDAO.save(finance)) {
				request.setAttribute("NOTIFICATION", "Employee Saved Successfully!");
			}
		
		}else {
			
			finance.setId(Integer.parseInt(id));
			if(employeeDAO.updateFiances(finance)) {
				request.setAttribute("NOTIFICATION", "Employee Updated Successfully!");
			}
			
		}
		
		listEmployee(request, response);
	}

}
