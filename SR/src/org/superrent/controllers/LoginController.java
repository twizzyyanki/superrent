package org.superrent.controllers;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.UIManager;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
import org.superrent.application.SendMail;
import org.superrent.daos.UserDAO;
import org.superrent.entities.User;
import org.superrent.views.clubmember.ClubMember;
import org.superrent.views.general.Login;
import org.superrent.views.general.RetrieveLoginDetails;
import org.superrent.views.manager.ManagerHome;
import org.superrent.views.superadmin.SystemAdmin;

public class LoginController implements ActionListener {

	private Login l;
	private ClubMember c;
	private SystemAdmin s;
	RetrieveLoginDetails jd;
	// private Clerk k;	

	public int login(String username, String password) {
		Map<String, String> user = null;
		try {
			user = UserDAO.loginUser(username, password).get(0);
			if (user != null) {
				String privilege = user.get("type");
				System.out.println(privilege);
				LoggedInUser.setPrivilege(Integer.parseInt(privilege));
				return Integer.valueOf(privilege);
			}
		} catch (Exception e) {
			l.getLoginMessage().setText(
					"Login failed. Please check your credentials");
			System.out.println("Validation failed");
			return 0;
		}
		return 0;
	}

	public boolean retriveUserDetails(String email) {

		return false;
	}

	// @Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Login")) {
			String username = l.getUsername().getText();
			String password = l.getPassword().getText();
			int status = login(username, password);
			if (status > 0) {
				l.dispose();
				if (status == 1) {
					System.out.println("Hello there");
					ClubMember c = new ClubMember();
					c.setLocationRelativeTo(null);
					c.setVisible(true);
				}
				if (status == 2) {
					System.out.println("Missing. We are waiting");
				}
				if (status == 3) {
					ManagerHome m = new ManagerHome();
					m.setLocationRelativeTo(null);
					m.setVisible(true);
				}
				if (status == 4) {
					SystemAdmin s = new SystemAdmin();
					s.setLocationRelativeTo(null);
					s.setVisible(true);
				}
			} else {
				l.getLoginMessage().setText(
						"Login failed. Please check your credentials");
			}
		}

		if (e.getActionCommand().equals("Forgot Login")) {
			System.out.println("Getting here");
			jd = new RetrieveLoginDetails(this);
			jd.setLocationRelativeTo(null);
			jd.setVisible(true);
		}

		if (e.getActionCommand().equals("Cancel")) {
			System.out.println("Getting here");
			jd.dispose();
		}

		if (e.getActionCommand().equals("OK")) {
			System.out.println("Getting here - OK");
			String email = jd.getEmailField().getText();
			try {
				User u = UserDAO.findUserByEmail(email);
				System.out.println(u);
				if (u.getUid() != null) {
					String message = "Your new password is 34399034";
					SendMail sm = new SendMail(u.getEmail(), "Account Details",
							message);
					jd.getMessage()
							.setText(
									"Your username and a new password has been sent to your mail");
				} else {
					jd.getMessage().setText(
							"Email not found on our system. Please try again");
				}
			} catch (Exception f) {
				jd.getMessage().setText(
						"Email could not be sent. Please try again later");
			}
		}

		if (e.getActionCommand().equals("Log Out")) {

			// perform other login functions

			Frame[] allFrames = Frame.getFrames();
			for (Frame frame : allFrames) {
				if (frame.isVisible()) {
					frame.dispose();
				}
			}
			l = new Login();
			l.setLocationRelativeTo(null);
			l.setVisible(true);
		}
	}

	public LoginController(Login l) {
		this.l = l;
	}

	public LoginController(ClubMember c) {
		this.c = c;
	}

	public LoginController(SystemAdmin s) {
		this.s = s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login l = new Login();
					l.setLocationRelativeTo(null);
					// LoginController lc = new LoginController();
					l.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
