package org.superrent.views.clerk;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.superrent.controllers.ClerkController;

public class ChangePassword extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnConfirmPassword = new JButton("ConfirmPassword");

	/**
	 * Create the panel.
	 */
	public ChangePassword() {
		setLayout(new FormLayout(new ColumnSpec[] {
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
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		add(lblCurrentPassword, "8, 6");
		
		textField = new JTextField();
		add(textField, "12, 6, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password ");
		add(lblNewPassword, "8, 8");
		
		textField_1 = new JTextField();
		add(textField_1, "12, 8, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		add(lblConfirmNewPassword, "8, 10");
		
		textField_2 = new JTextField();
		add(textField_2, "12, 10, fill, default");
		textField_2.setColumns(10);
		add(btnConfirmPassword, "12, 14");
	}
	
	public void changePasswordActionListener(ClerkController clerk)
	{
		btnConfirmPassword.addActionListener(clerk);
	}
}
