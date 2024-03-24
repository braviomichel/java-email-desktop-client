 package EmailManager.util;


import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

import EmailManager.Beans.MessageEmail;
import EmailManager.Beans.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


public class InboxInterface extends JPanel {
	
	private User u;
		
	private ArrayList<MessageEmail> inbox = new ArrayList<>();
//	private ArrayList<EmailDeploiment> dep = new ArrayList<>();
	
	private JLabel title = new JLabel("Inbox");
	//private JScrollPane scroll = new JScrollPane();
	private JPanel display = new JPanel();
	
	
	

	public InboxInterface(User u) {
		
		this.u = u;
		setBackground(Color.WHITE);		
		setBounds(236, 11, 1045, 634);
		setLayout(new BorderLayout());
		title.setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
		
		title.setFont(new Font("Serif", Font.BOLD, 28));
		add(title, BorderLayout.NORTH);
		
		
		display.setBackground(new Color(255, 255, 255));
		//display.setLayout(new GridLayout(1,3,0,0));
		add(display, BorderLayout.CENTER);
		display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
		display.setVisible(true);

		//modif
		//this.display();
	
	}
	
	
	
	
	public void display() {
		
//		for(int i =0; i<inbox.size(); i++) {
		for(int i =0; i<3; i++) {
		
			EmailDeploiment em= new EmailDeploiment(u,this.inbox.get(i));
			if(!em.getM().isArchived() && !em.getM().isDeleted()) {
				this.display.add(em);
				em.setVisible(true);
			}
			
					
			
		}
	}




	public JPanel getDisplay() {
		return display;
	}




	public void setDisplay(JPanel display) {
		this.display = display;
	}




	public ArrayList<MessageEmail> getInbox() {
		return inbox;
	}




	public void setInbox(ArrayList<MessageEmail> inbox) {
		this.inbox = inbox;
	}

//	public ArrayList<EmailDeploiment> getDep() {
//		return dep;
//	}
//
//	public void setDep(ArrayList<EmailDeploiment> dep) {
//		this.dep = dep;
//	}
}