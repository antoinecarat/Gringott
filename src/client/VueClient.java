package client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;

import serveur.Objet;

public class VueClient extends JFrame implements ActionListener{

	private static final long serialVersionUID = 9070911591784925769L;
	
	// Informations sur de l'Etat de la vente
	private Client currentClient;
	
	// Elements SWING
	private JPanel mainPanel = new JPanel();			//Panel containing tabs  
	private JTabbedPane tabPanel = new JTabbedPane();	

	private JPanel bidsPanel = new JPanel();			
	private JPanel submissionPanel = new JPanel();
	private JPanel inscriptionPanel = new JPanel();
	
	private JLabel lblItemPrice = new JLabel();			
	private JTextPane lblItemName = new JTextPane();
	private JTextArea lblItemDescription = new JTextArea();
	private JLabel lblPseudo = new JLabel();
	private JLabel lblEncherir = new JLabel();
	private JLabel lblChrono = new JLabel("chrono");

	private JButton btnEncherir = new JButton("Encherir");
	private JButton btnPseudo = new JButton("Inscription");
	private JButton btnSoumettre = new JButton("Soumettre une enchere");
	private JButton btnItemSubmission = new JButton("Soumettre");
	private JButton btnStop = new JButton("Passer");
	private JButton btnPhoto = new JButton("Importer");
	
	private JTextField txtEncherir = new JTextField();
	private JTextField txtPseudo = new JTextField();
	private JTextField txtItemName = new JTextField();
	private JTextField txtItemDescription = new JTextField();
	private JTextField txtItemPrice = new JTextField();
	private JFormattedTextField txtItemTime = new JFormattedTextField(DateFormat.getTimeInstance());;
	
	private JFrame frmSoumettre = new JFrame("Soumettre une enchere");

	public JLabel getLblEncherir() {
		return lblEncherir;
	}

