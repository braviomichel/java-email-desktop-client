/*package EmailManager.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import EmailManager.Beans.Email;
import EmailManager.Beans.User;
import EmailManager.Dao.EmailDao;
import EmailManager.Dao.EmailDaoImp;
import EmailManager.service.InboxControler;
import EmailManager.service.InboxControlerImpl;
import EmailManager.service.SentControler;
import EmailManager.service.SentControlerImp;
import java.awt.Color;



public class LaunchPage extends JFrame implements ActionListener  {
	
	private EmailDao dao = new EmailDaoImp();
	private SentControler sc;
	
	private  CheckPass cp = new CheckPass();
	private InboxInterface in = new InboxInterface();
	private SendInterface s = new SendInterface();
	
	private User u;
	private String pass; 
	
	
	private JLabel title = new JLabel("Email Manager"); 
	private JLabel user = new JLabel();
	
    private JButton Inbox = new JButton("Inbox");
    private JButton Send = new JButton("Send");
    private JButton Archive = new JButton("Archive");
    private JButton List = new JButton("Lists");
    
	
	private JPanel side = new JPanel();
	private JPanel main = new JPanel();
	
	
	
	

	public LaunchPage(User u ) {
		// TODO Auto-generated constructor stub
		
		this.u = u;
		//this.ic = new InboxControler(this.u, passwordField.getText());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setVisible(true);
		setSize(screenSize.width, screenSize.height);
		
		
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));		
		main.add(cp);
				
		
		side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));
		title.setFont(new Font("Serif", Font.BOLD, 28));
		side.add(title);
		side.add(Inbox);
		side.add(Send);
		side.add(Archive);
		side.add(List);
		
		
		//sentControler 
		 sc = new SentControlerImp(dao, u, pass);
		
		
		
		
		// user  label
		
		user.setText(u.getAdresse().substring(0, u.getAdresse().indexOf("@")));
        user.setHorizontalTextPosition(JLabel.LEFT);
        ImageIcon image = new ImageIcon("C:\\Users\\rrach\\eclipse-workspace\\EmailManager\\ressources\\images/logout.png");
        Image image1 = image.getImage(); // transform it 
        Image newimg = image1.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        image = new ImageIcon(newimg);                                                 
        user.setIcon(image);
        
        side.add(user);
		
		
				
		
		getContentPane().add(side,BorderLayout.WEST);
		getContentPane().add(main, BorderLayout.CENTER);	
		
		//actions
		addActions();

		
		pack();
	}
	
	
	
	public void addActions() {
		
		this.cp.getBtn().addActionListener(this);
		this.Send.addActionListener(this);
		this.s.getSubmit().addActionListener(this);
	}
	

	public User getU() {
		return u;
	}

	

	public JPanel getSide() {
		return side;
	}

	public JPanel getMain() {
		return main;
	}

	public void setU(User u) {
		this.u = u;
	}

	
	public void setSide(JPanel side) {
		this.side = side;
	}

	public void setMain(JPanel main) {
		this.main = main;
	}

	

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cp.getBtn()) {
			
			setPass(cp.getPasswordField().getText());
			cp.setVisible(false);
			InboxControler ic = new InboxControlerImpl();
			in.setInbox(ic.check(this.u.getAdresse(), pass));
			for(int i =0; i<in.getInbox().size(); i++) {
				System.out.println(in.getInbox().get(i).toString());
			}
			in.display();			
			main.add(in);
			in.setVisible(true);
			System.out.println(this.u.toString());
			
		}
		else if(e.getSource() == Send) {
			in.setVisible(false);
			s.setVisible(true);
			s.setSent(sc.getHistorique(u));
			s.display(s.getSent());
			main.add(s);
			
		}else if(e.getSource() == s.getSubmit()) {
			Email email1 = new Email(this.u.getId(),s.getTextField().getText() , s.getTextField_1().getText(),s.getTextAreaMessage().getText().toString() , "C:\\\\Users\\\\rrach\\\\eclipse-workspace\\\\EmailManager\\\\ressources\\\\images/logout.png" );			
			sc.Send(email1);
			s.getTextField().setText("");
			s.getTextField_1().setText("");
			s.getTextAreaMessage().setText("");
			
			
		}else {
			
			for(int i =0; i< s.getHisto().size() ; i++) {
				
				if(e.getSource() == s.getHisto().get(i).getDelete() ) {
					
					try{												
						sc.deleteEmail(s.getHisto().get(i).getEmail().getNumber());
						JOptionPane.showMessageDialog(this, "email deleted");
					
					}catch(Exception error) {
						System.out.println("error : "+ error.getMessage());
					}
					
				}
				
		}
			
			
			
			
		}
		
	}

	
}
*/