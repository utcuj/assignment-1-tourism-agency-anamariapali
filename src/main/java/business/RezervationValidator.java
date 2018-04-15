package business;

import java.util.Date;

public class RezervationValidator {
	public static boolean validatePrice(float sum)
	{
		if(sum<0)
			return false;
		return true;
	}
	public static boolean validate(Date d1,Date d2)
    {
        if(d2.compareTo(d1)==1)
        	return true;
        return false;
    }
	public static boolean validatePartial(float sum)
	{
		if(sum<0)
			return false;
		return true;
	}
	
}
