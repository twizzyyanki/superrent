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

import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.ValidationListener;
import org.netbeans.validation.api.ui.ValidationStrategy;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.superrent.controllers.SystemAdminController;
import org.superrent.controllers.ValidateAddUser;
import org.superrent.controllers.ValidateAddUserC;
import org.superrent.controllers.ValidateAddUserR;

public class AddUserPanel extends JPanel {
	private SystemAdminController sac;
	private JTextField textFieldName;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldMembershipNum;
	private JComboBox comboBox;
	private JLabel lblMembershipNumber;
	private JLabel addUserMessage;
	private ValidationGroup group;
	private ValidationGroup groupR;
	private ValidationGroup groupCM;
	private ValidationPanel xpanel;
	private JButton btnAdd;
	private ValidateAddUser va;
	private ValidateAddUserR vaR;
	private ValidateAddUserC vaC;
	private JLabel lblUserName;
	private JTextField textFieldUserName;
	/**
	 * Create the panel.
	 */
	public AddUserPanel(SystemAdminController sac) {
		this.sac = sac;
		va = new ValidateAddUser(this);
		vaR = new ValidateAddUserR(this, va);
		vaC = new ValidateAddUserC(this, va, vaR);
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
		
		lblMembershipNumber = new JLabel("Membership Number");
		lblMembershipNumber.setVisible(false);
		add(lblMembershipNumber, "2, 6, left, default");
		
		textFieldMembershipNum = new JTextField();
		textFieldMembershipNum.setVisible(false);
		textFieldMembershipNum.setColumns(10);
		textFieldMembershipNum.setName("Membership Number");
		add(textFieldMembershipNum, "4, 6, left, default");
		textFieldMembershipNum.getDocument().addDocumentListener(vaC);
		textFieldMembershipNum.getDocument().addDocumentListener(va);
		
		lblUserName = new JLabel("Username");
		lblUserName.setVisible(false);
		add(lblUserName, "2, 8, left, default");
		
		textFieldUserName = new JTextField();
		add(textFieldUserName, "4, 8, left, default");
		textFieldUserName.setVisible(false);
		textFieldUserName.setColumns(10);
		textFieldUserName.setName("User Name");
		textFieldUserName.getDocument().addDocumentListener(vaR);
		textFieldUserName.getDocument().addDocumentListener(va);
		
		
		JLabel lblName = new JLabel("Name");
		add(lblName, "2, 10, left, default");
		
		textFieldName = new JTextField();
		add(textFieldName, "4, 10, left, default");
		textFieldName.setColumns(10);
		textFieldName.setName("Name");
		textFieldName.getDocument().addDocumentListener(va);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		add(lblPhoneNumber, "2, 12, left, default");
		
		textFieldPhoneNumber = new JTextField();
		add(textFieldPhoneNumber, "4, 12, left, default");
		textFieldPhoneNumber.setColumns(10);
		textFieldPhoneNumber.setName("Phone Number");
		textFieldPhoneNumber.getDocument().addDocumentListener(va);
		
		JLabel lblAddress = new JLabel("Address");
		add(lblAddress, "2, 14, left, default");
		
		textFieldAddress = new JTextField();
		add(textFieldAddress, "4, 14, left, default");
		textFieldAddress.setColumns(10);
		textFieldAddress.setName("Address");
		textFieldAddress.getDocument().addDocumentListener(va);
		
		JLabel lblEmail = new JLabel("Email");
		add(lblEmail, "2, 16, left, default");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setName("Email");
		add(textFieldEmail, "4, 16, left, default");
		textFieldEmail.getDocument().addDocumentListener(va);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(sac);
		btnAdd.setEnabled(false);
		add(btnAdd, "4, 18, left, default");

		
		addUserMessage = new JLabel("");
		add(addUserMessage, "2, 22, 3, 1");
		
		
		xpanel = new ValidationPanel();
		xpanel.setInnerComponent(this);

		/* Validation group for customer */
		
		group = xpanel.getValidationGroup();
		group.add(textFieldName, StringValidators.REQUIRE_NON_EMPTY_STRING,
				StringValidators.NO_WHITESPACE);
		group.add(textFieldPhoneNumber, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_NUMBER);
		group.add(textFieldAddress, StringValidators.REQUIRE_NON_EMPTY_STRING);
		group.add(textFieldEmail, StringValidators.REQUIRE_NON_EMPTY_STRING,StringValidators.EMAIL_ADDRESS);
		
		
		
		/* Validation group for manager and clerk */
		
		groupR = new ValidationPanel().getValidationGroup();
		
		groupR.add(textFieldUserName, StringValidators.REQUIRE_NON_EMPTY_STRING,
				StringValidators.NO_WHITESPACE);
	
		
		/* Validation group for club member */
		groupCM = new ValidationPanel().getValidationGroup();
		//groupCM.add(groupR);
	
		groupCM.add(textFieldMembershipNum, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.REQUIRE_VALID_NUMBER);
	
	
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
	
	public void setUserName(boolean bl) {
		lblUserName.setVisible(bl);
		textFieldUserName.setVisible(bl);
	}
	
	public int getInputType(){
		return comboBox.getSelectedIndex();
	}
	
	public String getInputName(){
		return textFieldName.getText();
	}
	
	public String getInputPhone(){
		return textFieldPhoneNumber.getText();
	}
	
	public String getInputAddress(){
		return textFieldAddress.getText();
	}
	
	public String getInputEmail(){
		return textFieldEmail.getText();
	}
	
	public String getMembershipNo(){
		return textFieldMembershipNum.getText();
	}
	
	
	public JLabel getAddUserMessage() {
		return addUserMessage;
	}
	
	public ValidationGroup getGroup() {
		return group;
	}
	
	public ValidationGroup getGroupR() {
		return groupR;
	}
	
	public ValidationGroup getGroupCM() {
		return groupCM;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public ValidationPanel getXpanel() {
		return xpanel;
	}
	public JTextField getTextFieldMembershipNum() {
		return textFieldMembershipNum;
	}
	public JTextField getTextFieldUserName() {
		return textFieldUserName;
	}
	
	public ValidateAddUser getValidateAU() {
		return va;
	}
	public ValidateAddUserR getValidateAUR() {
		return vaR;
	}
	public ValidateAddUserC getValidateAUC() {
		return vaC;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}
	public JTextField getTextFieldPhoneNumber() {
		return textFieldPhoneNumber;
	}
	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}
	
	public void setGroup(ValidationGroup group){
		this.group = group; 
	}
	
	public void setGroupR(ValidationGroup groupR){
		this.groupR = groupR; 
	}
	
}
