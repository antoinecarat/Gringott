package serveur;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import client.app.IClient;
import client.app.Item;

/**
 * @author antoine
 *
 */
public class ServerApp extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = -8168686161180269490L;

	List<IClient> clients;
	List<Item> items;

	public ServerApp() throws RemoteException {
		this.clients = new ArrayList<IClient>();
		this.items = new ArrayList<Item>();
	}

	@Override
	public void registerClient(IClient client) throws RemoteException {
		System.out.println("New client registered : " + client.getPseudo());
		this.clients.add(client);
		for (Item i : items){
			client.addNewItem(i);
		}
	}

	@Override
	public void bid(Item item, double newPrice, IClient buyer) throws RemoteException {
		System.out.println("New bid from " + buyer.getPseudo() + " recorded for " + item.getName() + " at " + newPrice );
		for (IClient c : clients){
			c.update(item, newPrice, buyer);
		}
	}

	@Override
	public List<Item> getItems() {
		return this.items;
	}

	@Override
	public void submit(Item item) throws RemoteException {
		System.out.println("New item registered : " + item);
		this.items.add(item);
		for (IClient c : clients){
			c.addNewItem(item);
		}
	}

	public static void main(String[] args) {
		try {
			int port = 8090;
			LocateRegistry.createRegistry(port);
			IServer s = new ServerApp();
			Naming.bind("//localhost:" + port + "/enchere", s);

			while (true) {
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
