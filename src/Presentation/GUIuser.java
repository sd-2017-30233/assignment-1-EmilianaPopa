package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Business.Account;
import Business.ClientManager;
import Business.Clients;
import DataAccess.AccountOp;
import DataAccess.ClientsOp;
import DataAccess.Transaction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUIuser {

	private JFrame frame2;
	private JTextField CNP;
	private JTextField nume;
	private JTextField adresa;
	private JTextField idAcc;
	private JTextField amount;
	private JTextField idAccD;
	private JTextField empl;
	private JTextField factura;

	public JFrame getFrame()
	{
		return this.frame2;
	}
	/**
	 * Create the application.
	 */
	public GUIuser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 567, 389);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblCnpcui = new JLabel("CNP/CUI");
		lblCnpcui.setBounds(12, 43, 56, 16);
		frame2.getContentPane().add(lblCnpcui);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 83, 56, 16);
		frame2.getContentPane().add(lblName);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(12, 123, 56, 16);
		frame2.getContentPane().add(lblAdresa);
		
		CNP = new JTextField();
		CNP.setBounds(105, 40, 116, 22);
		frame2.getContentPane().add(CNP);
		CNP.setColumns(10);
		
		nume = new JTextField();
		nume.setBounds(105, 80, 116, 22);
		frame2.getContentPane().add(nume);
		nume.setColumns(10);
		
		adresa = new JTextField();
		adresa.setBounds(105, 120, 116, 22);
		frame2.getContentPane().add(adresa);
		adresa.setColumns(10);
		
		JLabel lblClientInformation = new JLabel("Client Information");
		lblClientInformation.setBounds(70, 11, 127, 16);
		frame2.getContentPane().add(lblClientInformation);
		
		JLabel lblAccountInformation = new JLabel("Account Information");
		lblAccountInformation.setBounds(378, 11, 135, 16);
		frame2.getContentPane().add(lblAccountInformation);
		
		JLabel lblIdAccount = new JLabel("ID Account");
		lblIdAccount.setBounds(282, 46, 78, 16);
		frame2.getContentPane().add(lblIdAccount);
		
		idAcc = new JTextField();
		idAcc.setBounds(378, 43, 116, 22);
		frame2.getContentPane().add(idAcc);
		idAcc.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(282, 123, 56, 16);
		frame2.getContentPane().add(lblAmount);
		
		amount = new JTextField();
		amount.setBounds(378, 120, 116, 22);
		frame2.getContentPane().add(amount);
		amount.setColumns(10);
		
		JButton btnAddClient = new JButton("Add client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clients c = new Clients(CNP.getText(),nume.getText(),adresa.getText());
				ClientManager cl = new ClientManager();
				cl.addClient(CNP.getText(),nume.getText(),adresa.getText());
			}
		});
		btnAddClient.setBounds(24, 187, 116, 25);
		frame2.getContentPane().add(btnAddClient);
		
		JButton btnDeleteClient = new JButton("Delete client");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientManager cl = new ClientManager();
				cl.deleteClient(CNP.getText());
			}
		});
		btnDeleteClient.setBounds(24, 225, 116, 25);
		frame2.getContentPane().add(btnDeleteClient);
		
		JButton btnUpdateClient = new JButton("Update client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientManager cl = new ClientManager();
				Clients c = new Clients(CNP.getText(),nume.getText(),adresa.getText());
				cl.updateClient(CNP.getText(), nume.getText(),adresa.getText());
			}
		});
		btnUpdateClient.setBounds(24, 263, 116, 25);
		frame2.getContentPane().add(btnUpdateClient);
		
		JButton btnListClient = new JButton("List clients");
		btnListClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientsOp cl = new ClientsOp();
				
				Display d = new Display();
				String s="CNP/CUI      Nume      Adresa "+"\n";
				ArrayList<Clients> list = new ArrayList<Clients>();
				list=cl.listClients();
				frame2.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i).getCNP()+"    "+list.get(i).getName()+"     "+ list.get(i).getAddress()+"    "+"\n";
					
				}
				d.getTextField().setText(s);
			}
		});
		btnListClient.setBounds(24, 301, 116, 25);
		frame2.getContentPane().add(btnListClient);
		
		JButton btnAddAccount = new JButton("Add account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account a = new Account (idAcc.getText(),Float.parseFloat(amount.getText()),CNP.getText());
				AccountOp ap = new AccountOp();
				ap.insert(a);
			}
		});
		btnAddAccount.setBounds(394, 187, 132, 25);
		frame2.getContentPane().add(btnAddAccount);
		
		JButton btnDeleteAccount = new JButton("Delete account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountOp ap = new AccountOp();
				ap.delete(idAcc.getText());
			}
		});
		btnDeleteAccount.setBounds(394, 225, 132, 25);
		frame2.getContentPane().add(btnDeleteAccount);
		
		JButton btnUpdateAccount = new JButton("Update account");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountOp ap = new AccountOp();
				Account a = new Account (idAcc.getText(),Float.parseFloat(amount.getText()),CNP.getText());
				ap.update(idAcc.getText(), a);
			}
		});
		btnUpdateAccount.setBounds(394, 263, 132, 25);
		frame2.getContentPane().add(btnUpdateAccount);
		
		JButton btnListAccounts = new JButton("List accounts");
		btnListAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountOp al = new AccountOp();
				Display d = new Display();
				String s="NrCont      Suma       IDClient"+"\n";
				ArrayList<Account> list = new ArrayList<Account>();
				list=al.listAccounts();
				frame2.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i).getIdAcc()+"    "+list.get(i).getSum()+"     "+ list.get(i).getIdClient()+"    "+"\n";
					
				}
				d.getTextField().setText(s);
			}
		});
		btnListAccounts.setBounds(394, 301, 132, 25);
		frame2.getContentPane().add(btnListAccounts);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI g= new GUI();
				g.getFrame().setVisible(true);
				frame2.setVisible(false);
			}
		});
		btnLogOut.setBounds(198, 301, 140, 25);
		frame2.getContentPane().add(btnLogOut);
		
		JButton btnTransferMoney = new JButton("Transfer money");
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction t = new Transaction();
				String s =t.TransferIntreConturi(idAcc.getText(), idAccD.getText(), Float.parseFloat(amount.getText()), "Transfer bani", Integer.parseInt(empl.getText()));
			System.out.println(s);
			}
		});
		btnTransferMoney.setBounds(198, 249, 140, 25);
		frame2.getContentPane().add(btnTransferMoney);
		
		JButton btnNewButton = new JButton("Process bills");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transaction t = new Transaction();
				if(factura.getText().equals("Electrica"))
				{
						String s =t.TransferIntreConturi(idAcc.getText(), "2923583168", Float.parseFloat(amount.getText()), "Factura electrica", Integer.parseInt(empl.getText()));
						System.out.println(s);
				}
				if(factura.getText().equals("Orange"))
					{
						String s =t.TransferIntreConturi(idAcc.getText(), "2368125588", Float.parseFloat(amount.getText()), "Factura orange", Integer.parseInt(empl.getText()));
						System.out.println(s);
					}
				if (factura.getText().equals("Apa"))
					{
						String s =t.TransferIntreConturi(idAcc.getText(), "9329319298", Float.parseFloat(amount.getText()), "Factura apa", Integer.parseInt(empl.getText()));
						System.out.println(s);
					}
			    if (factura.getText().equals("Gaz"))
					{
						String s =t.TransferIntreConturi(idAcc.getText(), "1711543071", Float.parseFloat(amount.getText()), "Factura gaz", Integer.parseInt(empl.getText()));
						System.out.println(s);
					}
			}
		});
		btnNewButton.setBounds(198, 200, 140, 25);
		frame2.getContentPane().add(btnNewButton);
		
		JLabel lblIdAccountd = new JLabel("ID AccountD");
		lblIdAccountd.setBounds(282, 83, 78, 16);
		frame2.getContentPane().add(lblIdAccountd);
		
		idAccD = new JTextField();
		idAccD.setBounds(378, 80, 116, 22);
		frame2.getContentPane().add(idAccD);
		idAccD.setColumns(10);
		
		JLabel lblIdEmployee = new JLabel("ID Employee");
		lblIdEmployee.setBounds(282, 154, 78, 16);
		frame2.getContentPane().add(lblIdEmployee);
		
		empl = new JTextField();
		empl.setBounds(378, 155, 116, 22);
		frame2.getContentPane().add(empl);
		empl.setColumns(10);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setBounds(12, 158, 56, 16);
		frame2.getContentPane().add(lblFactura);
		
		factura = new JTextField();
		factura.setBounds(105, 152, 116, 22);
		frame2.getContentPane().add(factura);
		factura.setColumns(10);
	}
}
