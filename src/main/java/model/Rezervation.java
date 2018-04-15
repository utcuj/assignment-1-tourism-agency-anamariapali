package model;

import java.sql.Date;
//import java.util.Date;
public class Rezervation {
	private int idRez;
	private String idClient;
	private String destination;
	private String hotelName;
	private int noOfPerson;
	private Date finalPayDate;
	private float partialPay;

	public float getPartialPay() {
		return partialPay;
	}
	public void setPartialPay(float partialPay) {
		this.partialPay = partialPay;
	}
	private float totalPrice;
	
	public Rezervation(int idRez, String idClient, String destination, String hotelName, int noOfPerson,
			Date finalPayDate, float totalPrice,float partialPay) {
		super();
		this.idRez = idRez;
		this.idClient = idClient;
		this.destination = destination;
		this.hotelName = hotelName;
		this.noOfPerson = noOfPerson;
		this.finalPayDate = finalPayDate;
		this.totalPrice = totalPrice;
		this.partialPay= partialPay;
	}
	public Rezervation(String CNP, String destination, String hotelName, int noOfPerson,
			Date finalPayDate, float totalPrice,float partialPay) {
		super();
		this.idClient = CNP;
		
		this.destination = destination;
		this.hotelName = hotelName;
		this.noOfPerson = noOfPerson;
		this.finalPayDate = finalPayDate;
		this.totalPrice = totalPrice;
		this.partialPay = partialPay;
	}
	public int getIdRez() {
		return idRez;
	}
	public void setIdRez(int idRez) {
		this.idRez = idRez;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getNoOfPerson() {
		return noOfPerson;
	}
	public void setNoOfPerson(int noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	public Date getFinalPayDate() {
		return finalPayDate;
	}
	public void setFinalPayDate(Date finalPayDate) {
		this.finalPayDate = finalPayDate;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	

}
