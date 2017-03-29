package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Business.*;

public class AccountOp {
	MySqlConnector connection= new MySqlConnector();
	PreparedStatement statement=null;
	ResultSet result=null;
	
	public void insert(Account a)
	{
		Connection conn = connection.getInstance();
		try{
		String queryStr = "Insert into account (idAcc,suma,id_client) values (?,?,?)";
        statement =conn.prepareStatement(queryStr);
        statement.setString(1, a.getIdAcc());
        statement.setFloat(2, a.getSum());
        statement.setString(3, a.getIdClient());
        statement.executeUpdate();
			
		}catch (Exception sqlException)
		{
			System.out.print("Eroare adauga cont.");
		}
	}
	
	public void update(String id, Account a)
	{
		Connection conn= connection.getInstance();
		try{
			String queryStr = "UPDATE account SET suma=?, id_client=? where idAcc=? ";
			statement =conn.prepareStatement(queryStr);
			statement.setFloat(1, a.getSum());
			statement.setString(2, a.getIdClient());
			statement.setString(3, id);
			  statement.executeUpdate();
		}catch(Exception sqlException)
		{
			System.out.print("Eroare update cont.");
		}
	}
	
	public void delete(String id)
	{
		Connection conn= connection.getInstance();
		try{
			String queryStr = "DELETE FROM account where account.idAcc=?";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, id);
			statement.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Eroare delete cont.");
		}
	}
	
	public ArrayList<Account> listAccounts()
	{
		Connection conn= connection.getInstance();
		try{
			ArrayList<Account> list = new ArrayList<Account>();
			String queryStr = "Select * from account";
			statement =conn.prepareStatement(queryStr);
			result = statement.executeQuery();
			while(result.next())
			{
				Account a = new Account(result.getString("idAcc"),result.getFloat("suma"),result.getString("id_client"));
				list.add(a);
			}
			return list;
		}catch(Exception e)
		{
			System.out.print("Eroare listAccounts.");
			return null;
		}
	}
	
	public Account getAccount(String id)
    {
        Connection conn=connection.getInstance();
        try{
            String queryStr="Select * from account where idAcc=?";
            statement=conn.prepareStatement(queryStr);
            result=statement.executeQuery();
            Account a=null;
            while(result.next())
            {
                a=new Account(result.getString("idAcc"), result.getFloat("suma"),result.getString("id_client"));
            }
            return a;
           
        }catch(Exception ex)
        {
            System.out.print("Eroare getAccount.");
            return null;
        }
    }
}
