package org.superrent.views.superadmin;

import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import org.superrent.controllers.SystemAdminController;

import java.awt.Dimension;

public class ChangePasswordPanel extends JPanel {
	private SystemAdminController sac;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	/**
	 * Create the panel.
	 */
	public ChangePasswordPanel(SystemAdminController sac) {
		this.sac = sac;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(102dlu;default)"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		add(lblCurrentPassword, "4, 4, right, default");
		
		passwordField = new JPasswordField();
		passwordField.setMaximumSize(new Dimension(5, 10));
		passwordField.setMinimumSize(new Dimension(5, 10));
		add(passwordField, "6, 4");
		
		JLabel lblNewPassword = new JLabel("New Password");
		add(lblNewPassword, "4, 6, right, default");
		
		passwordField_1 = new JPasswordField();
		add(passwordField_1, "6, 6, fill, default");
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		add(lblConfirmNewPassword, "4, 8, right, default");
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setActionCommand("ConfirmPassword");
		btnConfirm.addActionListener(sac);
		
		passwordField_2 = new JPasswordField();
		add(passwordField_2, "6, 8");
		add(btnConfirm, "6, 10, left, default");

	}

}
