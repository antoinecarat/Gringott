package client.app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import client.vue.ClientFrame;
import serveur.IServer;

public class ClientApp implements IClient {

	private ClientFrame view;
	private String pseudo;
	//OrderedSet ? Map ?
	private List<Item> items;
	private IServer server;
	
	ClientApp(String url) throws MalformedURLException, RemoteException, NotBoundException {
		this.view = new ClientFrame(this);
		this.items = new ArrayList<Item>();
		this.server = (IServer) Naming.lookup("//" + url);
		this.server.registerClient(pseudo);
	}
	
	@Override
	public void addNewItem(Item item) {
		this.items.add(item);
	}

	@Override
	public void update(Item item, double newPrix, String buyer) {
		this.items.get(this.items.indexOf(item)).setPrice(newPrix);
		this.items.get(this.items.indexOf(item)).setLeader(buyer);
	}

	@Override
	public void endSelling(Item item) {
		// TODO Auto-generated method stub

	}

	public void updateView() {
		
	}
	
	public static void main(String[] args) {
		try {
			String serverURL = "localhost:8090/enchere";
			ClientApp c = new ClientApp(serverURL);
			System.out.println("Connexion au serveur " + serverURL + " reussi.");
		} catch (RemoteException e ) {
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

}
