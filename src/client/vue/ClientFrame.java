package client.vue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import client.app.IClient;

public class ClientFrame extends JFrame {

	private IClient client;
	private JTabbedPane tabPanel;
	
	public ClientFrame(IClient client) {
		super();
		this.client = client;
		
		JScrollPane scroll = new JScrollPane(new BidsPanel(client));
		
		this.tabPanel = new JTabbedPane();
		this.tabPanel.addTab("Enchères", scroll);
		this.tabPanel.addTab("Soummettre un article", new SubmitPanel(client));
		
		this.setTitle("Gringott - Service d'enchère pour sorciers");
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(tabPanel);
		
	}
	
	public static void main(String[] args) {
		JFrame main = new ClientFrame(null);
		main.setVisible(true);
	}
	
}
