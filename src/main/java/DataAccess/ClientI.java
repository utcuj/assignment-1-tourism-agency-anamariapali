package DataAccess;

import java.util.ArrayList;

import model.Client;

public interface ClientI {
	public void insert(Client c);
	public void update(String CNP, Client c);
	public void delete(String CNP);
	
	public ArrayList<Client> listClients();
	public Client getClient(String CNP);

}
