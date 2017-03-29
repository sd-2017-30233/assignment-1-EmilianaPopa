package Business;

import java.util.ArrayList;

import DataAccess.ClientsOp;

public class ClientManager {
	 ClientsOp operation=new ClientsOp();
	    public void addClient(String CNP, String nume, String address)
	    {
	        boolean validate= ClientValidation.validate(CNP);
	        if(validate == true)
	        {
	            Clients c=new Clients(CNP, nume, address);
	            operation.insert(c);
	        }
	    }
	    
	    public void deleteClient(String CNP)
	    {
	        boolean validate=ClientValidation.validate(CNP);
	        if(validate == true)
	        {
	            operation.delete(CNP);
	        }
	    }
	    
	    public void updateClient(String CNP, String nume, String address)
	    {
	        boolean validate=ClientValidation.validate(CNP);
	        if(validate==true)
	        {
	            Clients c=new Clients(CNP, nume, address);
	            operation.update(CNP, c);
	        }
	    }
	    
	    public ArrayList<Clients> getC()
	    {
	        return operation.listClients();
	    }
	    
	    public Clients getCs(String CNP)
	    {
	        boolean validate=ClientValidation.validate(CNP);
	        if(validate==true)	        {
	            return operation.getClient(CNP);
	        }
	        else return null;
	    }
	}