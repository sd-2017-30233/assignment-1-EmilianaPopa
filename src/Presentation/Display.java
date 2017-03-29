package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.TextField;
import javax.swing.JTextArea;

public class Display {

	private JFrame frame;
	private JTextArea textArea;
	
	public JTextArea getTextField(){
		return this.textArea;
	}
	public JFrame getFrame(){
		return this.frame;
	}
	
	

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 13, 829, 460);
		frame.getContentPane().add(textArea);
		
	}
}
