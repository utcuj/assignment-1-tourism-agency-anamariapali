package business;

import java.util.ArrayList;

import DataAccess.AgentData;
import model.Agent;



public class AgentBll {
	 AgentData operation=new AgentData();
	 
	    public void addAgent(String nameA,String address,String telephone,String username,String passwordA,boolean isAdmin)
	    {
	        boolean val= AgentValidator.validateName(nameA);
	      //  boolean val1= AgentValidator.validateAddress(address);
	        boolean  val2= AgentValidator.validatePas(passwordA);
	       // boolean val3=AgentValidator.validateTel(telephone);
	        boolean val4=AgentValidator.validateUser(username);
	        if(val&&val2&&val4)
	        {
	            Agent a=new Agent(nameA,address,telephone,username,passwordA,isAdmin);
	            operation.insert(a);
	        }
	    }
	    
	    public void deleteAgent(int idAgent)
	    {
	       
	            operation.delete(idAgent);
	        
	    }
	    
	    public void updateAgent( int idAgent,String nameA,String address,String telephone,String username,String passwordA,boolean isAdmin)
	    {
	        
	        boolean val= AgentValidator.validateName(nameA);
	       /// boolean val1= AgentValidator.validateAddress(address);
	        boolean  val2= AgentValidator.validatePas(passwordA);
	        boolean val3=AgentValidator.validateTel(telephone);
	        boolean val4=AgentValidator.validateUser(username);
	        if(val&&val2&&val3&&val4)
	        {  Agent a=new Agent(nameA,address,telephone,username,passwordA,isAdmin);
	            operation.update(idAgent, a);}
	        
	    }
	    
	    public ArrayList<Agent> getA()
	    {
	        return operation.listAgents();
	    }
	    
	    public Agent getA(int idAgent)
	    {return operation.getAgent(idAgent);
	    }
	    public String login(String password,String userName )
	    { 
	    	return operation.login(userName, password);
	    	
	    }
}
