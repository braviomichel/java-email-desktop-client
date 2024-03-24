package EmailManager.service;

import java.util.ArrayList;
//import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import EmailManager.Beans.Email;
import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.EmailDao;
//import EmailManager.Dao.UserDaoImp;

public class SentControlerImp implements SentControler {
	
	//private UserDaoImp dao1;
	private static String host = "smtp.gmail.com";
	private EmailDao dao;
	private User u;
	private String password;
	//private ListUser l;
	//private Email e;


	public SentControlerImp() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	 public SentControlerImp(EmailDao dao, User u, String pass) {
		super();
		this.dao = dao;
		this.u = u;
		this.password = pass;
		//this.l = l;
		//this.e = e;
	}

	 
	 
	 
//	 public SentControlerImp(EmailDao dao, User u, String password) {
//		super();
//		this.dao = dao;
//		this.u = u;
//		this.password = password;
//		//this.e = e;
//	}



	@Override 
	public  void Send(Email e) {
	      // Recipient's email ID needs to be mentioned.	     	     

	      Properties props = new Properties();
	      
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(u.getAdresse(), password );
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(u.getAdresse()));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(e.getReciever()));

	         // Set Subject: header field
	         message.setSubject(e.getSubject());

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText(e.getContent());

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = e.getAttachementPath();
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
	         System.out.println("email envoye :  "+ dao.insertEmail(e).toString());
	  
	      } catch (MessagingException e1) {
	         throw new RuntimeException(e1);
	      }
	   }


	
	@Override 
	public  void SendToList(Email e, ListUser l) {
	      // Recipient's email ID needs to be mentioned.	     	     

	      Properties props = new Properties();
	      
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "465");
	      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(u.getAdresse(), password );
	            }
	         });
	      for(int i =0; i< l.getMembers().size(); i++) { 
	    	  	e.setReciever(l.getMembers().get(i).getAdresse());
	    	   try {
   	  	    	
	  	         // Create a default MimeMessage object.
	  	         Message message = new MimeMessage(session);

	  	         // Set From: header field of the header.
	  	         message.setFrom(new InternetAddress(u.getAdresse()));

	  	         // Set To: header field of the header.
	  	         message.setRecipients(Message.RecipientType.TO,
	  	            InternetAddress.parse(e.getReciever()));

	  	         // Set Subject: header field
	  	         message.setSubject(e.getSubject());

	  	         // Create the message part
	  	         BodyPart messageBodyPart = new MimeBodyPart();

	  	         // Now set the actual message
	  	         messageBodyPart.setText(e.getContent());

	  	         // Create a multipar message
	  	         Multipart multipart = new MimeMultipart();

	  	         // Set text message part
	  	         multipart.addBodyPart(messageBodyPart);

	  	         // Part two is attachment
	  	         messageBodyPart = new MimeBodyPart();
	  	         String filename = e.getAttachementPath();
	  	         DataSource source = new FileDataSource(filename);
	  	         messageBodyPart.setDataHandler(new DataHandler(source));
	  	         messageBodyPart.setFileName(filename);
	  	         multipart.addBodyPart(messageBodyPart);

	  	         // Send the complete message parts
	  	         message.setContent(multipart);

	  	         // Send message
	  	         Transport.send(message);

	  	         System.out.println("Sent message successfully....");
	  	         System.out.println("email envoye :  "+ dao.insertEmail(e).toString());
	  	  
	  	      } catch (MessagingException e1) {
	  	         throw new RuntimeException(e1);
	  	      } 
	    		 
	    	 }	      	 
	   }
	
	
	
	
	
	

	@Override
	public ArrayList<Email> getHistorique(User u) {
		// TODO Auto-generated method stub
		return dao.selectEmail(this.u);
	}



	@Override
	public boolean deleteEmail(int num) {
		// TODO Auto-generated method stub
		return dao.deleteEmail(num);
	}
	
	
	
	
	}
			


