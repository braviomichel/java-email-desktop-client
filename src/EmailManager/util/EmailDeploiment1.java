package EmailManager.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import EmailManager.Beans.Email;
import java.awt.SystemColor;

public class EmailDeploiment1  extends JPanel implements ActionListener  {
	
	private Email email;
	
	private JLabel number = new JLabel();
	private JLabel Subject = new JLabel();
	private JLabel To = new  JLabel();
	private JLabel dateReception = new JLabel();
	private JButton Read = new JButton("Read");
	private JButton Delete = new JButton("Delete");
	

	public EmailDeploiment1(Email email) {
		setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
		this.email = email;
		number.setBounds(31, 29, 77, 23);
		
		
		number.setText("number : "+ email.getNumber());
		Subject.setBounds(30, 63, 101, 20);
		Subject.setText("Subject : "+ email.getSubject());
		To.setBounds(33, 95, 94, 20);
		To.setText("To : "+ email.getReciever());
		dateReception.setBounds(32, 128, 89, 22);
		this.dateReception.setText("Date : " + email.getdateEnvoie());
		setLayout(null);
		add(number);
		add(Subject);
		add(To);
		add(dateReception);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		Read.setForeground(Color.WHITE);
		Read.setBackground(SystemColor.textHighlight);
		Read.setBounds(292, 25, 77, 23);
		add(Read);
		
		Read.addActionListener(this);
		Delete.setForeground(Color.WHITE);
		Delete.setBackground(SystemColor.textHighlight);
		Delete.setBounds(292, 57, 77, 23);
		add(Delete);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public Email getEmail() {
		return email;
	}


	public JLabel getNumber() {
		return number;
	}


	public JLabel getSubject() {
		return Subject;
	}


	public JLabel getTo() {
		return To;
	}


	public JLabel getDateReception() {
		return dateReception;
	}


	public JButton getRead() {
		return Read;
	}


	public JButton getDelete() {
		return Delete;
	}


	public void setEmail(Email email) {
		this.email = email;
	}


	public void setNumber(JLabel number) {
		this.number = number;
	}

	public void setSubject(JLabel subject) {
		Subject = subject;
	}

	public void setFrom(JLabel from) {
		To = from;
	}
	
	public void setDateReception(JLabel dateReception) {
		this.dateReception = dateReception;
	}










	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Read) {
			JOptionPane.showMessageDialog(this, ""+ this.email.getContent());
			
		}
		
	}

}
