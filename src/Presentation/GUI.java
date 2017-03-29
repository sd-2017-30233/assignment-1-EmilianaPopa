package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DataAccess.Employees;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GUI {

	public JFrame frame;

	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	
			/*public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		


	/**
	 * Create the application.
	 */
	
	public GUI() {
		initialize();
	}
	public JFrame getFrame()
	{
		return this.frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 500, 500);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employees e = new Employees();
				GUIAdmin g1= new GUIAdmin();
				GUIuser g2 = new GUIuser();
				if(e.login(textField.getText(), passwordField.getText())=="Admin")
				{
					g1.getFrame().setVisible(true);
					frame.setVisible(false);
				}
				else
				{
					g2.getFrame().setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnLogIn.setBounds(159, 320, 97, 25);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(67, 184, 123, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(67, 242, 65, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(227, 188, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 243, 116, 22);
		frame.getContentPane().add(passwordField);
	}
}
