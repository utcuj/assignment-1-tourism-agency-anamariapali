package DataAccess;

import java.sql.Date;
import java.util.ArrayList;


import model.History;

public interface HistoryI {
	public int insert(History h);
	
	public ArrayList<History> listAgentsHistory(int idAgent, Date d1,Date d2);
//	public History getAgentHistory(int idAgent);
	
}
