package model;

public class Agent {
	private int idAgent;
	private String nameA;
	private String address;
	private String telephone;
	private String username ;
	private String passwordA;
	private boolean isAdmin;
	
	public Agent(int idAgent, String nameA, String address, String telephone, String username, String passwordA,boolean isAdmin) {
		
		this.idAgent = idAgent;
		this.nameA = nameA;
		this.address = address;
		this.telephone = telephone;
		this.username = username;
		this.passwordA = passwordA;
		this.isAdmin = isAdmin;
	}
	public Agent(String nameA, String address, String telephone, String username, String passwordA,boolean isAdmin) {
		
		
		this.nameA = nameA;
		this.address = address;
		this.telephone = telephone;
		this.username = username;
		this.passwordA = passwordA;
		this.isAdmin = isAdmin;
	}
	
	public int getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}
	public String getNameA() {
		return nameA;
	}
	public void setNameA(String nameA) {
		this.nameA = nameA;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswordA() {
		return passwordA;
	}
	public void setPasswordA(String passwordA) {
		this.passwordA = passwordA;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
