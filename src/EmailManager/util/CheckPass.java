package EmailManager.util;

import java.awt.Font;


import javax.swing.*;
import java.awt.Color;
import java.awt.SystemColor;

//import EmailManager.service.InboxControler;

public class CheckPass extends JPanel  {
	
	//private InboxInterface inobx = new InboxInterface();
	
	private JLabel title = new JLabel("Login to your Gmail  ");
	private JLabel passwordLabel = new JLabel("enter your password ");
	private JPasswordField passwordField = new JPasswordField();
	JButton btn = new JButton("submit");

	public CheckPass() {
		setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
		
		
		//setVisible(true);
		setBounds(80, 40, 300, 300);
		setLayout(null);
		title.setBounds(3, 0, 259, 37);
		
		title.setFont(new Font("Serif", Font.BOLD, 24));
		add(title);
		passwordLabel.setForeground(Color.GRAY);
		passwordLabel.setBounds(10, 80, 116, 29);
		//passwordField.setBounds(210, 220, 150, 30);
		add(passwordLabel);
		passwordField.setBounds(10, 120, 249, 37);
		add(passwordField);
		btn.setForeground(Color.WHITE);
		btn.setBackground(SystemColor.textHighlight);
		btn.setBounds(81, 190, 116, 29);
		add(btn);
		
		
		
	
		
	}
	

	
	
	
	 
//	public InboxInterface getInobx() {
//		return inobx;
//	}
//
//
//	public void setInobx(InboxInterface inobx) {
//		this.inobx = inobx;
//	}






	public JPasswordField getPasswordField() {
		return passwordField;
	}






	public JButton getBtn() {
		return btn;
	}






	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}






	public void setBtn(JButton btn) {
		this.btn = btn;
	}


		
	
	

}
