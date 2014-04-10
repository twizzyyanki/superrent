package org.superrent.views.general;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Dimension;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblSuperrentLoginScreen;
	private JPanel panel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameJTF;
	private JButton btnLogin;
	private JPasswordField passwordJTF;
	private JLabel loginMessage;

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setResizable(false);
		setTitle("SuperRent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.lblSuperrentLoginScreen = new JLabel("LOGIN TO SUPERRENT");
		this.lblSuperrentLoginScreen
				.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblSuperrentLoginScreen.setFont(new Font("DejaVu Sans", Font.BOLD,
				16));
		this.contentPane.add(this.lblSuperrentLoginScreen, BorderLayout.NORTH);

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		
		loginMessage = new JLabel("");
		panel.add(loginMessage, "cell 3 1");

		this.lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		this.panel.add(this.lblUsername, "cell 1 2");

		this.usernameJTF = new JTextField();
		usernameJTF.setPreferredSize(new Dimension(12, 40));
		this.panel.add(this.usernameJTF, "cell 3 2,growx");
		this.usernameJTF.setColumns(10);

		this.lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		this.panel.add(this.lblPassword, "cell 1 4");

		this.passwordJTF = new JPasswordField();
		passwordJTF.setPreferredSize(new Dimension(12, 40));
		this.panel.add(this.passwordJTF, "cell 3 4,growx");

		this.btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(90, 40));
		this.panel.add(this.btnLogin, "cell 3 6");
	}

	public void setUsernameJTF(String text) {
		this.usernameJTF.setText(text);
	}

	public String getUsernameJTF() {
		return usernameJTF.getText();
	}

	public String getPasswordJTF() {
		return passwordJTF.getText();
	}

	public void setPasswordJTF(String text) {
		this.passwordJTF.setText(text);
	}

	public String getLoginMessage() {
		return loginMessage.getText();
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage.setText(loginMessage);
	}

	public void addLoginButtonActionListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
	}

}
