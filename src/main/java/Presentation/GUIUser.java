package Presentation;





import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import business.ClientBll;
import business.RezervationBll;
import model.Client;
import model.Rezervation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class GUIUser {

	private JFrame frame2;
	private JTextField CNP;
	private JTextField nume;
	private JTextField adresa;
	

	private JTextField numarC;
	private JTextField noPers;
	private JTextField dest;
	private JTextField hotel;
	private JTextField date;
	
	private JTextField pay;
	private JTextField totalP;
	private JTextField IdR;

	public JFrame getFrame()
	{
		return this.frame2;
	}
	/**
	 * Create the application.
	 */
	public GUIUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 800, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		//frame2.setVisible(true);
		JLabel lblCnpcui = new JLabel("CNP");
		lblCnpcui.setBounds(12, 43, 56, 16);
		frame2.getContentPane().add(lblCnpcui);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 83, 56, 16);
		frame2.getContentPane().add(lblName);
		JLabel lblNumarC = new JLabel("NumarCard");
		lblNumarC.setBounds(12, 123, 56, 16);
		frame2.getContentPane().add(lblNumarC);
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(12, 163, 56, 16);
		frame2.getContentPane().add(lblAdresa);
		
		CNP = new JTextField();
		CNP.setBounds(105, 40, 116, 22);
		frame2.getContentPane().add(CNP);
		CNP.setColumns(10);
		
		nume = new JTextField();
		nume.setBounds(105, 80, 116, 22);
		frame2.getContentPane().add(nume);
		nume.setColumns(10);
		
		numarC = new JTextField();
		numarC.setBounds(105, 120, 116, 22);
		frame2.getContentPane().add(numarC);
		numarC.setColumns(10);
		
		adresa = new JTextField();
		adresa.setBounds(105, 160, 116, 22);
		frame2.getContentPane().add(adresa);
		adresa.setColumns(10);
		
		JLabel lblClientInformation = new JLabel("Client Information");
		lblClientInformation.setBounds(70, 11, 127, 16);
		frame2.getContentPane().add(lblClientInformation);
		
		JLabel lblAccountInformation = new JLabel("Holiday Information");
		lblAccountInformation.setBounds(378, 11, 135, 16);
		frame2.getContentPane().add(lblAccountInformation);
		
		JLabel lblIdAccount = new JLabel("Destinatia");
		lblIdAccount.setBounds(282, 46, 78, 16);
		frame2.getContentPane().add(lblIdAccount);
		
		dest = new JTextField();
		dest.setBounds(378, 43, 116, 22);
		frame2.getContentPane().add(dest);
		dest.setColumns(10);
		
		JLabel lblNume = new JLabel("NumeHotel");
		lblNume.setBounds(282, 123, 56, 16);
		frame2.getContentPane().add(lblNume);
		
		hotel = new JTextField();
		hotel.setBounds(378, 120, 116, 22);
		frame2.getContentPane().add(hotel);
		hotel.setColumns(10);
		
		JButton btnAddClient = new JButton("Add client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n= Integer.parseInt(numarC.getText());
				//Client c = new Client(CNP.getText(),nume.getText(),n,adresa.getText());
				ClientBll cb= new ClientBll();
				cb.addClient(CNP.getText(),nume.getText(),n,adresa.getText());
			}
		});
		btnAddClient.setBounds(24, 250, 116, 25);
		frame2.getContentPane().add(btnAddClient);
		
		JButton btnDeleteClient = new JButton("Delete client");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientBll cb= new ClientBll();
				cb.deleteClient(CNP.getText());
			}
		});
		btnDeleteClient.setBounds(24, 290, 116, 25);
		frame2.getContentPane().add(btnDeleteClient);
		
		JButton btnUpdateClient = new JButton("Update client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientBll cb= new ClientBll();
				int n= Integer.parseInt(numarC.getText());
				cb.updateClient(CNP.getText(), nume.getText(), n, adresa.getText());
			}
		});
		btnUpdateClient.setBounds(24, 330, 116, 25);
		frame2.getContentPane().add(btnUpdateClient);
		
		JButton btnListClient = new JButton("List clients");
		btnListClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientBll cb= new ClientBll();
				
				Display d = new Display();
				String s="CNP/CUI      Nume      Adresa "+"\n";
				ArrayList<Client> list = new ArrayList<Client>();
				list=cb.getC();
				//frame2.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i).getCNP()+"    "+list.get(i).getNameC()+"     "+ list.get(i).getNoCard()+"    "+list.get(i).getAddress()+ "\n";
					
				}
				d.getTextField().setText(s);
			}
		});
		btnListClient.setBounds(24, 370, 116, 25);
		frame2.getContentPane().add(btnListClient);
		
		JButton btnAddAccount = new JButton("Add rezervation");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int noP=Integer.parseInt(noPers.getText());
			float pPay= Float.parseFloat(pay.getText());
			
			Date d1 = Date.valueOf(date.getText());
			float totalPrice=Float.parseFloat(totalP.getText());
			
			RezervationBll rb =new RezervationBll(); 
				rb.addRez(CNP.getText(), dest.getText(), hotel.getText(), noP, d1, totalPrice, pPay);
			}
		});
		btnAddAccount.setBounds(394, 390, 132, 25);
		frame2.getContentPane().add(btnAddAccount);
		
		JButton btnDeleteAccount = new JButton("Delete rezervation");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervationBll rb =new RezervationBll(); 
				int idRez= Integer.parseInt(IdR.getText());
				rb.deleteRezervation(idRez);
			}
		});
		btnDeleteAccount.setBounds(394, 430, 132, 25);
		frame2.getContentPane().add(btnDeleteAccount);
		
		JButton btnUpdateAccount = new JButton("Update rezervation");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervationBll rb =new RezervationBll(); 
				int idRez = Integer.parseInt(IdR.getText());
				int noP=Integer.parseInt(noPers.getText());
				float pPay= Float.parseFloat(pay.getText());
				
				Date d1 = Date.valueOf(date.getText());
				float totalPrice=Float.parseFloat(totalP.getText());
				rb.updateRezervation(idRez,CNP.getText(), dest.getText(), hotel.getText(), noP, d1, totalPrice, pPay);
			}
		});
		btnUpdateAccount.setBounds(394, 310, 132, 25);
		frame2.getContentPane().add(btnUpdateAccount);
		
		JButton btnListAccounts = new JButton("List rezervations");
		btnListAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezervationBll rb =new RezervationBll(); 
				Display d = new Display();
				String s="Id      Destinatie       NumeHotel"+"\n";
				ArrayList<Rezervation> list = new ArrayList<Rezervation>();
				list=rb.getR(CNP.getText());
				//frame2.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i).getIdRez()+"    "+list.get(i).getDestination()+"    "+list.get(i).getHotelName()+"     "+ list.get(i).getIdClient()+"    "+list.get(i).getNoOfPerson()+"   " + list.get(i).getPartialPay()+"    "+list.get(i).getTotalPrice()+ "   "+ list.get(i).getFinalPayDate().toString() +"\n";
					
				}
				d.getTextField().setText(s);
			}
		});
		btnListAccounts.setBounds(394, 350, 132, 25);
		frame2.getContentPane().add(btnListAccounts);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI g= new GUI();
				g.getFrame().setVisible(true);
				frame2.setVisible(false);
			}
		});
		btnLogOut.setBounds(198,380,140, 25);
		frame2.getContentPane().add(btnLogOut);
		
		JButton btnTransferMoney = new JButton("PartialPay");
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 RezervationBll rb = new RezervationBll();
			 float pPay= Float.parseFloat(pay.getText());
			int a= rb.acceptPartialPay(pPay, CNP.getText(), dest.getText());
			if(a==0) pay.setText("Data expirata");
			if(a==2) pay.setText("Plata efectuata");			}
		});
		btnTransferMoney.setBounds(198, 420, 140, 25);
		frame2.getContentPane().add(btnTransferMoney);
		
		JButton btnNewButton = new JButton("FinalPaymentDate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RezervationBll rb =new RezervationBll(); 
				Display d = new Display();
				String s="Idrez     Destinatie       IDClient"+"\n";
				ArrayList<Rezervation> list = new ArrayList<Rezervation>();
				list=rb.fianlDate();
				//frame2.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i).getIdRez()+"   "+list.get(i).getDestination()+"    "+list.get(i).getHotelName()+"     "+ list.get(i).getIdClient()+"    "+list.get(i).getNoOfPerson()+"   " + list.get(i).getPartialPay()+"    "+list.get(i).getTotalPrice()+ "   "+ list.get(i).getFinalPayDate().toString() +"\n";
					
				}
				d.getTextField().setText(s);
			}
			
		});
		btnNewButton.setBounds(198, 340, 140, 25);
		frame2.getContentPane().add(btnNewButton);
		
		JLabel lblNP= new JLabel("NumarPersoane");
		lblNP.setBounds(282, 83, 78, 16);
		frame2.getContentPane().add(lblNP);
		
		noPers = new JTextField();
		noPers.setBounds(378, 80, 116, 22);
		frame2.getContentPane().add(noPers);
		noPers.setColumns(10);
		
		JLabel lblDate = new JLabel("FinalPayDate");
		lblDate.setBounds(282, 154, 78, 16);
		frame2.getContentPane().add(lblDate);
		
		date = new JTextField();
		date.setBounds(378, 155, 116, 22);
		frame2.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblPP = new JLabel("PartialPay");
		lblPP.setBounds(282, 194, 78, 16);
		frame2.getContentPane().add(lblPP);
		
		pay = new JTextField();
		pay.setBounds(378, 195, 116, 22);
		frame2.getContentPane().add(pay);
		pay.setColumns(10);
		
		
		JLabel lblTP = new JLabel("TotalPrice");
		lblTP.setBounds(282, 220, 56, 16);
		frame2.getContentPane().add(lblTP);
		
		totalP = new JTextField();
		totalP.setBounds(378, 235, 116, 22);
		frame2.getContentPane().add(totalP);
		totalP.setColumns(10);

		JLabel lblIdR = new JLabel("IDRez");
		lblIdR.setBounds(282, 280, 56, 16);
		frame2.getContentPane().add(lblIdR);
		
		IdR = new JTextField();
		IdR.setBounds(378, 275, 116, 22);
		frame2.getContentPane().add(IdR);
		IdR.setColumns(10);
		
	}
}

