package client.vue;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import client.app.IClient;

public class ClientFrame extends JFrame {

	private IClient client;
	private BidsPanel bidsPanel;
	private JTabbedPane tabPanel;
	private JPanel registerPanel;
	private ActionListener controller;
	
	public ClientFrame(IClient client, ActionListener controller) {
		super();
		this.client = client;
		this.controller = controller;
		registerPanel = new JPanel();
		registerPanel.add(new JLabel("Pseudo :"));
		JTextField registerField = new JTextField();
		registerField.setColumns(15);
		registerPanel.add(registerField);
		JButton registerButton = new JButton("Connexion");
		registerPanel.add(registerButton );
		registerButton.addActionListener(this.controller);
		
		this.bidsPanel = new BidsPanel(client, controller);
		JScrollPane scroll = new JScrollPane(bidsPanel);
		this.tabPanel = new JTabbedPane();
		this.tabPanel.addTab("Enchères", scroll);
		this.tabPanel.addTab("Soummettre un article", new SubmitPanel(client, controller));
		
		this.setTitle("Gringott - Service d'enchère pour sorciers");
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(tabPanel);
		this.add(registerPanel);
		this.setContentPane(registerPanel);
	}

	public Container getTabPanel() {
		return this.tabPanel;
	}

	public Container getRegisterPanel() {
		return this.registerPanel;
	}
		
}
