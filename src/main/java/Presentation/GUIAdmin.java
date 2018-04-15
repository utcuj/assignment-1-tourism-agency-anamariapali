package Presentation;



import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


import business.AgentBll;
import business.HistoryBll;
import model.Agent;
import model.History;

import javax.swing.JTextField;

import java.util.Date;
public class GUIAdmin {

	private  JFrame frame1;

	private JTextField adresa_1;
	private JTextField telefon_1;
	private JTextField username_1;
	private JTextField parola_1;
	private JTextField isAdmin;
	private JTextField nume_1;
	private JTextField idempl;
	
	private  JTextField d1;
	private  JTextField d2;

	private JTextField activity;
	
	public JFrame getFrame()
	{
		return this.frame1;
	}
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAdmin window = new GUIAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the application.
	 */
	public GUIAdmin() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 692, 482);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		//frame1.setVisible(true);
		
		JButton btnAddAccount = new JButton("Add agent");
	
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgentBll a= new AgentBll();
				if(Integer.parseInt(isAdmin.getText())==0)
					{System.out.println(nume_1.getText() + adresa_1.getText()+telefon_1.getText()+ username_1.getText()+parola_1.getText());
					a.addAgent(nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), false);}
				else
					a.addAgent(nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), true);
			}
		});
		btnAddAccount.setBounds(443, 230, 136, 25);
		frame1.getContentPane().add(btnAddAccount);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 32, 78, 16);
		frame1.getContentPane().add(lblNewLabel);
		
	
		
		JLabel lblAdresa = new JLabel("Adress");
		lblAdresa.setBounds(41, 83, 56, 16);
		frame1.getContentPane().add(lblAdresa);
		
		JLabel lblTelefon = new JLabel("Phone");
		lblTelefon.setBounds(41, 127, 56, 16);
		frame1.getContentPane().add(lblTelefon);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 172, 78, 16);
		frame1.getContentPane().add(lblUsername);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(41, 215, 56, 16);
		frame1.getContentPane().add(lblParola);
		
		JLabel lblAdminnonadmin = new JLabel("Admin/NonAdmin");
		lblAdminnonadmin.setBounds(41, 264, 115, 16);
		frame1.getContentPane().add(lblAdminnonadmin);
		
		nume_1 = new JTextField();
		nume_1.setBounds(188, 29, 116, 22);
		frame1.getContentPane().add(nume_1);
		nume_1.setColumns(10);
		
		adresa_1 = new JTextField();
		adresa_1.setBounds(188, 83, 116, 22);
		frame1.getContentPane().add(adresa_1);
		adresa_1.setColumns(10);
		
		telefon_1 = new JTextField();
		telefon_1.setBounds(188, 127, 116, 22);
		frame1.getContentPane().add(telefon_1);
		telefon_1.setColumns(10);
		
		username_1 = new JTextField();
		username_1.setBounds(188, 172, 116, 22);
		frame1.getContentPane().add(username_1);
		username_1.setColumns(10);
		
		parola_1 = new JTextField();
		parola_1.setBounds(188, 215, 116, 22);
		frame1.getContentPane().add(parola_1);
		parola_1.setColumns(10);
		
		isAdmin = new JTextField();
		isAdmin.setBounds(188, 261, 116, 22);
		frame1.getContentPane().add(isAdmin);
		isAdmin.setColumns(10);
		
		
		
		
		
		JLabel lbld1 = new JLabel("d1/activity");
		lbld1.setBounds(41, 330, 56, 16);
		frame1.getContentPane().add(lbld1);
		JLabel lbld2 = new JLabel("d2");
		lbld2.setBounds(41, 360, 56, 16);
		frame1.getContentPane().add(lbld2);

		d1 = new JTextField();
		d1.setBounds(188, 330, 116, 22);
		frame1.getContentPane().add(d1);
		d1.setColumns(10);
		
		d2= new JTextField();
		d2.setBounds(188, 360, 116, 22);
		frame1.getContentPane().add(d2);
		d2.setColumns(10);
		
		
		
		JButton btnListEmployee = new JButton("List agents");
		btnListEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Display d = new Display();
			String s="ID      Nume      idAgent      Telefon      Username       idAdmin"+"\n";
				AgentBll a= new AgentBll();
			ArrayList<Agent> list = new ArrayList<Agent>();
				list= a.getA();
				//frame1.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i).getNameA()+"    "+ list.get(i).getIdAgent() +"\n";
					
				}
		d.getTextField().setText(s);
			}
		});
		btnListEmployee.setBounds(443, 260, 131, 25);
		frame1.getContentPane().add(btnListEmployee);
		
		JButton btnUpdateEmployee = new JButton("Update agents");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgentBll a= new AgentBll();
				if(Integer.parseInt(isAdmin.getText())==0)
					a.updateAgent(Integer.parseInt(idempl.getText()),nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), false);
				else
					a.updateAgent(Integer.parseInt(idempl.getText()),nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), true);
			}
		});
		btnUpdateEmployee.setBounds(219, 385, 131, 25);
		frame1.getContentPane().add(btnUpdateEmployee);
		
		JButton btnGenerateReport = new JButton("Generate report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HistoryBll hb= new HistoryBll();
				Display d = new Display();
				String s="Activitate"+"\n";
				ArrayList<History> list = new ArrayList<History>();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				
				Date d22,d11;
				try {
					d22 = format.parse(d2.getText());
					 d11 = format.parse(d1.getText());
					  java.sql.Date sql2 = new java.sql.Date(d22.getTime());
				        java.sql.Date sql1 = new java.sql.Date(d11.getTime());
				       // System.out.println(sql2+" "+ sql1);
						list=hb.listAgentsHistory(Integer.parseInt(idempl.getText()),sql1, sql2);
						d.getFrame().setVisible(true);
						for(int i = 0; i < list.size(); i++) {   
							s=s+list.get(i).getActivity()+"    "+"\n";}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		      
				//frame1.setVisible(false);
				
					
				
				d.getTextField().setText(s);
			}
		});
		btnGenerateReport.setBounds(443, 196, 131, 25);
		frame1.getContentPane().add(btnGenerateReport);
		
		JLabel lblIdAgent = new JLabel("ID Agent");
		lblIdAgent.setBounds(390, 130, 83, 16);
		frame1.getContentPane().add(lblIdAgent);
		
		JLabel lblAc = new JLabel("Activity");
		lblAc.setBounds(390, 160, 83, 16);
		frame1.getContentPane().add(lblAc);
		
		idempl = new JTextField();
		idempl.setBounds(482, 127, 116, 22);
		frame1.getContentPane().add(idempl);
		idempl.setColumns(10);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI g= new GUI();
				g.getFrame().setVisible(true);
				frame1.setVisible(false);
			}
		});
		btnLogOut.setBounds(471, 354, 97, 25);
		
		
		
		

		activity = new JTextField();
		activity.setBounds(482, 160, 116, 22);
		frame1.getContentPane().add(activity);
		activity.setColumns(10);
		
		JButton btnAddH = new JButton("Add Activity");
		btnAddH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {	HistoryBll hb=new HistoryBll();
				int i =Integer.parseInt(idempl.getText());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d11;
				 d11 = format.parse(d1.getText());
				
			    java.sql.Date sql1 = new java.sql.Date(d11.getTime());
				History h = new History(i,sql1,activity.getText());
				hb.addHistory(h);
			}catch(ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnAddH.setBounds(443, 290, 131, 25);
		frame1.getContentPane().add(btnAddH);
		
		
	}
	}
	

