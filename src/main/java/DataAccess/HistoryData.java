package DataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

import model.History;


public class HistoryData  implements HistoryI{
	protected static final Logger LOGGER = Logger.getLogger(AgentData.class.getName());
	
	//private static ConnectionFactory databaseConnection = new ConnectionFactory();
	PreparedStatement statement=null;
	ResultSet result=null;

	public int insert(History h) {
		
			
			Connection conn =  ConnectionFactory.getConnection();
			int insertedId = -1;
			String queryStr = "Insert into history (idAgent,dataH,activity) values (?,?,?)";
			try{
				 statement =conn.prepareStatement(queryStr, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, h.getIdAgent());
				statement.setDate(2,h.getData());
				statement.setString(3, h.getActivity());
				
				statement.executeUpdate();

				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					insertedId = rs.getInt(1);
				}
				
			}catch (Exception e) {
			LOGGER.log(Level.WARNING, "hstory:insert " + e.getMessage());
		} 
			return insertedId;
		}
	public ArrayList<History> listAgentsHistory(int idAgent, Date d1 , Date d2) {
		Connection conn =  ConnectionFactory.getConnection();
		try{
			ArrayList<History> list = new ArrayList<History>();
			String queryStr = "Select * from history where idAgent=? and dataH between ? and ?";
			statement =conn.prepareStatement(queryStr);
			statement.setInt(1,idAgent);
			statement.setDate(2, d1);
			statement.setDate(3, d2);
			result = statement.executeQuery();
			while(result.next())
			{
				History h = new History(result.getInt("idHistory"),result.getInt("idAgent"),result.getDate("dataH"),result.getString("activity"));
				list.add(h);
			}
			return list;
		}catch(Exception e)
		{
			LOGGER.log(Level.WARNING, "hstoryAgents:insert " + e.getMessage());
			return null;
		}
	}

	public History getAgentHistory(int idAgent) {
		// TODO Auto-generated method stub
		return null;
	}

}
