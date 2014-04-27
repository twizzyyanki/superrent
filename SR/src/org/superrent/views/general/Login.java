package org.superrent.views.general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.superrent.controllers.LoginController;
import org.netbeans.validation.api.ui.ValidationListener;

import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * This class is the login view. It contains two text fields: username and
 * password.
 * <p>
 * It interacts with login controller.
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private final LoginController lc;
	private JLabel loginMessage;
	private JButton login;
	private ValidationGroup group;

	/**
	 * Create the login frame with subTitle "SuperRent"
	 */
	public Login() {
		setBackground(UIManager.getColor("nimbusBlueGrey"));
		setTitle("SuperRent");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lc = new LoginController(this);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("nimbusBlueGrey"));

		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(70dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.PREF_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		JLabel lblLoginToSuperrent = new JLabel("LOGIN TO SUPERRENT");
		lblLoginToSuperrent.setFont(new Font("SansSerif", Font.PLAIN, 21));
		panel.add(lblLoginToSuperrent, "1, 2, 14, 1, center, default");

		loginMessage = new JLabel("");
		panel.add(loginMessage, "7, 4, 6, 1, center, default");

		JLabel lblUsername = new JLabel("Username:");
		panel.add(lblUsername, "4, 6");

		username = new JTextField();
		username.setName("Username");
		username.getDocument().addDocumentListener(lc);
		username.setPreferredSize(new Dimension(12, 35));
		panel.add(username, "7, 6, 6, 1, fill, fill");
		username.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		panel.add(lblPassword, "4, 10");

		password = new JPasswordField();
		password.setName("Password");
		password.getDocument().addDocumentListener(lc);
		password.setPreferredSize(new Dimension(12, 35));
		panel.add(password, "7, 10, 6, 1, fill, default");
		password.setColumns(10);
				
						login = new JButton("Login");
						//login.setIcon(new ImageIcon(Login.class.getResource("/res/icons/addons/64/admin_lock_open.png")));
						login.addActionListener(lc);
						login.setEnabled(false);
						panel.add(login, "8, 12, left, default");

		ValidationPanel xpanel = new ValidationPanel();
		xpanel.setBackground(UIManager.getColor("nimbusBlueGrey"));
		xpanel.setInnerComponent(panel);
		group = xpanel.getValidationGroup();
		group.add(username, StringValidators.REQUIRE_NON_EMPTY_STRING,
				StringValidators.NO_WHITESPACE);
		group.add(password, StringValidators.REQUIRE_NON_EMPTY_STRING);
				
				JButton makeReservation = new JButton("Make Reservation");
				panel.add(makeReservation, "10, 12, left, default");
				makeReservation.addActionListener(lc);
				
						JButton forgotLogin = new JButton("Forgot Login Details");
						forgotLogin.setActionCommand("Forgot Login");
						forgotLogin.addActionListener(lc);
						forgotLogin.setSize(new Dimension(150, 150));
						panel.add(forgotLogin, "12, 12, left, default");
		contentPane.add(xpanel, BorderLayout.CENTER);
	}

	/**
	 * @return
	 */
	public JTextField getUsername() {
		return username;
	}

	/**
	 * @return
	 */
	public JTextField getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public JLabel getLoginMessage() {
		return loginMessage;
	}

	/**
	 * @return
	 */
	public ValidationGroup getGroup() {
		return group;
	}

	/**
	 * @return
	 */
	public JButton getLogin() {
		return login;
	}
}
