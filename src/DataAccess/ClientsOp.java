package DataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Business.Clients;


public class ClientsOp {
	MySqlConnector connection= new MySqlConnector();
	PreparedStatement statement=null;
	ResultSet result=null;
	
	public void insert(Clients c)
	{
		Connection conn = connection.getInstance();
		try{
		String queryStr = "Insert into clients (CNP_CUI,nume,adresa) values (?,?,?)";
        statement =conn.prepareStatement(queryStr);
        statement.setString(1, c.getCNP());
        statement.setString(2, c.getName());
        statement.setString(3, c.getAddress());
        statement.executeUpdate();
			
		}catch (Exception sqlException)
		{
			System.out.print("Eroare adauga clienti.");
		}
	}
	
	public void update(String CNP, Clients c)
	{
		Connection conn= connection.getInstance();
		try{
			String queryStr = "UPDATE clients SET nume=?, adresa=? where CNP_CUI=? ";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, c.getName());
			statement.setString(2, c.getAddress());
			statement.setString(3, CNP);
			statement.executeUpdate();
		}catch(Exception sqlException)
		{
			System.out.print("Eroare update clienti.");
		}
	}
	
	public void delete(String CNP)
	{
		Connection conn= connection.getInstance();
		try{
			String queryStr = "DELETE FROM clients where clients.CNP_CUI=?";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, CNP);
			statement.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Eroare delete clienti.");
		}
	}
	
	public ArrayList<Clients> listClients()
	{
		Connection conn= connection.getInstance();
		try{
			ArrayList<Clients> list = new ArrayList<Clients>();
			String queryStr = "Select * from clients";
			statement =conn.prepareStatement(queryStr);
			result = statement.executeQuery();
			while(result.next())
			{
				Clients c = new Clients(result.getString("CNP_CUI"),result.getString("nume"),result.getString("adresa"));
				list.add(c);
			}
			return list;
		}catch(Exception e)
		{
			System.out.print("Eroare listClients.");
			return null;
		}
	}
	
	public Clients getClient(String CNP)
    {
        Connection conn=connection.getInstance();
        try{
            String queryStr="Select * from clients where CNP_CUI=?";
            statement=conn.prepareStatement(queryStr);
            result=statement.executeQuery();
            Clients c=null;
            while(result.next())
            {
                c=new Clients(result.getString("CNP_CUI"), result.getString("nume"),result.getString("adresa"));
            }
            return c;
           
        }catch(Exception ex)
        {
            System.out.print("Eroare getClient.");
            return null;
        }
    }
}
