package EmailManager.util;

import javax.swing.JPanel;

import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.ListDao;
import EmailManager.Dao.ListDaoImpl;
import EmailManager.service.ListControler;
import EmailManager.service.ListControlerImp;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AfficherListeInterface extends JPanel implements ActionListener {
	private User u;
	private User admin;
	private ListUser l;
	private JLabel user;
	private JButton supp;
	private JLabel userMail;
	
	
	
	public AfficherListeInterface(User admin, User u,  ListUser l) {
		this.l=l;
		this.u=u;
		this.admin=admin;
		
		setLayout(null);
		
		user = new JLabel("utilisateur");
		user.setBounds(48, 21, 68, 14);
		add(user);
		
		supp = new JButton("Supprimer");
		supp.setBounds(303, 17, 89, 23);
		add(supp);
		
		userMail = new JLabel(""+this.u.getAdresse());
		userMail.setBounds(188, 21, 46, 14);
		add(userMail);
		
		supp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==supp) {
			ListDaoImpl dao = new ListDaoImpl();
			ListControlerImp lc = new ListControlerImp(dao);
			lc.deleteUser(admin, u, l);
			

		}
	}
	
	
	

}
