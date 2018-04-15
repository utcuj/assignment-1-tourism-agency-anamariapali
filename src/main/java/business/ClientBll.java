package business;

import java.util.ArrayList;

import DataAccess.ClientData;
import model.Client;



public class ClientBll {

	 ClientData operation=new ClientData();
	    public void addClient(String CNP, String nume, int noCard,String address)
	    {
	        boolean validate= ClientValidator.validate(CNP);
	        if(validate == true)
	        {
	            Client c=new Client(CNP, nume,noCard, address);
	            operation.insert(c);
	        }
	    }
	    
	    public void deleteClient(String CNP)
	    {
	        boolean validate=ClientValidator.validate(CNP);
	        if(validate == true)
	        {
	            operation.delete(CNP);
	        }
	    }
	    
	    public void updateClient(String CNP, String nume,int noCard, String address)
	    {
	        boolean validate=ClientValidator.validate(CNP);
	        if(validate==true)
	        {
	            Client c=new Client(CNP, nume, noCard, address);
	            operation.update(CNP, c);
	        }
	    }
	    
	    public ArrayList<Client> getC()
	    {
	        return operation.listClients();
	    }
	    
	    public Client getC(String CNP)
	    {
	        boolean validate=ClientValidator.validate(CNP);
	        if(validate==true)	        {
	            return operation.getClient(CNP);
	        }
	        else return null;
	    }
	
	
}
