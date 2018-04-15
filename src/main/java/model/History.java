package model;

import java.sql.Date;

public class History {
	private int idHistory;
	
	private int idAgent;
	private String activity;
	private Date dataH;
	public History(int idAgent, Date data,String activity) {
		super();
		this.idAgent = idAgent;
		this.dataH = data;
		this.activity=activity;
	}
	public History(int idHistory, int idAgent, Date data,String activity) {
		super();
		this.idHistory = idHistory;
		this.idAgent = idAgent;
		this.dataH = data;
		this.activity=activity;
	}
	
	public int getIdHistory() {
		return idHistory;
	}
	public void setIdHistory(int idHistory) {
		this.idHistory = idHistory;
	}
	public int getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getData() {
		return dataH;
	}
	public void setData(Date data) {
		this.dataH = data;
	}
	
	

}
