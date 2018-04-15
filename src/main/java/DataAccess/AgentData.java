package DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

import model.Agent;

public class AgentData implements AgentI {
	
	private final static String queryStrI = "Insert into agents (nameA,address,telephon,username,passwordA,isAdmin) values (?,?,?,?,?,?)";
	
	protected static final Logger LOGGER = Logger.getLogger(AgentData.class.getName());
	
		//private static ConnectionFactory databaseConnection = new ConnectionFactory();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		public int insert(Agent a)
		{
			Connection conn =  ConnectionFactory.getConnection();
			int insertedId = -1;
			
			try{
				statement =conn.prepareStatement(queryStrI, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, a.getNameA());
				statement.setString(2, a.getAddress());
				statement.setString(3, a.getTelephone());
				statement.setString(4, a.getUsername());
				statement.setString(5, a.getPasswordA());
				statement.setBoolean(6, a.isAdmin());
				statement.executeUpdate();

				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					insertedId = rs.getInt(1);
				}
				
			}catch (Exception e) {
			LOGGER.log(Level.WARNING, "agent insert:insert " + e.getMessage());
		} 
			return insertedId;
		}
		public void update(int idAgent, Agent a)
		{
			Connection conn =  ConnectionFactory.getConnection();
			try{
				String queryStr = "UPDATE agents SET numeA=?,address=? ,telephon=?,username=?,passwordA=?,isAdmin=? where idAgent=?";
				statement =conn.prepareStatement(queryStr);
				statement.setString(1, a.getNameA());
				statement.setString(2, a.getAddress());
				statement.setString(3, a.getTelephone());
				statement.setString(4, a.getUsername());
				statement.setString(5, a.getPasswordA());
				statement.setBoolean(6, a.isAdmin());
				statement.executeUpdate();
			}catch(Exception sqlException)
			{
				System.out.print("Eroare update Agent.");
			}
		}
		
		public void delete(int idAgent)
		{
			Connection conn =  ConnectionFactory.getConnection();
			try{
				String queryStr = "DELETE FROM agentss where idAgent=?";
				statement =conn.prepareStatement(queryStr);
				statement.setInt(1, idAgent);
				statement.executeUpdate();
			}catch(Exception e)
			{
				System.out.print("Eroare delete Agent.");
			}
		}
		
		public ArrayList<Agent> listAgents()
		{
			Connection conn =  ConnectionFactory.getConnection();
			try{
				ArrayList<Agent> list = new ArrayList<Agent>();
				String queryStr = "Select * from agents";
				statement =conn.prepareStatement(queryStr);
				result = statement.executeQuery();
				while(result.next())
				{
					Agent a = new Agent(result.getInt("idAgent"),result.getString("nameA"),result.getString("address"), result.getString("telephon"),result.getString("username"),result.getString("passwordA"),result.getBoolean("isAdmin"));
					list.add(a);
				}
				return list;
			}catch(Exception e)
			{
				System.out.print("Eroare listAgents."+ e.getMessage());
				return null;
			}
		}
		
		public Agent getAgent(int idAgent)
	    {
			Connection conn =  ConnectionFactory.getConnection();
	        try{
	            String queryStr="Select * from agents where idAgent=?";
	            statement=conn.prepareStatement(queryStr);
	            statement.setInt(1, idAgent);
	            result=statement.executeQuery();
	            Agent a=null;
	           result.next();
	          
	                a=new Agent(result.getInt("idAgent"),result.getString("nameA"),result.getString("address"), result.getString("telephon"),result.getString("usernameA"),result.getString("passwordA"),result.getBoolean("isAdmin"));;
	            
	            return a;
	           
	        }catch(Exception ex)
	        {
	            System.out.print("Eroare getAgent.");
	            return null;
	        }
	    }
		
		public String login (String userName ,String password)
		{
			Connection conn =  ConnectionFactory.getConnection();
			
			try{
		          String sql="select * from agents  where username=? AND passwordA=?";
		          statement=conn.prepareStatement(sql);
		          statement.setString(1, userName);
		          statement.setString(2, password);
		          result=statement.executeQuery();
		          while(result.next())
		          {
		              if(result.getBoolean("isAdmin")==true) return "Admin";
		              else return "Regular";
		          }
		        }catch(Exception ex){
		        	LOGGER.log(Level.WARNING, "login " + ex.getMessage());
		            return "Eroare";
		        }
		        return "Date gresite";
		    }
		}
		
	


