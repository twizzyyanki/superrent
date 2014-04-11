package org.superrent.views.superadmin;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JButton;

import org.superrent.controllers.SystemAdminController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchUserPanel extends JPanel {
	private SystemAdminController sac;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the panel.
	 */
	public SearchUserPanel(SystemAdminController sac) {
		this.sac = sac;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("39px"),
				ColumnSpec.decode("130px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel labelUserName = new JLabel("User Name");
		add(labelUserName, "2, 4, fill, default");
		
		textField = new JTextField();
		add(textField, "4, 4, left, default");
		textField.setColumns(10);
		
		JLabel labelPhoneNumber = new JLabel("Phone Numer");
		add(labelPhoneNumber, "2, 6, fill, default");
		
		textField_1 = new JTextField();
		add(textField_1, "4, 6, left, default");
		textField_1.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(sac);
	
		add(btnConfirm, "4, 8, left, default");
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
}
