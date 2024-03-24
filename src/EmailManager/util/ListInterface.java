package EmailManager.util;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import EmailManager.Beans.ListUser;
import EmailManager.Beans.User;
import EmailManager.Dao.ListDaoImpl;
import EmailManager.Dao.UserDaoImp;
import EmailManager.service.ListControlerImp;
import EmailManager.service.UserControler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;

public class ListInterface extends JPanel implements ActionListener{
	
	
	private User admin;
	private List<ListUser> liste = new ArrayList<ListUser>(); 
	private JLabel labelAfficher;
	private JButton creerListe;
	private JLabel myList;
	
	
	public ListInterface(List<ListUser> liste, User admin) {
		this.admin=admin;
		System.out.println("entree en listeInterface");
		this.liste=liste;
		//setLayout(null);
		setLayout(new BorderLayout());
		
//		JLabel labelAfficher = new JLabel("Gestions des Listes D'envois");
		labelAfficher = new JLabel("Gestions des Listes D'envois");
		labelAfficher.setBounds(153, 11, 134, 14);
		add(labelAfficher);
		
//		JButton creerListe = new JButton("Creer une liste");
		creerListe = new JButton("Creer une liste");
		creerListe.setBounds(163, 36, 103, 23);
		add(creerListe);
		
//		JLabel myList = new JLabel("Mes listes");
		myList = new JLabel("Mes listes");
		myList.setBounds(188, 76, 46, 14);
		add(myList);
		
		
		for (int i =0; i<this.liste.size(); i++) {
			System.out.println("entree en listeInterfaceAjout liste");
			ListDeploiement l = new ListDeploiement(admin,this.liste.get(i));
			l.setVisible(true);
			add(l);
			System.out.println("entree en listeInterfaceajouraddddddddddddddddddddddddddd");
			l.setVisible(true);
			
		}
		this.setVisible(true);
		
		this.creerListe.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==creerListe) {
			 String nombre = JOptionPane.showInputDialog("entrez le nombre de mails");
			 String label = JOptionPane.showInputDialog("Entrez le titre de la liste");
			 UserDaoImp dao= new UserDaoImp();
			 UserControler uc = new UserControler(dao);
			 ArrayList<User>l= new ArrayList<>();
			
			
			 
			 for (int i=0;i<Integer.parseInt(nombre);i++) {
				 String mail = JOptionPane.showInputDialog("entrez le mail "+i);
				 User u = new User();
				// u = uc.getUserbymail(mail);
				 l.add(u);				 
			 }
			 ListUser nouvelleListe = new ListUser();
				nouvelleListe.setId(liste.get(1).getId());
				nouvelleListe.setLabel(label);
				nouvelleListe.setMembers(l);
				nouvelleListe.setUserId(liste.get(1).getId());
				
				ListDaoImpl dao2 = new ListDaoImpl();
				ListControlerImp lc = new ListControlerImp(dao2);
				lc.createList(admin, nouvelleListe);
		
		}
		
	}
}
