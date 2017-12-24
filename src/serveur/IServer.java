package serveur;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import client.app.IClient;
import client.app.Item;

public interface IServer extends Remote, Serializable {

	void registerClient(IClient client) throws RemoteException;
	
	void bid(Item item, double newPrice, IClient buyer)  throws RemoteException;
	
	List<Item> getItems()  throws RemoteException;
	
	void submit(Item item)  throws RemoteException;

	List<IClient> getClients() throws RemoteException;

	void logout(IClient client) throws RemoteException;
	
}
