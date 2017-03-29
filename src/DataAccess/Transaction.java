package DataAccess;

import java.sql.*;
import java.util.ArrayList;

public class Transaction {
	
	MySqlConnector connection = new MySqlConnector();
	PreparedStatement statement=null;
	ResultSet result=null;
	  
	  //-------------------------TRANSFER INTRE CONTURI-----------------------------------------
	  public String TransferIntreConturi(String nr_cont_sursa, String nr_cont_destinatie, Float amount, String descriere, int user_id)
	  {
	      Connection conn=connection.getInstance();
	      try{
	          CallableStatement callableStatement = conn.prepareCall("{call TRANSFER_INTRE_CONTURI(?,?,?,?,?)}");
	          callableStatement.setString(1, nr_cont_sursa);
	          callableStatement.setString(2, nr_cont_destinatie);
	          callableStatement.setFloat(3, amount);
	          callableStatement.setString(4, descriere);
	          callableStatement.setInt(5, user_id);
	          callableStatement.executeQuery();
	        }catch(Exception ex){
	           // System.out.print("Eroare");
	            return "Eroare";
	        }
	      return "Tranzactie efectuata cu succes";
	  }
	  public ArrayList<String> listTransactions(int id)
		{
			Connection conn= connection.getInstance();
			try{
				ArrayList<String> list = new ArrayList<String>();
				String queryStr1 = "Select * from tranzactie where id_employee=?";
				statement =conn.prepareStatement(queryStr1);
				statement.setInt(1,id);
				result = statement.executeQuery();
				
				
				while(result.next())
				{
					list.add(result.getString("idTranz")+" "+result.getString("contS")+" "+result.getString("contD")+" "+result.getString("dataT")+" "+result.getString("suma")+" "+result.getString("descriere"));
				}
				return list;
			}catch(Exception e)
			{
				System.out.print("Eroare listTransactions.");
				return null;
			}
		}
}
