package client.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import client.app.IClient;
import client.app.Item;
import client.app.SellableItem;

public class BidsPanel extends JPanel {

	private static final long serialVersionUID = 341558991057008262L;

	private IClient client;
	private ActionListener controller;
	private List<Item> items;

	public BidsPanel(IClient client, ActionListener controller) throws RemoteException {
		super();
		this.client = client;
		this.controller = controller;

		// this.setPreferredSize(new Dimension(800,600));

		items = client.getItems();
		// this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for (Item i : items) {
			if (!i.getSeller().equals(client.getPseudo())) {
				JPanel itemPanel = new JPanel();
				itemPanel.setLayout(new GridBagLayout());

				JLabel name = new JLabel(i.getName());
				JTextArea descLabel = new JTextArea(i.getDescription());
				JLabel time = new JLabel(i.getTime().toString());
				JLabel price = new JLabel(String.valueOf(i.getPrice()) + " mornilles");

				descLabel.setEditable(false);
				descLabel.setWrapStyleWord(true);
				descLabel.setPreferredSize(new Dimension(400, 70));
				descLabel.setBackground(itemPanel.getBackground());
				descLabel.setLineWrap(true);

				GridBagConstraints gbc = new GridBagConstraints();

				if (!i.isSold()) {

					JLabel plus = new JLabel("+");
					JTextArea jta = new JTextArea(String.valueOf(i.getPrice() * 0.2));
					BidButton btnbit = new BidButton("Enchérir", i, jta);

					gbc.gridx = 0;
					gbc.gridy = 0;
					gbc.gridheight = 2;
					itemPanel.add(name, gbc);
					gbc.gridx = 1;
					gbc.gridy = 0;
					gbc.gridheight = 1;
					itemPanel.add(time, gbc);
					gbc.gridx = 2;
					gbc.gridy = 0;
					itemPanel.add(price, gbc);
					gbc.gridx = 1;
					gbc.gridy = 1;
					gbc.gridwidth = 2;
					itemPanel.add(descLabel, gbc);
					gbc.gridx = 3;
					gbc.gridy = 0;
					gbc.gridwidth = 1;
					itemPanel.add(plus, gbc);
					gbc.gridx = 4;
					gbc.gridy = 0;
					itemPanel.add(jta, gbc);
					gbc.gridx = 3;
					gbc.gridy = 1;
					gbc.gridwidth = 2;
					btnbit.addActionListener(controller);
					itemPanel.add(btnbit, gbc);
				} else {

					JLabel buyer = new JLabel(i.getLeader());

					gbc.gridx = 0;
					gbc.gridy = 0;
					gbc.gridheight = 2;
					itemPanel.add(name, gbc);
					gbc.gridx = 1;
					gbc.gridy = 0;
					gbc.gridheight = 2;
					itemPanel.add(descLabel, gbc);
					gbc.gridx = 2;
					gbc.gridy = 1;
					itemPanel.add(buyer, gbc);
					gbc.gridx = 2;
					gbc.gridy = 2;
					itemPanel.add(price, gbc);
				}
				this.add(itemPanel);
			}
		}

		JButton logout = new JButton("Deconnexion");
		logout.addActionListener(this.controller);
		this.add(logout);
	}
}
