package org.superrent.views.general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;

import org.superrent.controllers.LoginController;

import java.awt.Font;

/**
 * This class is the login view.
 * It contains two text fields: username and password.
 * <p>
 * It interacts with login controller.
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private final LoginController lc;
	private JLabel loginMessage;

	/**
	 * Create the login frame with subTitle "SuperRent"
	 */
	public Login() {
		setTitle("SuperRent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lc = new LoginController(this);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(110dlu;default):grow"),
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblLoginToSuperrent = new JLabel("LOGIN TO SUPERRENT");
		lblLoginToSuperrent.setFont(new Font("SansSerif", Font.PLAIN, 21));
		panel.add(lblLoginToSuperrent, "5, 2, 4, 1");
		
		loginMessage = new JLabel("");
		panel.add(loginMessage, "8, 4, left, default");
		
		JLabel lblUsername = new JLabel("Username:");
		panel.add(lblUsername, "4, 6");
		
		username = new JTextField();
		panel.add(username, "7, 6, 3, 1, fill, default");
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panel.add(lblPassword, "4, 10");
		
		password = new JTextField();
		panel.add(password, "7, 10, 3, 1, fill, default");
		password.setColumns(10);
		
		JButton login = new JButton("Login");
		login.addActionListener(lc);
		panel.add(login, "7, 14, 3, 1");
	}

	public JTextField getUsername() {
		return username;
	}

	public JTextField getPassword() {
		return password;
	}

	public JLabel getLoginMessage() {
		return loginMessage;
	}
}
