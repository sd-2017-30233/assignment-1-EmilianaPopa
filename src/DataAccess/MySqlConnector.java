package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnector {
	private Connection connection;
	
	private static Connection instance;
	public Connection getInstance()
	{
		return connection;
	}
	
	public MySqlConnector()
	{
		connect();
	}
	
	private void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print("nereusit");
		}
	}
	
	public ResultSet get(String query){
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
                
	}
	
	public int update(String sql) {
		try {
			return connection.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
}