	public VueClient() throws Exception {
		super();
		
		//Definition de la fenetre
		this.setSize(800,600);
		this.setTitle("Vente aux encheres");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		mainPanel.add(tabPanel);
		tabPanel.addTab("Enchère", null,bidsPanel);
		tabPanel.addTab("Nouvelle Soumission",null,submissionPanel);
		
		Font fontBtn = new Font("Serif", Font.PLAIN, 10);
		Font fontBig = new Font("Serif", Font.PLAIN, 16);
		
		// InscriptionPanel
		inscriptionPanel.setLayout(new GridBagLayout());
	    txtPseudo.setPreferredSize(new Dimension(400, 40));   
	    btnPseudo.setPreferredSize(new Dimension(100,40));
		GridBagConstraints gbc = new GridBagConstraints();

		// txtPseudo
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 3;
		inscriptionPanel.add(txtPseudo, gbc);
		
		// btnPseudo
	    gbc.gridx = 4;
	    gbc.gridy = 2;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
		inscriptionPanel.add(btnPseudo, gbc);
		
/****************************************************
 *                   bidsPanel                      *
*****************************************************/
		//bidsPanel.setLayout(new GridBagLayout());
		bidsPanel.setPreferredSize(new Dimension(1000,500));
		lblItemName.setFont(fontBig);
		lblItemDescription.setEditable(false);
		lblItemDescription.setLineWrap(true);
		lblItemDescription.setPreferredSize(new Dimension(700,250));
		txtEncherir.setPreferredSize(new Dimension(300,40));
		btnEncherir.setPreferredSize(new Dimension(100,40));
		btnEncherir.setFont(fontBtn);
		btnStop.setPreferredSize(new Dimension(100,40));
		btnStop.setFont(fontBtn);
		btnSoumettre.setPreferredSize(new Dimension(100,40));
		btnSoumettre.setFont(fontBtn);
				
		//1ere ligne
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		lblItemName.setEditable(false);
		bidsPanel.add(lblItemName, gbc);
		
		gbc.gridx = 2;
		bidsPanel.add(lblItemPrice, gbc);
		
		gbc.gridx = 3;
		bidsPanel.add(lblPseudo, gbc);
		
		gbc.gridx = 4;
		bidsPanel.add(lblChrono, gbc);
		
		//2eme ligne
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.gridwidth = 6;
		bidsPanel.add(lblItemDescription, gbc);
		
		//3eme ligne
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		bidsPanel.add(txtEncherir, gbc);
		
		gbc.gridx = 4;
		gbc.gridwidth = 1;
		bidsPanel.add(btnEncherir, gbc);
		
		gbc.gridx=5;
		gbc.gridwidth=1;
		bidsPanel.add(btnStop, gbc);
		
		gbc.gridx=6;
		gbc.gridwidth=1;
		bidsPanel.add(btnSoumettre, gbc);

/****************************************************
 *                   submissionPanel                *
*****************************************************/
		submissionPanel.setLayout(new GridBagLayout());
			
		ImageIcon image = new ImageIcon("src/pouet.jpg");
	
		JLabel labelPicture = new JLabel(image);
		JLabel labelName = new JLabel("Nom : ");
		JLabel labelDescription = new JLabel("Description : ");
		JLabel labelPrice = new JLabel ("Prix de base : ");
		JLabel labelTime = new JLabel ("Date de fin : ");

		labelPicture.setPreferredSize(new Dimension(300, 350));
		labelName.setPreferredSize(new Dimension(100,40));
		txtItemName.setPreferredSize(new Dimension(300,40));
		labelDescription.setPreferredSize(new Dimension(100,150));
		txtItemDescription.setPreferredSize(new Dimension(300, 150));
		labelPrice.setPreferredSize(new Dimension(100,40));
		txtItemPrice.setPreferredSize(new Dimension(300, 40));
		labelTime.setPreferredSize(new Dimension(100,40));
		txtItemTime.setPreferredSize(new Dimension(300, 40));
		
		//sJSeparator separator = new JSeparator();
		GridBagConstraints gbSubmission = new GridBagConstraints();

		
		//Picture
		gbSubmission.gridx = 0;
        gbSubmission.gridy = 0;
        gbSubmission.gridwidth = 1;
        gbSubmission.gridheight = 4;
        gbSubmission.insets = new Insets(5, 5, 5, 50);
        submissionPanel.add(labelPicture, gbSubmission);
        gbSubmission.insets = new Insets(0, 0, 0, 0);

        
        // Name 
        gbSubmission.gridx = 1;
        gbSubmission.gridheight = 1;
        submissionPanel.add(labelName, gbSubmission);
        
        gbSubmission.gridx = 2;
        submissionPanel.add(txtItemName, gbSubmission);
        
        //Description
        gbSubmission.gridx = 1;
        	gbSubmission.gridy = 2;
        	gbSubmission.gridwidth = 1;
        	gbSubmission.gridheight = 1;
        submissionPanel.add(labelDescription, gbSubmission);
        
        gbSubmission.gridx = 2;
        submissionPanel.add(txtItemDescription, gbSubmission);
        
        // Price
        gbSubmission.gridx = 1;
        	gbSubmission.gridy = 3;        
        submissionPanel.add(labelPrice, gbSubmission);
        
        gbSubmission.gridx = 2;
        	gbSubmission.gridy = 3;
        submissionPanel.add(txtItemPrice, gbSubmission);
        
        // Time
        gbSubmission.gridx = 1;
        gbSubmission.gridy = 4;
        submissionPanel.add(labelTime, gbSubmission);
        
        gbSubmission.gridx = 2;
        	gbSubmission.gridy = 4;
		submissionPanel.add(txtItemTime , gbSubmission);
		
		gbSubmission.gridx = 0;
        gbSubmission.gridy = 4;
        gbSubmission.insets = new Insets(5, 5, 5, 50);
        submissionPanel.add(btnPhoto, gbSubmission);
        gbSubmission.insets = new Insets(0, 0, 0, 0);

		// Separator
        /*mgbSubmission.gridx = 1;
		gbSubmission.gridy = 5;
        gbSubmission.gridwidth = 2;
        submissionPanel.add(separator, gbSubmission);*/
        
        // Button for submission
        gbSubmission.gridx = 2;
        gbSubmission.gridy = 6;
        submissionPanel.add(btnItemSubmission, gbSubmission);
		
		
		// Ajout des liaison avec les boutons
		btnEncherir.addActionListener(this);
		btnPseudo.addActionListener(this);
		btnSoumettre.addActionListener(this);
		btnItemSubmission.addActionListener(this);
		btnStop.addActionListener(this);
		btnItemSubmission.addActionListener(this);
		
		this.setContentPane(inscriptionPanel);
		this.setVisible(true);
	}
	
