package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
	
	private static String url;
    private static String dbName;
    private static String driver;
    private static String userName;
    private static String pass;
    private static Connection conn;
	
    @SuppressWarnings("static-access")
	public MySQLConnector(String url, String dbName, String driver, String userName, String pass){
            MySQLConnector.url = url;             //"jdbc:mysql://localhost:3306/"; 
            MySQLConnector.dbName = dbName;       //"udc";
            MySQLConnector.driver = driver;       //"com.mysql.jdbc.Driver"; 
            MySQLConnector.userName = userName;   //"root"; 
            MySQLConnector.pass = pass;           //"root";
    }
	
	public static Connection getConnection()
	{
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; 
	}
	
	public static void executeStatement(String statement)
	{
		Connection conn = getConnection();
		try {
			Statement st = conn.createStatement();
			st.execute(statement);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
