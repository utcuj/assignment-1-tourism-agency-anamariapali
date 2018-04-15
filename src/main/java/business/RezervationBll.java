package business;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;



import DataAccess.RezervationData;
import model.Rezervation;

public class RezervationBll {
	RezervationData operation=new RezervationData();
    public void addRez(String idClient, String destination,String hotelName,int noOfperson,Date finalPayDate,float totalPrice,float partialPay)
    {
        boolean validate= ClientValidator.validate(idClient);
        if(validate == true)
        {
            Rezervation r=new Rezervation( idClient,destination,hotelName,noOfperson,finalPayDate,totalPrice,partialPay);
            operation.insert(r);
        }
    }
    
    public void deleteRezervation(int id)
    {   
            operation.delete(id);
    }
    
   public void updateRezervation( int idRez ,String idClient,  String destination,String hotelName,int noOfperson,Date finalPayDate,float totalPrice,float partialPay)
    {
        boolean validate=ClientValidator.validate(idClient);
        if(validate==true && RezervationValidator.validatePrice(totalPrice))
        {
            Rezervation r= new Rezervation(  idRez,idClient,destination,hotelName,noOfperson,finalPayDate,totalPrice,partialPay);
            operation.update(idClient, r);
        }
    }
    
    public ArrayList<Rezervation> getR(String CNP)
    {
        return operation.listRez(CNP);
    }
    
    public Rezervation getAs(int id)
    {
            return operation.getRez(id);
       
    }
    public int acceptPartialPay(float pay,String CNP, String destination ) {
    	Date d=new java.sql.Date(Calendar.getInstance().getTime().getTime());
    	Rezervation r= operation.partialPay(CNP, destination);
    	float sum =0;
    	if(d.before(r.getFinalPayDate()))
    		
    	{	if(r.getTotalPrice()>r.getPartialPay())
    	 { sum =r.getPartialPay()+ pay;
    	  operation.updatePay(CNP, destination, sum);
    	  return 1;
    	  }
    	return 2;
    	
    	}
    	  
    	return 0;
    }
    public ArrayList<Rezervation> fianlDate(){
    	return operation.fianlDate();
    }

}
