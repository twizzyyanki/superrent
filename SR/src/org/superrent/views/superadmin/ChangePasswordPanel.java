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
	private JPasswordField currentPass;
	private JPasswordField newPass;
	private JPasswordField confirmNewPass;
	private JLabel wrongInput;

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
				ColumnSpec.decode("max(131dlu;default)"),
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
				RowSpec.decode("max(66dlu;default)"),}));
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		add(lblCurrentPassword, "4, 4, right, default");
		
		currentPass = new JPasswordField();
		currentPass.setMaximumSize(new Dimension(5, 10));
		currentPass.setMinimumSize(new Dimension(5, 10));
		add(currentPass, "6, 4");
		
		JLabel lblNewPassword = new JLabel("New Password");
		add(lblNewPassword, "4, 6, right, default");
		
		newPass = new JPasswordField();
		add(newPass, "6, 6, fill, default");
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		add(lblConfirmNewPassword, "4, 8, right, default");
		
		confirmNewPass = new JPasswordField();
		add(confirmNewPass, "6, 8");
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setActionCommand("ConfirmPassword");
		btnConfirm.addActionListener(sac);
		add(btnConfirm, "6, 12, left, default");
		
		wrongInput = new JLabel("");
		add(wrongInput, "6, 14, fill, fill");
		

	}

	public JPasswordField getCurrentPass() {
		return currentPass;
	}
	public JPasswordField getNewPass() {
		return newPass;
	}
	public JPasswordField getConfirmNewPass() {
		return confirmNewPass;
	}
	public JLabel getWrongInput() {
		return wrongInput;
	}
}
