package Business;

import java.util.ArrayList;

import DataAccess.*;

public class AccountManager {
	AccountOp operation=new AccountOp();
    public void addAccount(String id, float suma, String idClient)
    {
        boolean validate= ClientValidation.validate(id);
        if(validate == true)
        {
            Account a=new Account(id, suma, idClient);
            operation.insert(a);
        }
    }
    
    public void deleteAccount(String id)
    {   
            operation.delete(id);
    }
    
    public void updateAccount(String idAcc, float sum, String id)
    {
        boolean validate=ClientValidation.validate(id);
        if(validate==true && AccountValidation.validate(sum))
        {
            Account a=new Account(idAcc, sum, id);
            operation.update(idAcc, a);
        }
    }
    
    public ArrayList<Account> getA()
    {
        return operation.listAccounts();
    }
    
    public Account getAs(String id)
    {
            return operation.getAccount(id);
       
    }
}
