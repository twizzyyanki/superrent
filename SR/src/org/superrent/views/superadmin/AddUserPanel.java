package org.superrent.views.superadmin;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.superrent.controllers.SystemAdminController;

public class AddUserPanel extends JPanel {
	private SystemAdminController sac;
	private JTextField textFieldUserName;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldMembershipNum;
	private JComboBox comboBox;
	private JLabel lblMembershipNumber;
	/**
	 * Create the panel.
	 */
	public AddUserPanel(SystemAdminController sac) {
		this.sac = sac;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("40px"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(107dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblUserType = new JLabel("User Type");
		add(lblUserType, "2, 4, left, default");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Club Member", "Clerk", "Manager", "System Administrator"}));
		add(comboBox, "4, 4, left, default");
		comboBox.addActionListener(sac);
		
		
		
		JLabel lblUserName = new JLabel("User Name");
		add(lblUserName, "2, 6, left, default");
		
		textFieldUserName = new JTextField();
		add(textFieldUserName, "4, 6, left, default");
		textFieldUserName.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		add(lblPhoneNumber, "2, 8, left, default");
		
		textFieldPhoneNumber = new JTextField();
		add(textFieldPhoneNumber, "4, 8, left, default");
		textFieldPhoneNumber.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "2, 10, left, default");
		
		textFieldAddress = new JTextField();
		add(textFieldAddress, "4, 10, left, default");
		textFieldAddress.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "2, 12, left, default");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		add(textFieldEmail, "4, 12, left, default");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(sac);
		
		lblMembershipNumber = new JLabel("Membership Number");
		lblMembershipNumber.setVisible(false);
		add(lblMembershipNumber, "2, 14, right, default");
		
		textFieldMembershipNum = new JTextField();
		textFieldMembershipNum.setVisible(false);
		textFieldMembershipNum.setColumns(10);
		add(textFieldMembershipNum, "4, 14, left, default");
		add(btnAdd, "4, 16, left, default");
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	/**
	 * This method set the visibility of the label and text field for membership number. 
	 * @param bl
	 */
	public void setMembershipNumber(boolean bl) {
		lblMembershipNumber.setVisible(bl);
		textFieldMembershipNum.setVisible(bl);
	}
}
