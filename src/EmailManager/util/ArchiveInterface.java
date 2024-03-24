package EmailManager.util;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import EmailManager.Beans.Archive;
import EmailManager.Beans.MessageEmail;

public class ArchiveInterface extends JPanel {
private ArrayList<Archive> archiveList = new ArrayList<>();
	
	private JLabel title = new JLabel("Archive"); 
	
	
	

	public ArchiveInterface() {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		// modif :setLayout(null);
		title.setBounds(152, 0, 70, 37);
		// TODO Auto-generated constructor stub
		
		title.setFont(new Font("Serif", Font.BOLD, 28));
		add(title);
		
		setVisible(true);
		//modif
		//this.display();
	
	}
	
	public void display( ) {
		
//		for(int i =0; i<inbox.size(); i++) {
		for(int i =0; i<archiveList.size(); i++) {
		
			ArchiveDeploiement ar= new ArchiveDeploiement(archiveList.get(i));			
			this.add(ar);
			ar.setVisible(true);
			
		
			
		}
	}




	public ArrayList<Archive> getArchiveList() {
		return archiveList;
	}




	public void setArchiveList(ArrayList<Archive> archiveList) {
		this.archiveList = archiveList;
	}

}
