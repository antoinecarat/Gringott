package client.app;

import java.rmi.Remote;

public interface IClient extends Remote {

	/**
	 * Add a new sellable item.
	 * @param item the item to be sold.
	 */
	void addNewItem(Item item);
	
	/**
	 * Update an item (after a bid from another buyer).
	 * @param item the item to be added.
	 * @param newPrix the new price.
	 * @param buyer the new leader.
	 */
	void update(Item item, double newPrix, String buyer);
	
	/**
	 * Notify client that an item clock have reached its end.
	 * @param item the item from which selling has to be ended.
	 */
	void endSelling(Item item);
	
}
