package client;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.Color;
import java.awt.Component;

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
	
	private JLabel lblItemPrice = new JLabel();			//
	private JTextPane lblItemName = new JTextPane();
	private JTextArea lblItemDescription = new JTextArea();
	private JLabel lblPseudo = new JLabel();
	private JLabel lblEncherir = new JLabel();
	private JLabel lblChrono = new JLabel("chrono");

	private JButton btnEncherir = new JButton("Encherir");
	private JButton btnPseudo = new JButton("Inscription");
	private JButton btnSoumettre = new JButton("Soumettre une enchere");
	private JButton btnSoumettreObjet = new JButton("Soumettre");
	private JButton btnStop = new JButton("Passer");
	
	private JTextField txtEncherir = new JTextField();
	private JTextField txtPseudo = new JTextField();
	private JTextField txtSoumettreNomObjet = new JTextField();
	private JTextField txtSoumettreDescriptionObjet = new JTextField();
	private JTextField txtSoumettrePrixObjet = new JTextField();
	private JTextField txtSoumettreTemps = new JTextField();
	
	private JFrame frmSoumettre = new JFrame("Soumettre une enchere");

	public JLabel getLblEncherir() {
		return lblEncherir;
	}

	public VueClient() throws Exception {
		super();
		
		//Definition de la fenetre
		this.setSize(1000,500);
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
//------------------------------------------------------------
		
			
		// bitsPanel
		
		
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

//----------------------------------------------------
		submissionPanel.setLayout(new GridBagLayout());
				
		JLabel photoLabel = new JLabel("photo");
		photoLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setPreferredSize(new Dimension(75, 100));
		
		JLabel labelName = new JLabel("Nom : ");
		JLabel labelDescription = new JLabel("Description : ");
		JLabel labelPrice = new JLabel ("Prix de base : ");
		JLabel labelTime = new JLabel ("Date de fin : ");
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbTabSubmission = new GridBagConstraints();

		 /* a- ajout du label contenant le matricule. */
        gbTabSubmission.gridx = gbTabSubmission.gridy = 0;
        gbTabSubmission.gridwidth = GridBagConstraints.REMAINDER; // gbc.gridheight = 1;
        gbTabSubmission.insets = new Insets(10, 5, 0, 0);
        /* Le point d'ancrage ici n'a pas une grande importance. Nous allons quand même essayer d'aligner tout les
         * composants qui le peuvent sur leur ligne de base. */
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        submissionPanel.add(lblPseudo, gbc);
		
		
		/* b- ajout de la zone pour la photo. nous avons utilisé une étiquette pour cela. */
		gbTabSubmission.gridy = 1;
        gbTabSubmission.gridwidth = 1;
        gbTabSubmission.gridheight = 4;
        /* Ici, nous ne voulons surement pas que le composant s'aligne sur la ligne de base. Il n'est pas censé
        * représenté un élémént de texte mais bien une image. Nous allons donc utiliser la constance LINE_START. */
        gbTabSubmission.anchor = GridBagConstraints.LINE_START;
        gbTabSubmission.insets = new Insets(5, 5, 0, 0);
        submissionPanel.add(photoLabel, gbTabSubmission);
	
        /* c- étiquette contenant le nom. */
        gbTabSubmission.gridx = gbTabSubmission.gridy = gbTabSubmission.gridwidth = gbTabSubmission.gridheight = 1;
        /* L'étiquette avec le nom sera alignée sur la ligne de base avec le champ de saisie pour le nom. */
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(0, 5, 0, 0);
        submissionPanel.add(labelName, gbTabSubmission);
        
        /* d- le champs de saisie pour le nom. */
        gbTabSubmission.gridx = 2;
        gbTabSubmission.gridy = 1;
        gbTabSubmission.gridwidth = GridBagConstraints.REMAINDER; // dernier composant de la ligne.
        gbTabSubmission.fill = GridBagConstraints.HORIZONTAL; // étalons le sur l'espace disponible.
        gbTabSubmission.insets = new Insets(3, 5, 0, 5); // laissons tout de même une marge à droite.
        gbTabSubmission.anchor = GridBagConstraints.BASELINE; // alignons le sur la même ligne de base que son étiquette.
        submissionPanel.add(txtSoumettreNomObjet, gbTabSubmission);
        
        /* e- l'étiquette pour la description. */
        gbTabSubmission.gridx = gbTabSubmission.gridwidth = gbTabSubmission.gridheight = 1;
        gbTabSubmission.gridy = 2;
        gbTabSubmission.fill = GridBagConstraints.NONE;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(0, 5, 0, 0);
        submissionPanel.add(labelDescription, gbTabSubmission);
        
        /* f- le champ de saisie pour la description*/
        gbTabSubmission.gridx = gbTabSubmission.gridy = 2;
        gbTabSubmission.gridwidth = GridBagConstraints.REMAINDER;
        gbTabSubmission.fill = GridBagConstraints.HORIZONTAL;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(3, 5, 0, 5);
        submissionPanel.add(txtSoumettreDescriptionObjet, gbTabSubmission);
        
        /* g- l'étiquette pour le prix. */
        gbTabSubmission.gridx = gbTabSubmission.gridwidth = gbTabSubmission.gridheight = 1;
        gbTabSubmission.gridy = 3;
        gbTabSubmission.fill = GridBagConstraints.NONE;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(0, 5, 0, 0);
        submissionPanel.add(labelPrice, gbTabSubmission);
        
        /* h- le champ de saisie pour le prix*/
        gbTabSubmission.gridx = gbTabSubmission.gridy = 2;
        gbTabSubmission.gridwidth = GridBagConstraints.REMAINDER;
        gbTabSubmission.fill = GridBagConstraints.HORIZONTAL;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(3, 5, 0, 5);
        submissionPanel.add(txtSoumettrePrixObjet, gbTabSubmission);

        /* i- l'étiquette pour le temps. */
        gbTabSubmission.gridx = gbTabSubmission.gridwidth = gbTabSubmission.gridheight = 1;
        gbTabSubmission.gridy = 4;
        gbTabSubmission.fill = GridBagConstraints.NONE;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(0, 5, 0, 0);
        submissionPanel.add(labelTime, gbTabSubmission);
        
        /* j- le champ de saisie pour le temps*/
        gbTabSubmission.gridx = gbTabSubmission.gridy = 2;
        gbTabSubmission.gridwidth = GridBagConstraints.REMAINDER;
        gbTabSubmission.fill = GridBagConstraints.HORIZONTAL;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_LEADING;
        gbTabSubmission.insets = new Insets(3, 5, 0, 5);
		submissionPanel.add(txtSoumettreTemps , gbTabSubmission);


        /* M- Un séparateur. */
		gbTabSubmission.gridy = 5;
        gbTabSubmission.gridx = 0;
        gbTabSubmission.anchor = GridBagConstraints.CENTER;
        gbTabSubmission.fill = GridBagConstraints.HORIZONTAL;
        gbTabSubmission.insets = new Insets(3, 5, 0, 5);
        submissionPanel.add(separator, gbTabSubmission);
        
        /* N- Le bouton permettant d'imprimer. */
        gbTabSubmission.gridy = 6;
        gbTabSubmission.gridheight = GridBagConstraints.REMAINDER; /* dernier composant de la colonne */
        gbTabSubmission.weighty = 1.;
        gbTabSubmission.fill = GridBagConstraints.NONE;
        gbTabSubmission.anchor = GridBagConstraints.BASELINE_TRAILING;
        gbTabSubmission.insets = new Insets(3, 0, 5, 5);
        submissionPanel.add(btnSoumettreObjet, gbTabSubmission);
		
		
		// Ajout des liaison avec les boutons
		btnEncherir.addActionListener(this);
		btnPseudo.addActionListener(this);
		btnSoumettre.addActionListener(this);
		btnSoumettreObjet.addActionListener(this);
		btnStop.addActionListener(this);
		
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
		
		/*else if(arg0.getSource().equals(btnSoumettre)) {
			soumettre();
		}*/
		
		else if(arg0.getSource().equals(btnSoumettreObjet)) {
			try {
				currentClient.nouvelleSoumission(txtSoumettreNomObjet.getText(), txtSoumettreDescriptionObjet.getText(), Integer.parseInt(txtSoumettrePrixObjet.getText()));
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
