package client.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import client.vue.ClientFrame;
import serveur.IServer;

public class ClientApp extends UnicastRemoteObject implements IClient, ActionListener {

	private ClientFrame view;
	private String pseudo;
	// OrderedSet ? Map ?
	private List<Item> items;
	private IServer server;

	ClientApp(String url) throws MalformedURLException, RemoteException, NotBoundException {
		this.view = new ClientFrame(this, this);
		this.view.setVisible(true);
		this.items = new ArrayList<Item>();
		this.server = (IServer) Naming.lookup("//" + url);
	}

	@Override
	public void addNewItem(Item item) {
		this.items.add(item);
		System.out.println("Nouvel item ajouté : " + item);
	}

	@Override
	public void update(Item item, double newPrice, IClient buyer) {
		this.items.get(this.items.indexOf(item)).setPrice(newPrice);
		this.items.get(this.items.indexOf(item)).setLeader(buyer);
	}

	@Override
	public void endSelling(Item item) {
		this.items.get(this.items.indexOf(item)).setSold(true);
	}

	public void updateView() {
		this.view.repaint();
		this.view.revalidate();
	}

	public static void main(String[] args) {
		try {
			String serverURL = "localhost:8090/enchere";
			ClientApp c = new ClientApp(serverURL);
			System.out.println("Connexion au serveur " + serverURL + " reussi.");
		} catch (RemoteException e) {
			System.out.println("Connexion au serveur impossible.");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("Erreur dans l'adresse du serveur.");
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Serveur inconnu.");
			e.printStackTrace();
		}
	}

	@Override
	public String getPseudo() throws RemoteException {
		return this.pseudo;
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Connexion":
			try {
				// TODO: set Client's pseudo with the JTextField
				this.server.registerClient(this);
				this.view.setContentPane(view.getTabPanel());
				this.updateView();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			break;
		case "Soumettre":
			try {
				//TODO: retrieve item from submitPanel
				this.server.submit(null);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Enchérir":
			try {
				//TODO: retrieve item+price from bidsPanel
				this.server.bid(null, 0, null);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Deconnexion":
			this.view.setContentPane(view.getRegisterPanel());
			this.updateView();
			break;
		default:
			System.out.println(e.getActionCommand() + " button has been clicked but i don't care.");
		}
	}

}
