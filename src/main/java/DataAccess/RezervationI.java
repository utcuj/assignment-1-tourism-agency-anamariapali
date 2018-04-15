package DataAccess;


import java.util.ArrayList;

import model.Rezervation;

public interface RezervationI {
	
	public Rezervation partialPay (String CNP,String destination);
	public Rezervation getRez(int idRez);
	public ArrayList<Rezervation> listRez(String CNP);
	public void delete(int idAgent);
	public void update(String idClient ,Rezervation r);
	public int updatePay(String CNP,String destination,float pay);
	public ArrayList<Rezervation> fianlDate();
}
