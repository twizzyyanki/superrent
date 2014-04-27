package org.superrent.views.clerk;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.superrent.controllers.ClerkController;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.ScrollPaneConstants;



public class AddCM extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	JButton btnAddMember;
	private JLabel lblUserId;
	private JLabel lblMembershipNumber;
	
	/**
	 * Create the panel.
	 */
	
	public AddCM()
	{
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("31px"),
				ColumnSpec.decode("99px"),
				ColumnSpec.decode("36px"),
				ColumnSpec.decode("93px:grow"),
				ColumnSpec.decode("151px"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("2px"),},
			new RowSpec[] {
				RowSpec.decode("57px"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				RowSpec.decode("23px"),
				RowSpec.decode("14px"),}));
		
		lblUserId = new JLabel("User ID");
		add(lblUserId, "2, 4");
		
		setTextField(new JTextField());
		getTextField().setColumns(10);
		add(textField, "4, 4, left, top");
		
		lblMembershipNumber = new JLabel("Membership Number");
		add(lblMembershipNumber, "2, 8");
		setTextField_1(new JTextField());
		getTextField_1().setColumns(10);
		add(getTextField_1(), "4, 8, left, fill");
		
		btnAddMember = new JButton("Add Member");
		add(btnAddMember, "4, 11, fill, fill");
	}
	public void addmemberActionListener(ClerkController clerk)
	{
		btnAddMember.addActionListener(clerk);
	}
	
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
}
