package org.superrent.views.general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.superrent.controllers.UserController;

public class AddUserSample extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField address;
	private final UserController uc;	

	/**
	 * Create the frame.
	 */
	public AddUserSample() {
		uc = new UserController(this);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddUser = new JLabel("ADD USER");
		contentPane.add(lblAddUser, "14, 2, center, default");
		
		JLabel lblMessage = new JLabel("");
		contentPane.add(lblMessage, "14, 4, center, default");
		
		JLabel lblName = new JLabel("Name:");
		contentPane.add(lblName, "12, 6, left, default");
		
		name = new JTextField();
		contentPane.add(name, "14, 6, fill, default");
		name.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		contentPane.add(lblEmail, "12, 8, left, default");
		
		email = new JTextField();
		contentPane.add(email, "14, 8, fill, default");
		email.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		contentPane.add(lblPhoneNumber, "12, 10, left, default");
		
		address = new JTextField();
		contentPane.add(address, "14, 10, fill, default");
		address.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		contentPane.add(lblAddress, "12, 12");
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, "14, 12, fill, fill");
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(uc);
		contentPane.add(btnAddUser, "14, 14, fill, default");
		
		
	}

}
