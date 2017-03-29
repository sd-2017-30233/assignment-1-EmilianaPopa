package Presentation;
import java.util.ArrayList;


import DataAccess.*;
import Business.*;

public class Main {
	public static void main(String[] args)
	{
		GUI window = new GUI();
		
		
		ClientsOp c = new ClientsOp();
		AccountOp a = new AccountOp();
		Employees e =new Employees();
		Clients cl= new Clients("2950711896345","Pop Laura","Cluj-Napoca");
		//ArrayList<Clients> clientArrayList=c.listClients();
		//ArrayList<Account> accountArrayList=a.listAccounts();
		//ArrayList<String> employeesArrayList=e.listEmployees();
        //for(int i = 0; i < clientArrayList.size(); i++) {   
  //  System.out.print(clientArrayList.get(i).getCNP());
   // System.out.print(clientArrayList.get(i).getName());-
		
   // System.out.println(clientArrayList.get(i).getAddress());
//}
        
        /*for(int i = 0; i < employeesArrayList.size(); i++) {   
            System.out.println(employeesArrayList.get(i)+"   ");
           
        }*/
		//c.insert(cl);
       //e.insert("Emiliana Popa", "Turda", "0742144378", "emiliana2395@yahoo.com", "parola11", true);
       // e.update(1,"Emiliana Popa" , "Turda", "0742144378","emiliana2395@yahoo.com", "parola", true);	
		//System.out.println(e.login("jcole0@is.gd", "parola1"));
        }
}
