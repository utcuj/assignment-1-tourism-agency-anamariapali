package Presentation;

import java.sql.Date;
import java.util.Calendar;

import DataAccess.AgentData;
import DataAccess.ClientData;
import DataAccess.RezervationData;
import business.AgentBll;
import business.HistoryBll;
import business.RezervationBll;
import model.Client;
import model.Rezervation;

public class Test {
	public static void main(String[] args) {
		GUI g= new GUI();
	 //  GUIAdmin ga= new GUIAdmin();
	/*	Client c= new Client("2950711896340","Pop Laura",9,"Cluj-Napoca");
		AgentData a = new AgentData();
		ClientData cd=new ClientData();
		RezervationData d= new RezervationData();
		//cd.insert(c);
		System.out.println(cd.listClients().get(0).getNoCard());
		String s=cd.getClient("2950711896340").getAddress().toString();
		 System.out.println(s);
		 System.out.println(a.listAgents().get(0).getIdAgent());
		 @SuppressWarnings("deprecation")*/
		//Date d1=new java.sql.Date(Calendar.getInstance().getTime().getTime());
	//	 Rezervation r= new Rezervation("2950711896340","cluj","name",9,d1,0,0);
	//	System.out.println( d.getRez(1).getFinalPayDate());
	//	 RezervationBll br= new RezervationBll();
		// RezervationData bd = new RezervationData();
	//br.updatePay("1890726554432", "spania",40);
	//br.acceptPartialPay(40,"1890726554432", "spania");
//	System.out.println(bd.partialPay("1890726554432", "spania").getTotalPrice());
	
	// br.acceptPartialPay(400, "1950123156935", "anglia");
	//@SuppressWarnings("deprecation")
//	Date dy = new Date(2018,06,10);
	//br.addRez("2980716543432", "america", "hotelName", 9,dy, 1220,50);
	// float f= bd.partialPay("2950711896323", "america").getPartialPay();
	//br.acceptPartialPay(40,"1950123156935", "anglia");
	//	System.out.println(bd.partialPay("1950123156935", "anglia").getPartialPay());
	// System.out.println(f);
	//HistoryBll hb = new HistoryBll();
	//Date d11= new Date(2018,02,10);
	//hb.listAgentsHistory(9, d11, dy);
	}
	

}