	public void actualiserPrix() {
		lblItemPrice.setText("Prix courant : " + currentClient.getCurrentObjet().getPrixCourant() + " gallion");
		lblPseudo.setText("Gagnant : " + this.currentClient.getCurrentObjet().getGagnant());
		txtEncherir.setText("");
	}
	
	public void actualiserObjet() {
		Objet objet = currentClient.getCurrentObjet();
		lblItemPrice.setText("Prix courant : " + objet.getPrixCourant() + " euros");
		lblPseudo.setText("Gagnant : " + objet.getGagnant());
		lblItemDescription.setText(objet.getDescription());
		txtEncherir.setText("");
		
		if (objet.isDisponible()) {
			lblItemName.setText(objet.getNom() + "(disponible)");
		}
		else{
			lblItemName.setText(objet.getNom() + "(vendu)");
		}
	}
	
	private void setClient(Client client) {
		currentClient = client;
		client.setVue(this);
	}
	
	
	
	@Override
	public synchronized void actionPerformed(ActionEvent arg0) {
		// ENCHERIR			
		if(arg0.getSource().equals(this.btnEncherir)){
			if(!txtEncherir.getText().isEmpty()){
				try {	
					currentClient.encherir(Integer.parseInt(txtEncherir.getText()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//STOP
		else if(arg0.getSource().equals(this.btnStop)){
			try {
				currentClient.encherir(-1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		// INSCRIPTION
		else if(arg0.getSource().equals(btnPseudo)) {
			try {
				setClient(new Client(txtPseudo.getText()));
				currentClient.inscription();
				changerGUI(this.mainPanel);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Inscription impossible");
			}
		}
		
		else if(arg0.getSource().equals(btnItemSubmission)) {
			try {
				currentClient.nouvelleSoumission(txtItemName.getText(), txtItemDescription.getText(), Integer.parseInt(txtItemPrice.getText()));
			} catch (NumberFormatException e) {
				System.out.println("Impossible de soumettre cet objet.");
			}
			frmSoumettre.dispose();
		}
	}
	

	/**
	 * Methode servant a changer l affichage pour le panel passe en parametre.
	 * @param vue le JPanel a afficher.
	 * @throws RemoteException 
	 */
	public void changerGUI(JPanel vue) throws RemoteException{
		if(this.currentClient.getCurrentObjet() != null){
			actualiserObjet();
		}
		this.getContentPane().removeAll();
		this.setContentPane(vue);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}
	
	public void attente(){
		this.btnEncherir.setEnabled(false);
		this.btnStop.setEnabled(false);
	}
	
	public void reprise(){
		this.btnEncherir.setEnabled(true);
		this.btnStop.setEnabled(true);
	}

	
	public JPanel getMainPanel() {
		return bidsPanel;
	}

	public JPanel getInscriptionPanel() {
		return inscriptionPanel;
	}
	
	public void updateChrono(long temps, long tempsMax){
		this.lblChrono.setText("Chrono : "+ temps+"/"+tempsMax);
	}


}
