package org.superrent.views.clubmember;


import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.superrent.controllers.ClubMemberController;
import org.superrent.controllers.ValidateJChangePassword;

import java.awt.Color;
import javax.swing.JPasswordField;

public class JChangePassword extends JPanel {
	private ClubMemberController clubMemberController;
	private JLabel wrongInput;
	private JPasswordField textCurrentPassword;
	private JPasswordField textNewPassword;
	private JPasswordField textConfriPassword;
	private JButton Confirm;
	
	/**
	 * Create the panel.
	 */
	public JChangePassword(ClubMemberController clubMemberController) {
		this.clubMemberController = clubMemberController;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(20dlu;pref)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(106dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(18dlu;pref)"),
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
				RowSpec.decode("max(56dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblCurrent = new JLabel("Current Password:");
		add(lblCurrent, "4, 4, right, default");
		
		textCurrentPassword = new JPasswordField();
		textCurrentPassword.setName("Current Password");
		textCurrentPassword.getDocument().addDocumentListener(new ValidateJChangePassword(this));
		add(textCurrentPassword, "6, 4, fill, default");
		
		JLabel lblNewPassword = new JLabel("New Password:");
		add(lblNewPassword, "4, 6, right, default");
		
		textNewPassword = new JPasswordField();
		textNewPassword.setName("New Password");
		textNewPassword.getDocument().addDocumentListener(new ValidateJChangePassword(this));
		add(textNewPassword, "6, 6, fill, default");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		add(lblConfirmPassword, "4, 8, right, default");
		
		Confirm = new JButton("Confirm");
		Confirm.setEnabled(false);
		Confirm.addActionListener(clubMemberController);
		
		textConfriPassword = new JPasswordField();
		textConfriPassword.setName("Confirm Password");
		textConfriPassword.getDocument().addDocumentListener(new ValidateJChangePassword(this));
		add(textConfriPassword, "6, 8, fill, default");
		add(Confirm, "4, 12");
		
		wrongInput = new JLabel("");
		add(wrongInput, "6, 14, center, default");
		
		this.setVisible(true);

	}

	public JTextField getTextCurrentPassword() {
		return textCurrentPassword;
	}
	public JLabel getWrongInput() {
		return wrongInput;
	}
	public JTextField getTextNewPassword() {
		return textNewPassword;
	}
	public JTextField getTextConfriPassword() {
		return textConfriPassword;
	}
	public JButton getConfirmButton() {
		return Confirm;
	}
}
