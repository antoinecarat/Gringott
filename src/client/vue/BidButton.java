package client.vue;

import javax.swing.JButton;
import javax.swing.JTextArea;

import client.app.Item;

public class BidButton extends JButton {

	private Item related;
	private JTextArea source;
	
	public BidButton(String cmd, Item i, JTextArea jta) {
		super(cmd);
		this.related = i;
		this.source = jta;
	}
	
	public Item getItem(){
		return this.related;
	}
	
	public String getContent(){
		return this.source.getText();
	}

	
	
}
