package client.app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IClient extends Remote {

	/**
	 * Add a new sellable item.
	 * @param item the item to be sold.
	 */
	void addNewItem(Item item) throws RemoteException;
	
	/**
	 * Update an item (after a bid from another buyer).
	 * @param item the item to be added.
	 * @param newPrice the new price.
	 * @param buyer the new leader.
	 */
	void update(Item item, double newPrice, String buyer)  throws RemoteException;
	
	/**
	 * Notify client that an item clock have reached its end.
	 * @param item the item from which selling has to be ended.
	 */
	void endSelling(Item item)  throws RemoteException;

	String getPseudo() throws RemoteException;

	List<Item> getItems() throws RemoteException;
	
}
