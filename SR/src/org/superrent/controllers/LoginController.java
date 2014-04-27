package org.superrent.controllers;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.superrent.application.LoggedInUser;
import org.superrent.application.SendMail;
import org.superrent.daos.UserDAO;
import org.superrent.entities.MakeReservation;
import org.superrent.entities.User;
import org.superrent.views.clerk.ClerkHome;
import org.superrent.views.clubmember.ClubMember;
import org.superrent.views.general.Login;
import org.superrent.views.general.MakeReservationPage;
import org.superrent.views.general.RetrieveLoginDetails;
import org.superrent.views.manager.ManagerHome;
import org.superrent.views.superadmin.SystemAdmin;

/**
 * @author 
 * 
 */
public class LoginController implements ActionListener, DocumentListener {

	private Login l;
	private ClubMember c;
	private SystemAdmin s;
	private ManagerHome m;
	RetrieveLoginDetails jd;
	private ClerkHome k;
	//static JPanel oldpanel;

	/**
	 * Returns the privilege of the user that wants to login if the login is
	 * successful
	 * 
	 * @param username
	 *            username of the user
	 * @param password
	 *            password of the user
	 * @return privilege of the user that wants to login. Returns -1 if login is
	 *         unsuccessful
	 */
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

	/**
	 * Resets the password of the user and sends the username and new password
	 * to the user's email
	 * 
	 * @param emailaddress
	 *        of the user
	 * @return true if the email address is found and false if the email address
	 *         is not found
	 */
	public boolean retriveUserDetails(String email) {

		return false;
	}

	// @Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Login")) {
			String username = l.getUsername().getText();
			String password = org.apache.commons.codec.digest.DigestUtils.md5Hex(l.getPassword().getText());
			int status = login(username, password);
			if (status > 0) {
				l.dispose();
				if (status == 1) {
					System.out.println("Club Member logging in");
					ClubMember c = new ClubMember();
					c.setLocationRelativeTo(null);
					c.setVisible(true);
				}
				if (status == 2) {
					System.out.println("Clerk logging in");
					ClerkHome k = new ClerkHome();
					//oldpanel = (JPanel) k.getContentPane();
					k.setLocationRelativeTo(null);
					k.setVisible(true);
				}
				if (status == 3) {
					System.out.println("Manager loggin in");
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
			System.out.println("OPening forgot login JDialog");
			jd = new RetrieveLoginDetails(this);
			jd.setLocationRelativeTo(null);
			jd.setVisible(true);
		}

		if (e.getActionCommand().equals("Cancel")) {
			System.out.println("Cancelled the RetrieveLogin Dialog");
			jd.dispose();
		}

		if (e.getActionCommand().equals("OK")) {
			System.out.println("Getting here - OK");
			String email = jd.getEmailField().getText();
			try {
				User u = UserDAO.findUserByEmail(email);
				System.out.println(u);
				if (u.getUid() != null) {
					String newPass = UserDAO.changePassword(u);
					String message = "Your username is " + u.getRegUser().getUsername() + ". Your new password is " + newPass;
					SendMail sm = new SendMail(u.getEmail(), "Account Details",
							message);
					jd.getMessage()
							.setText(
									"Your username/a new password has been sent to your mail");
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
		
		if(e.getActionCommand().equals("Make Reservation")){
			MakeReservationPage mr = new MakeReservationPage();
			mr.setLocationRelativeTo(null);
			mr.setVisible(true);
			l.dispose();
		}
	}

	/**
	 * constructor that accepts the Login view in order to manage the events on
	 * it
	 * 
	 * @param login view
	 *            instance of the Login window
	 */
	public LoginController(Login l) {
		this.l = l;
	}

	/**
	 * @param c
	 */
	public LoginController(ClubMember c) {
		this.c = c;
	}

	/**
	 * constructor that accepts the System Administrator view in order to manage
	 * the events on it
	 * 
	 * @param instance
	 *            of the SystemAdmin window
	 */
	public LoginController(SystemAdmin s) {
		this.s = s;
	}

	/**
	 * @param m
	 */
	public LoginController(ManagerHome m) {
		this.m = m;
	}

	/**
	 * @param k
	 */
	public LoginController(ClerkHome k) {
		this.k = k;
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

	// @Override
	public void changedUpdate(DocumentEvent de) {
		checkValidation();
	}

	// @Override
	public void insertUpdate(DocumentEvent de) {
		checkValidation();
	}

	// @Override
	public void removeUpdate(DocumentEvent de) {
		checkValidation();
	}

	private void checkValidation() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Problem validateAll = l.getGroup().performValidation();
				// System.out.println("validate all is  " + validateAll);
				if (validateAll == null) {
					l.getLogin().setEnabled(true);
					l.revalidate();
					l.repaint();
					// System.out.println("Getting here");
				} else {
					if (validateAll.isFatal()) {
						l.getLogin().setEnabled(false);
					}
				}

			}
		});
	}

}
