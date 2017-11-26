package client.vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.app.IClient;

public class SubmitPanel extends JPanel {

	private IClient c;
	private JTextField txtItemName;
	private JTextField txtItemDescription;
	private JTextField txtItemPrice;
	private JTextField txtItemTime;
	private JButton btnPhoto;
	private JButton btnItemSubmission;

	public SubmitPanel(IClient current) {
		super();
		this.c = current;
		this.txtItemName = new JTextField();
		this.txtItemDescription = new JTextField();
		this.txtItemPrice = new JTextField();
		this.txtItemTime = new JTextField();
		this.btnPhoto = new JButton("Importer");
		this.btnItemSubmission = new JButton("Soumettre");

		this.setLayout(new GridBagLayout());

		ImageIcon image = new ImageIcon("src/picture/pouet.jpg");

		JLabel labelPicture = new JLabel(image);
		JLabel labelName = new JLabel("Nom : ");
		JLabel labelDescription = new JLabel("Description : ");
		JLabel labelPrice = new JLabel("Prix de base : ");
		JLabel labelTime = new JLabel("Date de fin : ");

		labelPicture.setPreferredSize(new Dimension(300, 350));
		labelName.setPreferredSize(new Dimension(100, 40));
		txtItemName.setPreferredSize(new Dimension(300, 40));
		labelDescription.setPreferredSize(new Dimension(100, 150));
		txtItemDescription.setPreferredSize(new Dimension(300, 150));
		labelPrice.setPreferredSize(new Dimension(100, 40));
		txtItemPrice.setPreferredSize(new Dimension(300, 40));
		labelTime.setPreferredSize(new Dimension(100, 40));
		txtItemTime.setPreferredSize(new Dimension(300, 40));

		// sJSeparator separator = new JSeparator();
		GridBagConstraints gbSubmission = new GridBagConstraints();

		// Picture
		gbSubmission.gridx = 0;
		gbSubmission.gridy = 0;
		gbSubmission.gridwidth = 1;
		gbSubmission.gridheight = 4;
		gbSubmission.insets = new Insets(5, 5, 5, 50);
		this.add(labelPicture, gbSubmission);
		gbSubmission.insets = new Insets(0, 0, 0, 0);

		// Name
		gbSubmission.gridx = 1;
		gbSubmission.gridheight = 1;
		this.add(labelName, gbSubmission);

		gbSubmission.gridx = 2;
		this.add(txtItemName, gbSubmission);

		// Description
		gbSubmission.gridx = 1;
		gbSubmission.gridy = 2;
		gbSubmission.gridwidth = 1;
		gbSubmission.gridheight = 1;
		this.add(labelDescription, gbSubmission);

		gbSubmission.gridx = 2;
		this.add(txtItemDescription, gbSubmission);

		// Price
		gbSubmission.gridx = 1;
		gbSubmission.gridy = 3;
		this.add(labelPrice, gbSubmission);

		gbSubmission.gridx = 2;
		gbSubmission.gridy = 3;
		this.add(txtItemPrice, gbSubmission);

		// Time
		gbSubmission.gridx = 1;
		gbSubmission.gridy = 4;
		this.add(labelTime, gbSubmission);

		gbSubmission.gridx = 2;
		gbSubmission.gridy = 4;
		this.add(txtItemTime, gbSubmission);

		gbSubmission.gridx = 0;
		gbSubmission.gridy = 4;
		gbSubmission.insets = new Insets(5, 5, 5, 50);
		this.add(btnPhoto, gbSubmission);
		gbSubmission.insets = new Insets(0, 0, 0, 0);

		// Separator
		/*
		 * mgbSubmission.gridx = 1; gbSubmission.gridy = 5; gbSubmission.gridwidth = 2;
		 * submissionPanel.add(separator, gbSubmission);
		 */

		// Button for submission
		gbSubmission.gridx = 2;
		gbSubmission.gridy = 6;
		this.add(btnItemSubmission, gbSubmission);
	}

}
