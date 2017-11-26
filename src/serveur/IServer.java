package serveur;

import java.rmi.Remote;
import java.util.List;

import client.app.Item;

public interface IServer extends Remote {

	void registerClient(String pseudo);
	
	void bid(Item item, double newPrice, String buyer);
	
	List<Item> getItems();
	
	void submit(Item item);
	
}
