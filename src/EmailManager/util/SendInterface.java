package EmailManager.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import EmailManager.Beans.Email;
import java.awt.SystemColor;



public class SendInterface  extends JPanel {
	
	private JPanel form = new JPanel();
	private JLabel title = new JLabel("Sending Form ....");
	private JLabel label1 = new JLabel("Subject");
	private JTextField textField = new JTextField();;
	private JLabel label2 = new JLabel("To");
    private JTextField textField_1 = new JTextField();;
    private JLabel label3 = new JLabel("Message ");
    private JTextArea textAreaMessage = new JTextArea(70, 50);
    private JLabel label4 = new JLabel("Attachement ");
    private JTextField txtPath;
	private JButton submit = new JButton("Send");
 
	private JPanel historique = new JPanel();
	private JLabel title1 = new JLabel("Historique");
	private ArrayList<Email> sent = new ArrayList<>();
	private ArrayList<EmailDeploiment1> histo = new ArrayList<>();
	



	
	
	
	
	

	public SendInterface() {
		setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
		setBounds(236, 11, 1067, 642);
		
		title.setFont(new Font("Serif", Font.BOLD, 28));
		form.setBackground(Color.WHITE);
		
		
		
		form.setBounds(21,0, 425,586);
		form.setLayout(null);
		
		
		setLocationAndSize();
		addComponentsTothis();
		setLayout(null);
		
		add(form);
		
		txtPath = new JTextField();
		txtPath.setText("Path : ");
		txtPath.setBounds(138, 395, 150, 30);
		form.add(txtPath);
		txtPath.setColumns(10);
		historique.setBackground(Color.WHITE);
		historique.setBounds(445, 0, 421, 586);
		historique.setLayout(new BoxLayout(historique, BoxLayout.Y_AXIS));
		title1.setBounds(139, 28, 128, 37);
		title1.setFont(new Font("Serif", Font.BOLD, 28));
		//historique.setBounds(800 ,60, 600,600);
		historique.add(title1);
								
		add(historique);
		
	}
	
	
	
	public void  display(ArrayList<Email> sent) {
		
		for(int i = 0; i<3; i++) {
			
			EmailDeploiment1 ed = new EmailDeploiment1(sent.get(i));
			historique.add(ed);
			ed.setVisible(true);
			histo.add(ed);			
			
		}
		
		historique.setVisible(true);
	}
	
	 public void setLocationAndSize() {
		 	title.setBounds(72,30,105,30);
	       	label1.setBounds(23, 139, 105, 30);
	        label2.setBounds(23, 220, 105, 30);
	        label3.setBounds(23, 309, 105, 30);
	        label4.setBounds(23, 400, 105, 30);
	        textField.setBounds(138, 139, 150, 30);
	        textField_1.setBounds(138, 220, 150, 30);
	        textAreaMessage.setText("type your message here ");
	        textAreaMessage.setLineWrap(true);
	        textAreaMessage.setBounds(138, 293, 150, 89);
	        submit.setForeground(Color.WHITE);
	        submit.setBackground(SystemColor.textHighlight);
	        submit.setBounds(115, 503, 100, 30);	        

	    }
	 

	  
	

		public ArrayList<EmailDeploiment1> getHisto() {
		return histo;
	}



	public void setHisto(ArrayList<EmailDeploiment1> histo) {
		this.histo = histo;
	}



		public void addComponentsTothis() {
	    	form.add(title);
	        form.add(label1);
	        form.add(label2);
	        form.add(label3);
	        form.add(label4);
	        form.add(textField);
	        form.add(textField_1);
	        form.add(textAreaMessage);
	        form.add(submit);
	    }
	

	public JPanel getForm() {
		return form;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextArea getTextAreaMessage() {
		return textAreaMessage;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setTextAreaMessage(JTextArea textAreaMessage) {
		this.textAreaMessage = textAreaMessage;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JPanel getHistorique() {
		return historique;
	}


	public void setForm(JPanel form) {
		this.form = form;
	}


	public void setTextField(JTextField textField) {
		this.textField = textField;
	}


	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}


	public void setHistorique(JPanel historique) {
		this.historique = historique;
	}



	public ArrayList<Email> getSent() {
		return sent;
	}



	public void setSent(ArrayList<Email> sent) {
		this.sent = sent;
	}
}
