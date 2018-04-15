package DataAccess;

import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import Connection.ConnectionFactory;
import model.Rezervation;

public class RezervationData implements RezervationI{
	//private static ConnectionFactory databaseConnection = new ConnectionFactory();
	PreparedStatement statement=null;
	ResultSet result=null;
	private static final String queryStrI = "Insert into rezervation (destination,hotelName,noOfPerson,totalPrice,partialPay,finalPayDate,idClient) values (?,?,?,?,?,?,?)";
	public int insert(Rezervation r)
	{
		Connection conn =  ConnectionFactory.getConnection();
		int insertedId = -1;
		
		try{
		
		
		    
		    statement =conn.prepareStatement(queryStrI, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, r.getDestination());
			statement.setString(2, r.getHotelName());
			statement.setInt(3, r.getNoOfPerson());
			statement.setFloat(4, r.getTotalPrice());
			statement.setFloat(5, r.getPartialPay());
			statement.setDate(6, r.getFinalPayDate());
			statement.setString(7, r.getIdClient());
			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
			
		}catch (Exception sqlException)
		{
			System.out.print("Eroare adauga rez "+ sqlException.getMessage());
		}
		return insertedId;
	}
	public void update(String idClient ,Rezervation r)
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			String queryStr = "UPDATE rezervation SET destination=?,hotelName=? ,noOfPerson=?,totalPrice=?,finalPayDate=?,partialPay =? where idClient=? ";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, r.getDestination());
			statement.setString(2, r.getHotelName());
			statement.setInt(3, r.getNoOfPerson());
			statement.setFloat(4, r.getTotalPrice());
			statement.setDate(5, r.getFinalPayDate());
			statement.setFloat(6, r.getPartialPay());
			statement.setString(7,idClient);
			statement.executeUpdate();
		}catch(Exception sqlException)
		{
			System.out.print("Eroare update rez.");
		}
	}
	
	public void delete(int idRez)
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			String queryStr = "DELETE FROM rezervation where idRez=?";
			statement =conn.prepareStatement(queryStr);
			statement.setInt(1, idRez);
			statement.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("Eroare delete Agent.");
		}
	}
	
	public ArrayList<Rezervation> listRez(String CNP)
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			ArrayList<Rezervation> list = new ArrayList<Rezervation>();
			String queryStr = "Select * from rezervation where idClient=? ";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, CNP);
			result = statement.executeQuery();
			while(result.next())
			{
				Rezervation r = new Rezervation(result.getInt("idRez"),result.getString("idClient"),result.getString("destination"),result.getString("hotelName"), result.getInt("noOfPerson"),result.getDate("finalPayDate"),result.getFloat("totalPrice"),result.getFloat("partialPay"));
				list.add(r);
			}
			return list;
		}catch(Exception e)
		{
			System.out.print("Eroare list rezerv.");
			return null;
		}
	}
	
	public Rezervation getRez(int idRez)
    {
		Connection conn =  ConnectionFactory.getConnection();;
        try{
            String queryStr="Select * from rezervation where idRez=?";
            statement=conn.prepareStatement(queryStr);
            statement.setInt(1, idRez);
            result=statement.executeQuery();
            Rezervation r=null;
            while(result.next())
            {
                r=new Rezervation(result.getInt("idRez"),result.getString("idClient"),result.getString("destination"),result.getString("hotelName"), result.getInt("noOfPerson"),result.getDate("finalPayDate"),result.getFloat("totalPrice"),result.getFloat("partialPay"));
            }
            return r;
           
        }catch(Exception ex)
        {
            System.out.print("Eroare getRez." + ex.getMessage());
            return null;
        }
    }
	public Rezervation partialPay (String CNP,String destination)
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			
			String queryStr = "Select* from rezervation where idClient=? and destination=?";
			statement =conn.prepareStatement(queryStr);
			statement.setString(1, CNP);
			statement.setString(2, destination);
			result = statement.executeQuery();
			result.next();
			Rezervation r =new Rezervation(result.getString("idClient"),result.getString("destination"),result.getString("hotelName"), result.getInt("noOfPerson"),result.getDate("finalPayDate"),result.getFloat("totalPrice"),result.getFloat("partialPay"));
			return r;
		}catch(Exception e)
		{
			System.out.print("Eroare partial pay " + e.getMessage());
			return null;
		}
	}
	public int updatePay(String CNP,String destination,float pay)
	{
		Connection conn =  ConnectionFactory.getConnection();
		int insertedId = -1;
		
		try{
		String queryStr = "update rezervation set partialPay=? where idClient=? and destination=?";
		
		    statement =conn.prepareStatement(queryStr);
			statement.setFloat(1, pay);
			statement.setString(2, CNP);
			statement.setString(3,destination);
            		
			statement.executeUpdate();

			
		}catch (Exception sqlException)
		{
			System.out.print("Eroare adauga rez "+ sqlException.getMessage());
		}
		return insertedId;
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Rezervation> fianlDate()
	{
		Connection conn =  ConnectionFactory.getConnection();
		try{
			ArrayList<Rezervation> list = new ArrayList<Rezervation>();
			String queryStr = "Select * from rezervation where finalPayDate<?";
			statement =conn.prepareStatement(queryStr);
			Date d1= new java.sql.Date(Calendar.getInstance().getTime().getTime());
			statement.setDate(1, d1);;
			result = statement.executeQuery();
			while(result.next())
			{
				Rezervation r = new Rezervation(result.getInt("idRez"),result.getString("idClient"),result.getString("destination"),result.getString("hotelName"), result.getInt("noOfPerson"),result.getDate("finalPayDate"),result.getFloat("totalPrice"),result.getFloat("partialPay"));
				list.add(r);
			}
			return list;
		}catch(Exception e)
		{
			System.out.print("Eroare listAgents.");
			return null;
		}
	}

	

}
