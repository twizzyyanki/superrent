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
import javax.swing.text.JTextComponent;

import org.superrent.controllers.SystemAdminController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchUserPanel extends JPanel {
	private SystemAdminController sac;
	private JTextField textFieldUserName;
	private JTextField textFieldPhoneNumber;


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
		
		textFieldUserName = new JTextField();
		add(textFieldUserName, "4, 4, left, default");
		textFieldUserName.setColumns(10);
		
		JLabel labelPhoneNumber = new JLabel("Phone Numer");
		add(labelPhoneNumber, "2, 6, fill, default");
		
		textFieldPhoneNumber = new JTextField();
		add(textFieldPhoneNumber, "4, 6, left, default");
		textFieldPhoneNumber.setColumns(10);
		
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

}
