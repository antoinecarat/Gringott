package client.vue;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import client.app.IClient;

public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 6994145468596380654L;
	private IClient client;
	private BidsPanel bidsPanel;
	private JTabbedPane tabPanel;
	private RegisterPanel registerPanel;
	private ActionListener controller;
	
	public ClientFrame(IClient client, ActionListener controller) throws RemoteException {
		super();
		this.client = client;
		this.controller = controller;
		registerPanel = new RegisterPanel(controller);
		
		this.bidsPanel = new BidsPanel(client, controller);
		JScrollPane scroll = new JScrollPane(bidsPanel);
		this.tabPanel = new JTabbedPane();
		this.tabPanel.addTab("Soummettre un article", new SubmitPanel(client, controller));
		this.tabPanel.addTab("Enchères", scroll);
		this.tabPanel.setSelectedIndex(1);
		
		
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
	
	public SubmitPanel getSubmitPanel() {
		return (SubmitPanel) this.tabPanel.getComponentAt(0);
	}

	public RegisterPanel getRegisterPanel() {
		return this.registerPanel;
	}

	public void rebuild() throws RemoteException {
		this.tabPanel.remove(1);
		this.bidsPanel = new BidsPanel(this.client, this.controller);
		this.tabPanel.add("Enchères", bidsPanel);
		this.tabPanel.setSelectedIndex(1);
	}
		
}
