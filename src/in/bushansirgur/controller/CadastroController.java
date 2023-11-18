package in.bushansirgur.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bushansirgur.dao.RegisterDAOImpl;
import in.bushansirgur.model.RegisterDTO;

@WebServlet("/Cadastro")
public class CadastroController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	RegisterDAOImpl empDAO = null;
	public CadastroController() {
		empDAO = new RegisterDAOImpl();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegisterDTO emp = new RegisterDTO();
		emp.setEmail(request.getParameter("email"));
		emp.setSenha(request.getParameter("password"));
		
		boolean register =empDAO.registerEmp(emp);
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		request.setAttribute("nome", nome);
		request.setAttribute("sobrenome", sobrenome);
		request.setAttribute("email", email);
		request.setAttribute("senha", senha);

		try {
			request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
