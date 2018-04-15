package DataAccess;

import java.util.ArrayList;

import model.Agent;

public interface AgentI {
	public int insert(Agent a);
	public void update(int idAgent, Agent a);
	public ArrayList<Agent> listAgents();
	public Agent getAgent(int idAgent);
	public String login (String userName ,String password);
}
