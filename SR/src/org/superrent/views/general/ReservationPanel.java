package org.superrent.views.general;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import org.superrent.controllers.MakeReservationController;

public class ReservationPanel extends JPanel {
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private final MakeReservationController mrc;
	/**
	 * Create the panel.
	 */
	public ReservationPanel(MakeReservationController mrc) {
		this.mrc = mrc;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(89dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(100dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default):grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(22dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblAdress = new JLabel("Please enter user ID and password to reserve as a clubmember:");
		add(lblAdress, "4, 4, 3, 1");
		
		JLabel lblUserId = new JLabel("User ID:");
		add(lblUserId, "4, 6, center, default");
		
		userTextField = new JTextField();
		add(userTextField, "6, 6, fill, default");
		userTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "4, 8, center, default");
		
		passwordField = new JPasswordField();
		add(passwordField, "6, 8, fill, default");
		
		JButton btnClubmember = new JButton("Clubmember Reserve");
		btnClubmember.addActionListener(mrc);
		add(btnClubmember, "6, 10, fill, default");
		
		
		JLabel lblInformation = new JLabel("Please enter the following information to reserve as a guest");
		add(lblInformation, "4, 12, 3, 1, left, default");
		
		JLabel lblName = new JLabel("Name:");
		add(lblName, "4, 14, center, default");
		
		nameTextField = new JTextField();
		add(nameTextField, "6, 14");
		nameTextField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		add(lblAddress, "4, 16, center, default");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "6, 16, fill, fill");
		
		JTextArea addressTextArea = new JTextArea();
		scrollPane.setViewportView(addressTextArea);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		add(lblPhoneNo, "4, 18, center, default");
		
		phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		add(phoneTextField, "6, 18, fill, default");
		
		JLabel lblEmail = new JLabel("E-mail:");
		add(lblEmail, "4, 20, center, default");
		
		emailTextField = new JTextField();
		add(emailTextField, "6, 20, fill, default");
		emailTextField.setColumns(10);
		
		JButton btnGuest = new JButton("Guest Reserve");
		btnGuest.addActionListener(mrc);
		add(btnGuest, "6, 22, fill, default");

	}

}
