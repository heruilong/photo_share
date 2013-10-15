package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection;
    public static Connection getConnection(){
    	try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/photo_share", "root", "tangtang"); 
            return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    public static void closeConnection() throws SQLException{
    	connection.close();
    }
}
