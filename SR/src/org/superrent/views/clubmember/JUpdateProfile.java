package org.superrent.views.clubmember;


import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.superrent.controllers.ClubMemberController;

public class JUpdateProfile extends JPanel {

	private final ClubMemberController clubMemberController;
	private JTextField textPhone;
	private JTextField textName;
	private JTextField textAddress1;
	private JTextField textAddress2;
	/**
	 * Create the panel.
	 */
	public JUpdateProfile(ClubMemberController clubMemberController) {
		this.clubMemberController = clubMemberController;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(20dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.BUTTON_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
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
		
		JLabel address = new JLabel("Address");
		add(address, "4, 8, center, default");
		
		textAddress1 = new JTextField();
		add(textAddress1, "6, 8, fill, default");
		textAddress1.setColumns(10);
		
		textAddress2 = new JTextField();
		add(textAddress2, "6, 10, fill, default");
		textAddress2.setColumns(10);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(clubMemberController);
		add(Update, "4, 14");
		
		this.setVisible(true);

	}

}
