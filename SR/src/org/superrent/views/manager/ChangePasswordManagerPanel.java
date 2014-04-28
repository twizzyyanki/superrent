package org.superrent.views.manager;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.superrent.controllers.ManagerController;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class ChangePasswordManagerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ManagerController managerController;
	private JPasswordField currentPass;
	private JPasswordField newPass;
	private JPasswordField confirmNewPass;
	private JLabel wrongInput;

	/**
	 * Create the panel.
	 */
	public ChangePasswordManagerPanel(ManagerController managerController) {
		this.managerController = managerController;
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
		btnConfirm.addActionListener(managerController);
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

