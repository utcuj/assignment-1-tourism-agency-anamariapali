package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import model.Client;


public class ClientData implements ClientI {
	protected static final Logger LOGGER = Logger.getLogger(Client.class.getName());
	PreparedStatement statement=null;
	ResultSet result=null;
	
	public void insert(Client c)
	{
		Connection conn =  ConnectionFactory.getConnection();
		
		try{
		String queryStr = "Insert into clients (CNP,nameC,noCard,address) values (?,?,?,?)";
        statement =conn.prepareStatement(queryStr);
        statement.setString(1, c.getCNP());
        statement.setString(2, c.getNameC());
        statement.setInt(3, c.getNoCard());
        statement.setString(4, c.getAddress());
        statement.executeUpdate();
			
		}catch (Exception sqlException)
		{
			System.out.println("Eroare adauga clienti." + sqlException.getMessage());
		}
	}
	
	
	
	
	public void update(String CNP, Client c)
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			String queryStr = "UPDATE clients SET numeC=?,noCard=? ,address=? where CNP=? ";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, c.getNameC());
			statement.setString(2, c.getAddress());
			statement.setInt(3, c.getNoCard());
			statement.setString(4, CNP);
			statement.executeUpdate();
		}catch(Exception sqlException)
		{
			System.out.print("Eroare update clienti.");
		}
	}
	
	public void delete(String CNP)
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			String queryStr = "DELETE FROM clients where CNP=?";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, CNP);
			statement.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Eroare delete clienti." + e.getMessage() );
		}
	}
	
	public ArrayList<Client> listClients()
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			ArrayList<Client> list = new ArrayList<Client>();
			String queryStr = "Select * from clients";
			statement =conn.prepareStatement(queryStr);
			result = statement.executeQuery();
			while(result.next())
			{
				Client c = new Client(result.getString("CNP"),result.getString("nameC"),result.getInt("noCard"), result.getString("address"));
				list.add(c);
			}
			return list;
		}catch(Exception e)
		{
			System.out.print("Eroare listClients.");
			return null;
		}
	}
	
	public Client getClient(String CNP)
    {
		Connection conn =  ConnectionFactory.getConnection();
        try{
            String queryStr="Select * from clients where CNP=?";
            statement=conn.prepareStatement(queryStr);
            statement.setString(1, CNP);
            result=statement.executeQuery();
			result.next();
           
            Client c=null;
           
            
                c=new Client(result.getString("CNP"),result.getString("nameC"),result.getInt("noCard"), result.getString("address"));
            
            return c;
           
        }catch(Exception ex)
        {
            System.out.print("Eroare getClient.");
            LOGGER.log(Level.WARNING,"StudentDAO:findById " + ex.getMessage());
            return null;
        }
    }
}
