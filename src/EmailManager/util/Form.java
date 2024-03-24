package EmailManager.util;

//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import EmailManager.Beans.User;
import EmailManager.Dao.UserDaoImp;
import EmailManager.service.UserControler;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;


//import EmailManager.LauchPage;


public class Form extends JFrame implements ActionListener {
	
	private UserDaoImp dao;
	private UserControler uc;
	
	JFrame frame = new JFrame("EmailManager");
    JLabel userLabel = new JLabel("Email");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");

	public Form() {
		// TODO Auto-generated constructor stub		
		dao = new UserDaoImp();
		uc = new UserControler(dao);
		
		JLabel text = new JLabel(" Login "); 
		text.setForeground(Color.GRAY);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setBackground(Color.WHITE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rrach\\eclipse-workspace\\EmailManager\\ressources\\images\\icon.png"));
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setBounds(30, 10, 500, 500);
        text.setBounds(240, 70, 50, 50);
        frame.getContentPane().add(text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationAndSize();
        addComponentsTothis();
        addActionEvent();
	}
	
	
	 public void setLocationAndSize() {
	        userLabel.setForeground(Color.GRAY);
	        userLabel.setBounds(110, 150, 105, 30);
	        passwordLabel.setForeground(Color.GRAY);
	        passwordLabel.setBounds(110, 220, 105, 30);
	        userTextField.setBounds(210, 150, 150, 30);
	        passwordField.setBounds(210, 220, 150, 30);
	        showPassword.setForeground(Color.GRAY);
	        showPassword.setBackground(Color.WHITE);
	        showPassword.setBounds(210, 257, 150, 30);
	        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        loginButton.setForeground(Color.WHITE);
	        loginButton.setBackground(SystemColor.textHighlight);
	        loginButton.setBounds(139, 340, 100, 30);
	        resetButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        resetButton.setForeground(Color.WHITE);
	        resetButton.setBackground(SystemColor.textHighlight);
	        resetButton.setBounds(289, 340, 100, 30);

	    }

	    public void addComponentsTothis() {
	    	
	        this.frame.getContentPane().add(userLabel);
	        this.frame.getContentPane().add(passwordLabel);
	        this.frame.getContentPane().add(userTextField);
	        this.frame.getContentPane().add(passwordField);
	        this.frame.getContentPane().add(showPassword);
	        this.frame.getContentPane().add(loginButton);
	        this.frame.getContentPane().add(resetButton);
	    }

	    public void addActionEvent() {
	        loginButton.addActionListener(this);
	        resetButton.addActionListener(this);
	        showPassword.addActionListener(this);
	    }


	    @SuppressWarnings("deprecation")
		@Override
	    public void actionPerformed(ActionEvent e) {
	        //Coding Part of LOGIN button
	        if (e.getSource() == loginButton) {           	        		        	
	        	
	            if (userTextField.getText().equalsIgnoreCase("") && passwordField.getText().equalsIgnoreCase("")) {
	                JOptionPane.showMessageDialog(this, "Please enter your informations");
	            }
	            
	            else {
	            	
	            	
	            	if(uc.login( new User(userTextField.getText().toString().trim(),passwordField.getText().toString())) != null) {
	            		
	            		 //new CheckPass();
	            		
	            		// new Home();
	            		 new Home(uc.login( new User(userTextField.getText().toString().trim(),passwordField.getText().toString())));
	            	}
	            	else {
	            		
	            		System.out.println("user Doesn't exist !");
	            		JOptionPane.showMessageDialog(this,"Check with your manager!");
	            	}
	            		            		            		            		            		           
	            	userTextField.setText("");
                    passwordField.setText("");
	                 	                
	            }	
	        }
	        
	        //Coding Part of RESET button
	        if (e.getSource() == resetButton) {
	            userTextField.setText("");
	            passwordField.setText("");
	        }
	        
	       //Coding Part of showPassword JCheckBox
	        if (e.getSource() == showPassword) {
	            if (showPassword.isSelected()) {
	                passwordField.setEchoChar((char) 0);
	            } else {
	                passwordField.setEchoChar('*');
	            }
	        }

	    }	    	   
}
	    