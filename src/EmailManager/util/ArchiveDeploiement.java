package EmailManager.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import EmailManager.Beans.Archive;


public class ArchiveDeploiement extends JPanel implements ActionListener {
	
	
	//modif
		private Archive a;
		private JButton Read = new JButton("Read");
		private JButton Unarchive = new JButton("UnArchive");
		private JButton Delete = new JButton("Delete");
		private final JLabel number = new JLabel("Number  : ");
		private final JLabel Subject = new JLabel("Subject : ");
		private final JLabel From = new JLabel("From : ");
		private final JLabel dateReception = new JLabel("Date Reception :");
		

		public ArchiveDeploiement(Archive a) {
			
			this.a = a;		
			this.number.setText("number : "+ a.getNumber());
			Subject.setText("Subject : "+a.getSubject());
			From.setText("From : "+ a.getSender());
			this.dateReception.setText("Date : " + a.getDateReception());
			
			
			
			
			setBackground(Color.WHITE);
//			add(number);
//			add(Subject);
//			add(From);
//			add(dateReception);
			
			addActionEvent();
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
			
		}

	//modif
//		public EmailDeploiment(MessageEmail m ) {
//			this();
//			this.m = m;		
//			this.number.setText("number : "+ m.getNumber());
//			Subject.setText("Subject : "+m.getSubject());
//			From.setText("From : "+ m.getFrom());
//			this.dateReception.setText("Date : " + m.getDateReception());
//			
	//	
//			
//		}


		
		
		public void addActionEvent() {
			setLayout(null);
			Read.setForeground(Color.WHITE);
			Read.setBackground(SystemColor.textHighlight);
			Read.setBounds(233, 211, 88, 23);
			add(Read);
			Read.addActionListener(this);
			Unarchive.setForeground(Color.WHITE);
			Unarchive.setBackground(SystemColor.textHighlight);
			Unarchive.setBounds(123, 210, 89, 23);
			add(Unarchive);
			Unarchive.addActionListener(this);
			Delete.setFont(new Font("Tahoma", Font.PLAIN, 12));
			Delete.setForeground(Color.WHITE);
			Delete.setBackground(SystemColor.textHighlight);
			Delete.setBounds(16, 211, 89, 23);
			add(Delete);
			Delete.addActionListener(this);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == Read ) {
				
				JOptionPane.showMessageDialog(this,"the content of the message : " + a.getContent());
				System.out.println("read the content of the email ");
				
			}else if(e.getSource() == Unarchive) {
				
				setVisible(false);
				System.out.println("archive  the email ");
				
			}else if(e.getSource() == Delete) {
				
				
				setVisible(false);
				System.out.println("delete the email ");
				
			}
			
		}
	
	

}
