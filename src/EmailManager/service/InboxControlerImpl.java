package EmailManager.service;






import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import EmailManager.Beans.Archive;
import EmailManager.Beans.MessageEmail;
import EmailManager.Beans.User;
import EmailManager.Dao.ArchiveDao;
import EmailManager.Dao.ArchiveDaoImp;






public class InboxControlerImpl implements InboxControler {
	
     private static String host = "pop.gmail.com";// change accordingly
	 private static String mailStoreType = "pop3";
	 User u;
	 private ArchiveDao dao ;
	 private ArchiveControler ac; 


	public InboxControlerImpl(User u) {
		// TODO Auto-generated constructor stub
		this.u = u;
		dao = new ArchiveDaoImp();
		ac = new ArchiveControler(dao);
				
	}
	
	
	public String getHost() {
		return host;
	}

	public String getMailStoreType() {
		return mailStoreType;
	}




	@Override
	public ArrayList<MessageEmail> check(String add, String pass ) 
	  {
		// TODO Auto-generated method stub
		
		      try {

		      //create properties field
		      Properties properties = new Properties();

		      properties.put("mail.pop3.host", host);
		      properties.put("mail.pop3.port", "995");
		      properties.put("mail.pop3.starttls.enable", "true");
		      Session emailSession = Session.getDefaultInstance(properties);
		  
		      //create the POP3 store object and connect with the pop server
		      Store store = emailSession.getStore("pop3s");

		      store.connect(host, add, pass);

		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);

		      // retrieve the messages from the folder in an array and print it
		      Message[] messages = emailFolder.getMessages();
		      System.out.println("messages.length---" + messages.length);
		      
		      ArrayList<MessageEmail> l = new ArrayList<>();
		      //, n = messages.length
		      for (int i = 0; i < 10 ; i++) {
		         Message message = messages[i];
		         MessageEmail me = new MessageEmail();
//		         System.out.println("---------------------------------");
//		         System.out.println("Email Number " + (i + 1));
		         me.setNumber(i+1);
//		         System.out.println("Subject: " + message.getSubject());
		         me.setSubject(message.getSubject());
//		         System.out.println("From: " + message.getFrom()[0]);
		         me.setFrom(message.getFrom()[0].toString());
//		         System.out.println("Text: " + message.getContent().toString());
		         
		         l.add(me);

		      }
		      
		      
		      //close the store and folder objects
		      emailFolder.close(false);
		      store.close();
		      return l;

		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return null;
	}


	@Override
	public boolean ReadEmail() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean ArchiveEmail(MessageEmail e) {
		// TODO Auto-generated method stub
		Archive a = new Archive();
		a.setUserId(this.u.getId());
		a.setSubject(e.getSubject());
		a.setSender(e.getFrom());
		a.setContent(e.getContent());
		
		System.out.println(a);
		ac.archiver(u,a);
		
		if(ac.archiver(u,a) != null) {
			
			return true;
		}
		return false;
	}


	@Override
	public void deleteEmail() {
		// TODO Auto-generated method stub

	}


	
	

}