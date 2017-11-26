package client.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import client.app.IClient;
import serveur.Objet;

public class BidsPanel extends JPanel {

	private static final long serialVersionUID = 341558991057008262L;
	
	private IClient c;
	
	public BidsPanel(IClient current) {
		super();
		this.c = current;
		
		this.setPreferredSize(new Dimension(800,600));
		
		//START MOCK
		List<Objet> items = new ArrayList<Objet>();
		Objet obj1 = new Objet("Botruc","Petite créature d'une vingtaine de centimètres ayant un aspect végétal et deux longs doigts pointus à chaque main. - Peut crocheter des serrures -", 400);
		Objet obj2 = new Objet("Cerbère nain","Chien géant à trois tête servant de gardien - Cet exemplaire est de petite taille -", 250);
		Objet obj3 = new Objet("Demiguise","Créature pouvant se rendre invisible lorsqu'elle est menacée. - Ses poils servent à tisser des toiles d'invisibilité -", 900);
		Objet obj4 = new Objet("Démonzémerveille","Créature apparaissant sous forme de boule et se transformant, quand on la lance, en oiseau de proie bleu et vert. - A un attrait particulier pour le cerveau humain -", 1000);
		Objet obj5 = new Objet("Éruptif","Sorte de Rhinocéros géant vivant en Afrique. Le fluide contenu dans sa corne peut être injecté dans tout type de materiau, provoquant l'explosion de celui-ci. - Sa peau épaisse le rend insensible à la plupart des sorts -", 600);
		Objet obj6 = new Objet("Plume d'Hippogriffe","L'hippogriffe est une créature volante mi-aigle, mi- cheval. Il est très dangereux tant qu'il n'est pas dressé. - Cette plume a été récoltée dans les alentours de Poudlard et mesure 50 cm -", 150);
		Objet obj7 = new Objet("Niffleur","Animal à la fourrure noire et au long museau semblable à un ornithorynque. Ils sont attirés par tout ce qui brille. - Formidable voleur -", 250);
		Objet obj8 = new Objet("OEuf d'Occamy","Les Occamy sont une sorte d'oiseau-serpent. Ils ont la particularité d'être choranaptyxique : leur taille varient en fonction de l'espace dont ils disposent. - La coquille des oeufs d'Occamy est en argent pur -", 700);
		Objet obj9 = new Objet("Oiseau-Tonnerre","Vivant en Arizona, ces oiseau provoquent des tempêtes lorsqu'ils se sentent menacés. - Leur plume peuvent être utilisées pour fabriquer des baguettes magiques", 1250);
		Objet obj10 = new Objet("OEuf congelé de Serpencendre","Les serpencendres naissent dans des feux magiques laissés sans surveillance. Ils se cachent dans des recoins de la maison pour y pondre leurs oeufs qui, s'ils réussissent à grandir sans être repérés et chassés, enflamment la maison.", 2000);
		
		items.add(obj1);
		items.add(obj2);
		items.add(obj3);
		items.add(obj4);
		items.add(obj5);
		items.add(obj6);
		items.add(obj7);
		items.add(obj8);
		items.add(obj9);
		items.add(obj10);
		//END MOCK
		
		//items = c.getItems();
		this.setLayout(new GridLayout(items.size(),1));
		
		for (Objet i : items) {
			JPanel itemPanel = new JPanel();
			itemPanel.setBorder(null);
			
			
			itemPanel.setLayout(new GridBagLayout());
			itemPanel.setPreferredSize(new Dimension(750, 1500));
			
			//Image
			ImageIcon image = new ImageIcon("src/picture/test.png");
			JLabel img = new JLabel(image);
			JLabel name = new JLabel(i.getNom());
			JLabel time = new JLabel("Temps restant : 10m");
			JLabel price = new JLabel(String.valueOf(i.getPrixCourant()) + " mornilles");
			JTextArea descLabel = new JTextArea(i.getDescription());
		    JLabel plus = new JLabel("+");
		    JTextArea jta = new  JTextArea();
		    JButton btnbit = new JButton("Enchérir");

			
			
			img.setPreferredSize(new Dimension(100,150));
			name.setPreferredSize(new Dimension(150,40));
			time.setPreferredSize(new Dimension(150,40));
			price.setPreferredSize(new Dimension(100,40));
			descLabel.setEditable(false);
			descLabel.setWrapStyleWord(true);
			descLabel.setPreferredSize(new Dimension(400,70));
			descLabel.setBackground(itemPanel.getBackground());
			descLabel.setLineWrap(true);

		    plus.setPreferredSize(new Dimension(50, 40));
			jta.setPreferredSize(new Dimension(100,40));
		    btnbit.setPreferredSize(new Dimension(150, 40));
		
			
			GridBagConstraints gbc = new GridBagConstraints();

			//1e ligne 
			//Picture
		    //img.setPreferredSize(new Dimension(70,120));
			gbc.gridx = 0;
		    gbc.gridy = 0;
		    gbc.gridheight = 4;
		    gbc.gridwidth = 1;
			itemPanel.add(img, gbc);
			
			//Name
			gbc.gridx = 1;
		    gbc.gridheight = 1;
			itemPanel.add(name, gbc);
			
			//Time
			gbc.gridx = 2;
			itemPanel.add(time, gbc);
			
			//Price
			gbc.gridx = 3;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;;
		    itemPanel.add(price, gbc);
			
		    //2e ligne 
		    //Description 
		    		
			gbc.gridx = 1;
		    gbc.gridy = 1;
		    gbc.gridwidth = 2;
		    gbc.gridheight = 2;
		    itemPanel.add(descLabel, gbc);
		    
		    
		    //Champs pour l'enchère
			gbc.gridx = 3;
			gbc.gridy = 1;
		    gbc.gridheight = 1;
		    gbc.gridwidth = 1;
		    itemPanel.add(plus,gbc);
		    
		    gbc.gridx = 4;
		    itemPanel.add(jta,gbc);
		    
		    //3e ligne 
		    gbc.gridx = 3;
		    gbc.gridy = 3;
		    gbc.gridwidth = 2;
		    itemPanel.add(new JButton("Enchérir"),gbc);
			
			//4e ligne 	
		    gbc.gridx = 0;
		    gbc.gridy = 4;
		    gbc.gridwidth = 5;
		    itemPanel.add(new JSeparator(), gbc);
		    
			this.add(itemPanel);
		}
	}
}
