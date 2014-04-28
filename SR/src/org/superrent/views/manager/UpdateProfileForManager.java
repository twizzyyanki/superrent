package org.superrent.views.manager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.superrent.controllers.ManagerController;
import org.superrent.controllers.SystemAdminController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class UpdateProfileForManager extends JPanel{

	private ManagerController managerController;
	private JTextField textPhone;
	private JTextField textName;
	private JTextField textEmail;
	private JTextArea textAddress;
	private JLabel updateInfo;

	/**
	 * Create the panel.
	 */
	public UpdateProfileForManager(ManagerController managerController) {
		this.managerController = managerController;
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
		add(name, "4, 4, right, default");

		textName = new JTextField();
		add(textName, "6, 4, fill, default");
		textName.setColumns(10);

		JLabel phoneNumber = new JLabel("Phone Number");
		add(phoneNumber, "4, 6, right, default");

		textPhone = new JTextField();
		add(textPhone, "6, 6, fill, default");
		textPhone.setColumns(10);

		JLabel email = new JLabel("E-mail");
		add(email, "4, 8, right, default");
		
		textEmail = new JTextField();
		add(textEmail, "6, 8, fill, default");
		textEmail.setColumns(10);
		
		JLabel address = new JLabel("Address");
		add(address, "4, 10, right, default");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "6, 10, fill, fill");
		
		textAddress = new JTextArea();
		scrollPane.setViewportView(textAddress);

		JButton Update = new JButton("Update");
		Update.addActionListener(managerController);
		add(Update, "6, 12, left, default");
		
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
		return textEmail;
	}
}
