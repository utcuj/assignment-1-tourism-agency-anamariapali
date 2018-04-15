package business;


import java.sql.Date;
import java.util.ArrayList;

import DataAccess.HistoryData;
import model.History;

public class HistoryBll {
	 HistoryData operation=new HistoryData();
	    public void addHistory(History h)
	    {
	        operation.insert(h);
	    }
	    public ArrayList<History> listAgentsHistory(int idAgent, Date d1 , Date d2)
	    {
	    	return operation.listAgentsHistory(idAgent, d1, d2);
	    	
	    }
     
}
