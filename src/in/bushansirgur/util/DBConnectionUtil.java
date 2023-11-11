package in.bushansirgur.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtil {
	
	private static final String URL = "thin:@oracle.fiap.com.br:1521:ORCL";
	
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	
	private static final String USERNAME = "rm552297";
	
	private static final String PASSWORD = "100103";
	
	private static Connection connection = null;
	
	public static Connection openConnection() {
		if (connection != null)
            return connection;
        else {
            try {
            	
                Class.forName(DRIVER);
             connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm552297", "100103");
               // connection = DriverManager.getConnection(URL,USERNAME ,PASSWORD);
            } catch ( ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
	}
	
	
}
