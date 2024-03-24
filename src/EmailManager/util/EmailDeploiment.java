package EmailManager.util;

import java.awt.BorderLayout;
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

import EmailManager.Beans.Archive;
import EmailManager.Beans.MessageEmail;
import EmailManager.Beans.User;
import EmailManager.service.InboxControler;
import EmailManager.service.InboxControlerImpl;

import java.awt.SystemColor;
import java.awt.Font;


public class EmailDeploiment extends JPanel implements ActionListener {				

	//modif

	private InboxControler  ic;
	User u; 
	
	private MessageEmail m;
	private JButton Read = new JButton("Read");
	private JButton Archive = new JButton("Archive");
	private JButton Delete = new JButton("Delete");
	private final JLabel number = new JLabel("Number  : ");
	private final JLabel Subject = new JLabel("Subject : ");
	private final JLabel From = new JLabel("From : ");
	private final JLabel dateReception = new JLabel("Date Receprion :");
	
	
	
	
	public EmailDeploiment() {		
		
		setBackground(Color.WHITE);
		ic = new InboxControlerImpl(u);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		number.setBounds(16, 30, 140, 28);
		add(number);
		
		Subject.setBounds(16, 69, 140, 28);
		add(Subject);
		
		From.setBounds(16, 98, 140, 28);		
		add(From);
		
		dateReception.setBounds(16, 137, 101, 23);		
		add(dateReception);
		
		addActionEvent();
		
	}

	public EmailDeploiment(User u,MessageEmail m) {
		
		this();
		this.m = m;			
		this.number.setText("number : "+ m.getNumber());
		Subject.setText("Subject : "+m.getSubject());
		From.setText("From : "+ m.getFrom());
		this.dateReception.setText("Date : " + m.getDateReception());
		ic = new InboxControlerImpl(u);
		
	}


	
	public void addActionEvent() {
		setLayout(null);
		setBounds(236, 11, 635, 168);
		
		Read.setForeground(Color.WHITE);
		Read.setBackground(SystemColor.textHighlight);
		Read.setBounds(508, 33, 89, 23);
		add(Read);		
		Read.addActionListener(this);
		
		Archive.setForeground(Color.WHITE);
		Archive.setBackground(SystemColor.textHighlight);
		Archive.setBounds(508, 66, 89, 23);
		add(Archive);
		Archive.addActionListener(this);
		
		Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Delete.setForeground(Color.WHITE);
		Delete.setBackground(SystemColor.textHighlight);
		Delete.setBounds(508, 100, 89, 23);
		add(Delete);
		Delete.addActionListener(this);
	}


	public MessageEmail getM() {
		return m;
	}

	public void setM(MessageEmail m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == Read ) {
			
			JOptionPane.showMessageDialog(this,"the content of the message : " + m.getContent());
			System.out.println("read the content of the email ");
			
		}else if(e.getSource() == Archive) {
			
			ic.ArchiveEmail(this.m);
			this.m.setArchived(true);
			setVisible(false);
			System.out.println("archive  the email ");
			
		}else if(e.getSource() == Delete) {
			
			
			setVisible(false);
			this.m.setDeleted(true);
			System.out.println("delete the email ");
			
		}
		
	}

}