package client.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import client.app.IClient;
import client.app.Item;
import client.app.SellableItem;

public class BidsPanel extends JPanel {

	private static final long serialVersionUID = 341558991057008262L;
	
	private IClient client;
	private ActionListener controller;
	
	public BidsPanel(IClient client, ActionListener controller) {
		super();
		this.client = client;
		this.controller = controller;
		
		this.setPreferredSize(new Dimension(800,600));
		
		//START MOCK
		List<Item> items = new ArrayList<Item>();
		Item obj1 = new SellableItem("Botruc","Petite créature d'une vingtaine de centimètres ayant un aspect végétal et deux longs doigts pointus à chaque main. - Peut crocheter des serrures -", 400, this.client);
		Item obj2 = new SellableItem("Cerbère nain","Chien géant à trois tête servant de gardien - Cet exemplaire est de petite taille -", 250, this.client);
		Item obj3 = new SellableItem("Demiguise","Créature pouvant se rendre invisible lorsqu'elle est menacée. - Ses poils servent à tisser des toiles d'invisibilité -", 900, this.client);
		Item obj4 = new SellableItem("Démonzémerveille","Créature apparaissant sous forme de boule et se transformant, quand on la lance, en oiseau de proie bleu et vert. - A un attrait particulier pour le cerveau humain -", 1000, this.client);
		Item obj5 = new SellableItem("Éruptif","Sorte de Rhinocéros géant vivant en Afrique. Le fluide contenu dans sa corne peut être injecté dans tout type de materiau, provoquant l'explosion de celui-ci. - Sa peau épaisse le rend insensible à la plupart des sorts -", 600, this.client);
		Item obj6 = new SellableItem("Plume d'Hippogriffe","L'hippogriffe est une créature volante mi-aigle, mi- cheval. Il est très dangereux tant qu'il n'est pas dressé. - Cette plume a été récoltée dans les alentours de Poudlard et mesure 50 cm -", 150, this.client);
		Item obj7 = new SellableItem("Niffleur","Animal à la fourrure noire et au long museau semblable à un ornithorynque. Ils sont attirés par tout ce qui brille. - Formidable voleur -", 250, this.client);
		Item obj8 = new SellableItem("OEuf d'Occamy","Les Occamy sont une sorte d'oiseau-serpent. Ils ont la particularité d'être choranaptyxique : leur taille varient en fonction de l'espace dont ils disposent. - La coquille des oeufs d'Occamy est en argent pur -", 700, this.client);
		Item obj9 = new SellableItem("Oiseau-Tonnerre","Vivant en Arizona, ces oiseau provoquent des tempêtes lorsqu'ils se sentent menacés. - Leur plume peuvent être utilisées pour fabriquer des baguettes magiques", 1250, this.client);
		Item obj10 = new SellableItem("OEuf congelé de Serpencendre","Les serpencendres naissent dans des feux magiques laissés sans surveillance. Ils se cachent dans des recoins de la maison pour y pondre leurs oeufs qui, s'ils réussissent à grandir sans être repérés et chassés, enflamment la maison.", 2000, this.client);
		
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
		
		//items = client.getItems();
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		for (Item i : items) {
			JPanel itemPanel = new JPanel();
			//itemPanel.setBorder(null);
			
			
			itemPanel.setLayout(new GridBagLayout());
			//itemPanel.setPreferredSize(new Dimension(750, 1500));
			
			//Image
			//ImageIcon image = new ImageIcon("src/picture/test.png");
			//JLabel img = new JLabel(image);
			JLabel name = new JLabel(i.getName());
			JLabel time = new JLabel("Temps restant : 10m");
			JLabel price = new JLabel(String.valueOf(i.getPrice()) + " mornilles");
			JTextArea descLabel = new JTextArea(i.getDescription());
		    JLabel plus = new JLabel("+");
		    JTextArea jta = new  JTextArea(String.valueOf(i.getPrice()*0.2));
		    JButton btnbit = new JButton("Enchérir");

		    descLabel.setEditable(false);
			descLabel.setWrapStyleWord(true);
			descLabel.setPreferredSize(new Dimension(400,70));
			descLabel.setBackground(itemPanel.getBackground());
			descLabel.setLineWrap(true);
		    
			GridBagConstraints gbc = new GridBagConstraints();
						
			gbc.gridx = 0;
		    gbc.gridy = 0;
		    gbc.gridheight = 2;
			itemPanel.add(name, gbc);
			gbc.gridx = 1;
		    gbc.gridy = 0;
		    gbc.gridheight = 1;
			itemPanel.add(time, gbc);
			gbc.gridx = 2;
		    gbc.gridy = 0;
			itemPanel.add(price, gbc);
			gbc.gridx = 1;
		    gbc.gridy = 1;
		    gbc.gridwidth = 2;
			itemPanel.add(descLabel, gbc);
			gbc.gridx = 3;
		    gbc.gridy = 0;
		    gbc.gridwidth = 1;
			itemPanel.add(plus, gbc);
			gbc.gridx = 4;
		    gbc.gridy = 0;
			itemPanel.add(jta, gbc);
			gbc.gridx = 3;
		    gbc.gridy = 1;
		    gbc.gridwidth = 2;
		    btnbit.addActionListener(controller);
			itemPanel.add(btnbit, gbc);
		    		    
			this.add(itemPanel);
		}
		
		JButton logout = new JButton("Deconnexion");
		logout.addActionListener(this.controller);
		this.add(logout);
	}
}
