package server;

import shared.Item;

import java.util.List;

public class BidMonitor {

    public synchronized double updateBid(Item item, double newPrice, String buyer, List<Item> items, DBManager dbManager){
        double price = item.getPrice() + newPrice;
        System.out.println("New bid from " + buyer + " recorded for " + item.getName() + " at " + price);

        for (Item i : items) {
            if (i.getName().equals(item.getName())){
                i.setPrice(price);
                i.setLeader(buyer);
                dbManager.updateItem(i);
            }
        }
        return price;
    }
}
