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
	private JScrollPane scrollPane;


	/**
	 * Create the panel.
	 */
	public SearchUserPanel(SystemAdminController sac) {
		this.sac = sac;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(27dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
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
				RowSpec.decode("25px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("25px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("82px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel labelUserName = new JLabel("User Name");
		add(labelUserName, "3, 1, fill, center");
		
		textFieldUserName = new JTextField();
		add(textFieldUserName, "5, 1, left, fill");
		textFieldUserName.setColumns(10);
		
		JLabel labelPhoneNumber = new JLabel("Phone Numer");
		add(labelPhoneNumber, "3, 3, fill, center");
		
		textFieldPhoneNumber = new JTextField();
		add(textFieldPhoneNumber, "5, 3, left, fill");
		textFieldPhoneNumber.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(sac);
		
			add(btnConfirm, "5, 5, left, fill");
		
		scrollPane = new JScrollPane();
		add(scrollPane, "3, 9, 13, 1, fill, fill");
		scrollPane.setVisible(false);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Name", "Email", "Phone Number", "Type", "Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(94);
		table.getColumnModel().getColumn(1).setPreferredWidth(157);
		table.getColumnModel().getColumn(2).setPreferredWidth(121);
		table.getColumnModel().getColumn(3).setPreferredWidth(66);
		table.getColumnModel().getColumn(4).setPreferredWidth(261);
		scrollPane.setViewportView(table);
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
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
}
