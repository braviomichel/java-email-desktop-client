package EmailManager.util;

import javax.swing.JPanel;

import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.ListDaoImpl;
import EmailManager.service.ListControlerImp;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ModifierInterfaceList extends JPanel implements ActionListener{
	private AfficherListeInterface afficherListeInterface;
	private JButton AjoutUser;
	
	private User u;
	private User admin;
	private ListUser l;
	
	public ModifierInterfaceList( User admin, User u,ListUser l) {
		this.admin=admin;
		this.u=u;
		this.l=l;
		
		
		
		setLayout(null);
		
		for (int i = 0;i<l.getMembers().size();i++){
			afficherListeInterface = new AfficherListeInterface(admin, l.getMembers().get(i),l);
			afficherListeInterface.setBounds(392, 93, -335, -61);
			add(afficherListeInterface);
			afficherListeInterface.setLayout(null);
			
		}
		
		
		
		AjoutUser = new JButton("AjouterUser");
		AjoutUser.setBounds(156, 0, 128, 23);
		add(AjoutUser);
		
		AjoutUser.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==AjoutUser) {
			ListDaoImpl dao = new ListDaoImpl();
			ListControlerImp lc = new ListControlerImp(dao);
			lc.addUser(admin, u, l);
		}
		
	}
	

	
}
