package in.bushansirgur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.bushansirgur.model.Login;
import in.bushansirgur.util.DBConnectionUtil;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public String loginCheck(Login loginBean) {
		String query="select * from tbl_login where email = " + "'"+ loginBean.getEmail() +"'" + " and password = " + "'" + loginBean.getPassword() + "'";
		System.out.println(query);
		try{
			Connection con=DBConnectionUtil.openConnection();
		//	PreparedStatement ps=con.prepareStatement(query);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	
			
			System.out.println(con);
			String checkEmail = "";
			//ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("EMAIL"));
				checkEmail = rs.getString("EMAIL");
			}
		System.out.println(checkEmail);
			System.out.println(loginBean.getEmail() + loginBean.getPassword());
			if(checkEmail != null && checkEmail != ""){
				System.out.println("true");
				return "true";
			}
			else{
				System.out.println("false");
				return "false";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "error";
	}

}
