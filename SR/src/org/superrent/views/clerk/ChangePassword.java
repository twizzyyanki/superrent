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
import javax.swing.JPasswordField;

public class ChangePassword extends JPanel {
	private JButton btnConfirmPassword = new JButton("ConfirmPassword");
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

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
		
		setPasswordField(new JPasswordField());
		add(getPasswordField(), "12, 6, fill, default");
		
		JLabel lblNewPassword = new JLabel("New Password ");
		add(lblNewPassword, "8, 8");
		
		setPasswordField_1(new JPasswordField());
		add(getPasswordField_1(), "12, 8, fill, default");
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		add(lblConfirmNewPassword, "8, 10");
		
		setPasswordField_2(new JPasswordField());
		add(getPasswordField_2(), "12, 10, fill, default");
		add(btnConfirmPassword, "12, 14");
	}
	
	public void changePasswordActionListener(ClerkController clerk)
	{
		btnConfirmPassword.addActionListener(clerk);
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.passwordField_1 = passwordField_1;
	}

	public JPasswordField getPasswordField_2() {
		return passwordField_2;
	}

	public void setPasswordField_2(JPasswordField passwordField_2) {
		this.passwordField_2 = passwordField_2;
	}
}
