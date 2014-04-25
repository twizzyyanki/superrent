package org.superrent.views.clubmember;


import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import org.superrent.controllers.ClubMemberController;

public class JUpdateProfile extends JPanel {

	private final ClubMemberController clubMemberController;
	private JTextField textPhone;
	private JTextField textName;
	private JTextArea textAddress;
	private JLabel updateInfo;
	private JTextField txtEmail;
	/**
	 * Create the panel.
	 */
	public JUpdateProfile(ClubMemberController clubMemberController) {
		this.clubMemberController = clubMemberController;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(20dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(80dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(18dlu;pref)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(40dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(11dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(13dlu;default):grow"),}));
		
		JLabel name = new JLabel("Name");
		add(name, "4, 4, center, default");
		
		textName = new JTextField();
		add(textName, "6, 4, fill, default");
		textName.setColumns(10);
		
		JLabel phoneNumber = new JLabel("Phone Number");
		add(phoneNumber, "4, 6, center, default");
		
		textPhone = new JTextField();
		add(textPhone, "6, 6, fill, default");
		textPhone.setColumns(10);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(clubMemberController);
		
		JLabel lblEmail = new JLabel("E-mail");
		add(lblEmail, "4, 8, center, default");
		
		txtEmail = new JTextField();
		add(txtEmail, "6, 8, fill, default");
		txtEmail.setColumns(10);
		
		JLabel address = new JLabel("Address");
		add(address, "4, 10, center, default");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "6, 10, fill, fill");
		
		textAddress = new JTextArea();
		scrollPane.setViewportView(textAddress);
		add(Update, "4, 12");
		
		updateInfo = new JLabel("");
		add(updateInfo, "4, 14, 3, 1");
		
		this.setVisible(true);

	}

	
	
	public JTextField getTextName() {
		return textName;
	}
	public JTextField getTextPhone() {
		return textPhone;
	}
	public JTextArea getTextAddress() {
		return textAddress;
	}

	public JLabel getUpdateInfo() {
		return updateInfo;
	}
	public JTextField getTxtEmail() {
		return txtEmail;
	}
}
