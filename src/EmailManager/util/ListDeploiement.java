package EmailManager.util;

import javax.swing.JPanel;

import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.ListDaoImpl;
import EmailManager.Dao.UserDaoImp;
import EmailManager.service.ListControlerImp;
import EmailManager.service.UserControler;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class ListDeploiement extends JPanel implements ActionListener {
	private ListUser l;
	//private User u;
	private User admin;
	
	JButton Modifier;
	JLabel liste;
	JLabel listContent;
	JButton Supprimer;
	
	public ListDeploiement(User admin, ListUser l) {
		this.admin=admin;
		//this.u=u;
		this.l=l;
		System.out.println("entree en listeDepliement");
		
		//setLayout(null);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
//		JButton Modifier = new JButton("Modifier ");
		Modifier = new JButton("Modifier ");
		Modifier.setBounds(55, 100, 89, 23);
		add(Modifier);
		
//		JLabel liste = new JLabel("Liste "+ l.getId());
		liste = new JLabel("Liste "+ l.getId());
		liste.setBounds(192, 11, 22, 14);
		liste.setEnabled(false);
		add(liste);
		
//		JLabel listContent = new JLabel("Contenu de la liste : "+l.getLabel());
		listContent = new JLabel("Contenu de la liste : "+l.getMembers());
		listContent.setBounds(34, 36, 331, 53);
		add(listContent);
		
//		JButton Supprimer = new JButton("Supprimer");
		Supprimer = new JButton("Supprimer");
		Supprimer.setBounds(274, 100, 89, 23);
		add(Supprimer);
		
		this.setVisible(true);
		this.Modifier.addActionListener(this);
		this.Supprimer.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==Modifier) {
			UserDaoImp daou= new UserDaoImp();
			UserControler uc = new UserControler(daou);
			User u = new User();
			//u= on affecte la fonction rechercher via la liste(userid)
			ModifierInterfaceList m= new ModifierInterfaceList(admin, u, l);
			add(m);
			m.setVisible(true);			
			
		}
		else if(e.getSource()==Supprimer) {
			ListDaoImpl dao= new ListDaoImpl();
			ListControlerImp lc= new ListControlerImp(dao);
			lc.deleteList(admin, l.getLabel());
		}
		// TODO Auto-generated method stub
		
	}
}
