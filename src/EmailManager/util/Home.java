package EmailManager.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EmailManager.Beans.Email;
import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.ArchiveDao;
import EmailManager.Dao.ArchiveDaoImp;
import EmailManager.Dao.EmailDao;
import EmailManager.Dao.EmailDaoImp;
import EmailManager.Dao.ListDao;
import EmailManager.Dao.ListDaoImpl;
import EmailManager.service.ArchiveControler;
import EmailManager.service.InboxControler;
import EmailManager.service.InboxControlerImpl;
import EmailManager.service.ListControler;
import EmailManager.service.ListControlerImp;
import EmailManager.service.SentControler;
import EmailManager.service.SentControlerImp;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Home extends JFrame implements ActionListener  {

	private JPanel contentPane = new JPanel();;
	
	private EmailDao dao = new EmailDaoImp();
	private SentControler sc;
	
	private ArchiveDao dao1 = new ArchiveDaoImp();
	private ArchiveControler Ac  = new ArchiveControler(this.dao1);
	//Listes
	
	private ListDao dao2;
	private ListControler Lc;
	private ListInterface L;
	
	
	private  CheckPass cp = new CheckPass();
	private InboxInterface in ;
	private SendInterface s = new SendInterface();
	private ArchiveInterface A = new ArchiveInterface();
	
	private User u;
	private String pass;
	
	private JLabel Title = new JLabel("Email Manager ");
	private JPanel Side = new JPanel();
	private JPanel main = new JPanel();
	
	
	private JButton Inbox = new JButton("Inbox");
	private JButton Send = new JButton("Send");
	private JButton Archive = new JButton("Archive");
	private JButton Lists = new JButton("Lists");
	private JLabel user = new JLabel("User 01 ");
	
	public Home(User u) {
		
		this.u = u; 
		
		this.in = new InboxInterface(u);
		
		setVisible(true);
		setResizable(false);
		
		setTitle("EmailManager\r\n");
		setFont(new Font("Serif", Font.PLAIN, 14));
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rrach\\eclipse-workspace\\EmailManager\\ressources\\images\\icon.png"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);

		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
				
		//side panel
		Side.setBackground(Color.WHITE);
		Side.setBounds(0, 11, 226, 707);
		getContentPane().add(Side);
		Side.setLayout(null);
		Side.setVisible(true);
		
		
		//main panel
        main.setBackground(Color.WHITE);
        main.setLayout(null);        
        main.setBounds(236, 11, 1067, 642);
        getContentPane().add(main);        
        main.setVisible(true);
		
		
		//inbox button
		Inbox.setBounds(38, 139, 81, 27);
		Side.add(Inbox);
		Inbox.setFont(new Font("Serif", Font.BOLD, 14));
		Inbox.setBackground(SystemColor.textHighlight);
		Inbox.setForeground(Color.WHITE);
		Inbox.addActionListener(this);
		
		
		//send button		
		Send.setBounds(38, 192, 81, 27);
		Side.add(Send);
		Send.setForeground(Color.WHITE);
		Send.setFont(new Font("Serif", Font.BOLD, 14));
		Send.setBackground(SystemColor.textHighlight);
		Send.addActionListener(this);
		
		
		//archive button
		Archive.setBounds(38, 246, 81, 27);
		Side.add(Archive);
		Archive.setFont(new Font("Serif", Font.BOLD, 14));
		Archive.setBackground(SystemColor.textHighlight);
		Archive.setForeground(Color.WHITE);
		Archive.addActionListener(this);
		
		
		
		//lists button
		Lists.setBounds(38, 300, 81, 27);
		Side.add(Lists);
		Lists.setForeground(Color.WHITE);
		Lists.setFont(new Font("Serif", Font.BOLD, 14));
		Lists.setBackground(SystemColor.textHighlight);
		
		//title 
		Title.setBounds(10, 11, 193, 37);
		Side.add(Title);
		Title.setBackground(Color.WHITE);
		Title.setFont(new Font("Serif", Font.BOLD, 28));		
		
		Side.add(user);
	       
        
	       
        cp.setBounds(381, 197, 300, 300);
        cp.setVisible(true);
        main.add(cp);
		
		
		
		//sentControler 
		 sc = new SentControlerImp(dao, u, pass);
		
		
		
		//user label 		
		user.setBounds(38, 641, 188, 37);
		user.setBackground(Color.WHITE);
		user.setText(u.getAdresse().substring(0, u.getAdresse().indexOf("@")));
        user.setHorizontalTextPosition(JLabel.LEFT);
        ImageIcon image = new ImageIcon("C:\\Users\\rrach\\eclipse-workspace\\EmailManager\\ressources\\images/logout.png");
        Image image1 = image.getImage(); // transform it 
        Image newimg = image1.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        image = new ImageIcon(newimg);                                                 
        user.setIcon(image);  
        
        
		
        
      //actions
      	addActions();
		
		
		
		
		
	}
	
	
	public void addActions() {
		
		this.cp.getBtn().addActionListener(this);
		this.Send.addActionListener(this);
		this.s.getSubmit().addActionListener(this);
		this.Archive.addActionListener(this);
		this.Lists.addActionListener(this);
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cp.getBtn() || e.getSource() == Inbox) {	
			
			setPass(cp.getPasswordField().getText());
			cp.setVisible(false);
			s.setVisible(false);
			InboxControler ic = new InboxControlerImpl(this.u);
			in.setInbox(ic.check(this.u.getAdresse(), pass));
			for(int i =0; i<in.getInbox().size(); i++) {
				System.out.println(in.getInbox().get(i).toString());
			}
			in.display();			
			main.add(in);
			in.setVisible(true);
			System.out.println(this.u.toString());
			
			
			for(int i =0; i<sc.getHistorique(u).size();i++) {
				s.getSent().remove(i);
				s.getHisto().remove(i);
			}
			
		}
		else if(e.getSource() == Send) {
			this.sc = new SentControlerImp(dao,this.u, this.pass); 
			
//			for(int i =0; i<in.getInbox().size(); i++) {
//				in.getInbox().remove(i);
//				//in.getDisplay().remove(i);
//			}
			
			
			cp.setVisible(false);
			in.setVisible(false);
			A.setVisible(false);
			s.setSent(sc.getHistorique(u));
			for(int i =0; i<sc.getHistorique(u).size();i++) {
				System.out.println(sc.getHistorique(u).get(i).toString());
			}
			s.display(s.getSent());
			main.add(s);
			s.setVisible(true);
			main.setVisible(true);
			
			
		}else if(e.getSource() == s.getSubmit()) {
			Email email1 = new Email(this.u.getId(),s.getTextField().getText() , s.getTextField_1().getText(),s.getTextAreaMessage().getText().toString() , "C:\\\\Users\\\\rrach\\\\eclipse-workspace\\\\EmailManager\\\\ressources\\\\images/logout.png" );			
			sc.Send(email1);
			s.getTextField().setText("");
			s.getTextField_1().setText("");
			s.getTextAreaMessage().setText("");
			
			
		}else if(e.getSource() == Archive) {
			cp.setVisible(false);
			in.setVisible(false);
			s.setVisible(false);
			if(Ac.getArchive(this.u) != null) {
				A.setArchiveList(Ac.getArchive(this.u));
				for(int i =0; i<A.getArchiveList().size();i++) {
					System.out.println(A.getArchiveList().get(i).toString());
				}
				A.display();
				main.add(A);
				A.setVisible(true);
				main.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(main,"you have no archive!");
			}
			
			main.setVisible(true);
			
			
			for(int i =0; i<sc.getHistorique(u).size();i++) {
				s.getSent().remove(i);
				s.getHisto().remove(i);
			}
				
		}
		else if (e.getSource()==Lists) {
			
			dao2= new ListDaoImpl();
			Lc= new ListControlerImp((ListDaoImpl) dao2);
			List<ListUser> liste= new ArrayList<ListUser>();
			liste=Lc.getLists(this.u);
			L= new ListInterface(liste,u);
			in.setVisible(false);
			L.setVisible(true);
			main.add(L);
			L.setVisible(true);
			main.setVisible(true);
			
			
			
			
		}
			
			
		
	}


	public EmailDao getDao() {
		return dao;
	}


	public SentControler getSc() {
		return sc;
	}


	public CheckPass getCp() {
		return cp;
	}


	public InboxInterface getIn() {
		return in;
	}


	public SendInterface getS() {
		return s;
	}


	public User getU() {
		return u;
	}


	public String getPass() {
		return pass;
	}


	public String getTitle() {
		return Title.getText();
	}


	public JPanel getSide() {
		return Side;
	}


	public JPanel getMain() {
		return main;
	}


	public JButton getInbox() {
		return Inbox;
	}


	public JButton getSend() {
		return Send;
	}


	public JButton getArchive() {
		return Archive;
	}


	public JButton getLists() {
		return Lists;
	}


	public JLabel getUser() {
		return user;
	}


	public void setDao(EmailDao dao) {
		this.dao = dao;
	}


	public void setSc(SentControler sc) {
		this.sc = sc;
	}


	public void setCp(CheckPass cp) {
		this.cp = cp;
	}


	public void setIn(InboxInterface in) {
		this.in = in;
	}


	public void setS(SendInterface s) {
		this.s = s;
	}


	public void setU(User u) {
		this.u = u;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public void setTitle(JLabel title) {
		Title = title;
	}


	public void setSide(JPanel side) {
		Side = side;
	}


	public void setMain(JPanel main) {
		this.main = main;
	}


	public void setInbox(JButton inbox) {
		Inbox = inbox;
	}


	public void setSend(JButton send) {
		Send = send;
	}


	public void setArchive(JButton archive) {
		Archive = archive;
	}


	public void setLists(JButton lists) {
		Lists = lists;
	}


	public void setUser(JLabel user) {
		this.user = user;
	}

}
