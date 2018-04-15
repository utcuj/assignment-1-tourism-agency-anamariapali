package model;

public class Client {
private String CNP;
private String nameC;
private int noCard;
private String  address;
public String getCNP() {
	return CNP;
}
public Client(String cNP, String nameC, int noCard, String address) {
	super();
	CNP = cNP;
	this.nameC = nameC;
	this.noCard = noCard;
	this.address = address;
}
public void setCNP(String cNP) {
	CNP = cNP;
}
public String getNameC() {
	return nameC;
}
public void setNameC(String nameC) {
	this.nameC = nameC;
}
public int getNoCard() {
	return noCard;
}
public void setNoCard(int noCard) {
	this.noCard = noCard;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
