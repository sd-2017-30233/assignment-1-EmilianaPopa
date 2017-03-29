package Presentation;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import Business.Account;
import DataAccess.Employees;
import DataAccess.Transaction;

import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class GUIAdmin {

	private  JFrame frame1;
	private JTextField adresa_1;
	private JTextField telefon_1;
	private JTextField username_1;
	private JTextField parola_1;
	private JTextField isAdmin;
	private JTextField nume_1;
	private JTextField idempl;
	
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
		
		JButton btnAddAccount = new JButton("Add employee");
	
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employees e = new Employees();
				
				if(Integer.parseInt(isAdmin.getText())==0)
					e.insert(nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), false);
				else
					e.insert(nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), true);
			}
		});
		btnAddAccount.setBounds(41, 324, 136, 25);
		frame1.getContentPane().add(btnAddAccount);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 32, 78, 16);
		frame1.getContentPane().add(lblNewLabel);
		
		JLabel lblAdresa = new JLabel("Adress");
		lblAdresa.setBounds(41, 86, 56, 16);
		frame1.getContentPane().add(lblAdresa);
		
		JLabel lblTelefon = new JLabel("Phone");
		lblTelefon.setBounds(41, 130, 56, 16);
		frame1.getContentPane().add(lblTelefon);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 175, 78, 16);
		frame1.getContentPane().add(lblUsername);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setBounds(41, 218, 56, 16);
		frame1.getContentPane().add(lblParola);
		
		JLabel lblAdminnonadmin = new JLabel("Admin/NonAdmin");
		lblAdminnonadmin.setBounds(41, 264, 115, 16);
		frame1.getContentPane().add(lblAdminnonadmin);
		
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
		
		nume_1 = new JTextField();
		nume_1.setBounds(188, 29, 116, 22);
		frame1.getContentPane().add(nume_1);
		nume_1.setColumns(10);

		JButton btnDeleteEmployee = new JButton("Delete employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employees e = new Employees();
				e.delete(idempl.getText());
			}
		});
		btnDeleteEmployee.setBounds(41, 385, 136, 25);
		frame1.getContentPane().add(btnDeleteEmployee);
		
		JButton btnListEmployee = new JButton("List employee");
		btnListEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display d = new Display();
				String s="ID      Nume      Adresa       Telefon      Username       idAdmin"+"\n";
				Employees empl=new Employees();
				ArrayList<String> list = new ArrayList<String>();
				list= empl.listEmployees();
				frame1.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i)+"    "+"\n";
					
				}
				d.getTextField().setText(s);
			}
		});
		btnListEmployee.setBounds(219, 324, 131, 25);
		frame1.getContentPane().add(btnListEmployee);
		
		JButton btnUpdateEmployee = new JButton("Update employee");
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employees em =new Employees();
				if(Integer.parseInt(isAdmin.getText())==0)
					em.update(Integer.parseInt(idempl.getText()),nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), false);
				else
					em.update(Integer.parseInt(idempl.getText()),nume_1.getText(),adresa_1.getText(), telefon_1.getText(), username_1.getText(), parola_1.getText(), true);
			}
		});
		btnUpdateEmployee.setBounds(219, 385, 131, 25);
		frame1.getContentPane().add(btnUpdateEmployee);
		
		JButton btnGenerateReport = new JButton("Generate report");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Transaction t= new Transaction();
				Display d = new Display();
				String s="IDTranz      ContS       ContD       Data        Suma      Descriere"+"\n";
				ArrayList<String> list = new ArrayList<String>();
				list=t.listTransactions(Integer.parseInt(idempl.getText()));
				frame1.setVisible(false);
				d.getFrame().setVisible(true);
				for(int i = 0; i < list.size(); i++) {   
					s=s+list.get(i)+"    "+"\n";
					
				}
				d.getTextField().setText(s);
			}
		});
		btnGenerateReport.setBounds(443, 196, 131, 25);
		frame1.getContentPane().add(btnGenerateReport);
		
		JLabel lblIdEmployee = new JLabel("ID employee");
		lblIdEmployee.setBounds(390, 130, 83, 16);
		frame1.getContentPane().add(lblIdEmployee);
		
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
		frame1.getContentPane().add(btnLogOut);
		
		
	}
	
}
