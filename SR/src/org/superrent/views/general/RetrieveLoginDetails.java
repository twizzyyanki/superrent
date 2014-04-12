package org.superrent.views.general;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.superrent.controllers.LoginController;

public class RetrieveLoginDetails extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField emailField;
	private LoginController lc;
	private JLabel message;

	public JLabel getMessage() {
		return message;
	}

	/**
	 * Create the dialog.
	 */
	public RetrieveLoginDetails(LoginController lc) {		
		setTitle("Get Login Details");
		setType(Type.POPUP);
		setModal(true);
		setBounds(100, 100, 450, 152);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),}));
		{
			message = new JLabel("");
			contentPanel.add(message, "6, 2");
		}
		{
			JLabel lblEnterYourEmail = new JLabel("Enter your email");
			contentPanel.add(lblEnterYourEmail, "4, 4, right, default");
		}
		{
			emailField = new JTextField();
			contentPanel.add(emailField, "6, 4, fill, fill");
			emailField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Get Login Details");
				okButton.setActionCommand("OK");
				okButton.addActionListener(lc);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(lc);
				buttonPane.add(cancelButton);
			}
		}
		this.lc = lc;
	}

	public JTextField getEmailField() {
		return emailField;
	}
}
