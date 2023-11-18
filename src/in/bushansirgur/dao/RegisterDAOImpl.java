package in.bushansirgur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.bushansirgur.model.RegisterDTO;
import in.bushansirgur.model.user_id;
import in.bushansirgur.util.DBConnectionUtil;

public class RegisterDAOImpl implements RegisterDAO {

	@Override
	public boolean registerEmp(RegisterDTO emp) {
		// TODO Auto-generated method stub
		
		
		try{

			String query = "INSERT INTO tbl_login (email, password) VALUES ('" + emp.getEmail() + "', '" + emp.getSenha() + "')";
			Connection con=DBConnectionUtil.openConnection();
			PreparedStatement ps=con.prepareStatement(query);
			ps.executeUpdate();

			boolean	flag = true;
			
			
			return flag;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

}
