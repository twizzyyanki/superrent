package org.superrent.views.superadmin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.superrent.controllers.SystemAdminController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollPane;

public class SearchUserPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SystemAdminController sac;
	private JTextField textFieldUserName;
	private JTextField textFieldPhoneNumber;
	private JTable table;


	/**
	 * Create the panel.
	 */
	public SearchUserPanel(SystemAdminController sac) {
		this.sac = sac;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("225px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("166px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel labelUserName = new JLabel("User Name");
		add(labelUserName, "1, 1, fill, center");
		
		textFieldUserName = new JTextField();
		add(textFieldUserName, "3, 1, left, top");
		textFieldUserName.setColumns(10);
		
		JLabel labelPhoneNumber = new JLabel("Phone Numer");
		add(labelPhoneNumber, "1, 3, fill, center");
		
		textFieldPhoneNumber = new JTextField();
		add(textFieldPhoneNumber, "3, 3, left, top");
		textFieldPhoneNumber.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(sac);
		
			add(btnConfirm, "3, 5, left, top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "1, 9, 13, 1, fill, fill");
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Name", "Email", "Phone Number", "Type", "Address"
			}
		));
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		JPanel SearchUserPanel = new JPanel(); 
		SearchUserPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("56px"),
				ColumnSpec.decode("89px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
	
	}

	public String getInputName(){
		return textFieldUserName.getText();
	}
	
	public String getInputPhone(){
		return textFieldPhoneNumber.getText();
	}
	
	public JTextField getTextFieldUserName() {
		return textFieldUserName;
	}
	public JTextField getTextFieldPhoneNumber() {
		return textFieldPhoneNumber;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
