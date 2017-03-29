package DataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

import DataAccess.*;

public class Employees {

	private int idUser;
	
	
	MySqlConnector connection=new MySqlConnector();
	PreparedStatement statement=null;
	PreparedStatement statement1=null;
	ResultSet result=null;
	ResultSet result1=null;
	
	public void setID(int id)
	{
		this.idUser=id;
	}
	
	public String login(String email, String passwords)
    {
        Connection conn=connection.getInstance();
        try{
          String sql="select * from employees e where e.username=? AND e.parola=?";
          statement=conn.prepareStatement(sql);
          statement.setString(1, email);
          statement.setString(2, passwords);
          result=statement.executeQuery();
          while(result.next())
          {
              if(result.getInt("isAdmin")==1) return "Admin";
              else return "Regular";
          }
        }catch(Exception ex){
            
            return "Eroare";
        }
        return "Date gresite";
    }
	
	public void insert(String nume, String adresa, String telefon, String username, String parola, boolean isAdmin)
	{
		Connection conn = connection.getInstance();
		try{

		String queryStr = "INSERT INTO employees (nume,adresa,telefon,username,parola,isAdmin) VALUES (?,?,?,?,?,?)";
		
		statement =conn.prepareStatement(queryStr);
		statement.setString(1, nume);
        statement.setString(2, adresa);
        statement.setString(3, telefon);
		statement.setString(4, username);
        statement.setString(5, parola);
        statement.setBoolean(6, isAdmin);
        statement.executeUpdate();
		}
		catch (Exception sqlException)
		{
			System.out.print("Eroare adauga employees");
		}
		
	
	}
	
	public void update(int id, String nume, String adresa, String telefon, String username, String parola, boolean isAdmin)
	{
		Connection conn= connection.getInstance();
		try{
			String queryStr1 = "UPDATE employees SET nume=?, adresa=?, telefon=?,username=?, parola=?, isAdmin=? where idEmpl=? ";
			statement =conn.prepareStatement(queryStr1);
			statement.setString(1, nume);
			statement.setString(2, adresa);
			statement.setString(3, telefon);
			statement.setString(4, username);
			statement.setString(5, parola);
			statement.setBoolean(6, isAdmin);
			statement.setInt(7, id);
			statement.executeUpdate();
			
	
		}catch(Exception sqlException)
		{
			System.out.print("Eroare update employees.");
		}
	}
	
	public void delete(String id)
	{
		Connection conn= connection.getInstance();
		try{
			String queryStr1 = "DELETE FROM employees where employees.idEmpl=?";
		
			statement =conn.prepareStatement(queryStr1);
			statement.setString(1, id);
			statement.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Eroare delete employees.");
		}
	}
	
	public ArrayList<String> listEmployees()
	{
		Connection conn= connection.getInstance();
		try{
			ArrayList<String> list = new ArrayList<String>();
			String queryStr1 = "Select * from employees";
			
			statement =conn.prepareStatement(queryStr1);
			result = statement.executeQuery();
			
			
			while(result.next())
			{
				list.add(result.getString("idEmpl")+" "+result.getString("nume")+" "+result.getString("adresa")+" "+result.getString("telefon")+" "+result.getString("username")+" "+result.getString("isAdmin"));
				
				
			}
			return list;
		}catch(Exception e)
		{
			System.out.print("Eroare listEmployees.");
			return null;
		}
	}
}
