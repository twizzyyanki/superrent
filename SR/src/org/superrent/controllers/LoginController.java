package org.superrent.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.UIManager;

import org.superrent.application.DatabaseConnection;
import org.superrent.application.LoggedInUser;
import org.superrent.daos.UserDAO;
import org.superrent.entities.User;
import org.superrent.views.clubmember.ClubMember;
import org.superrent.views.general.Login;
import org.superrent.views.manager.ManagerHome;

public class LoginController implements ActionListener {

	private ClubMember c;
	private ManagerHome m;
	private Login l;
	LoggedInUser loggedInUser = new LoggedInUser();

	public int login(String username, String password) {
		Map<String, String> user = UserDAO.loginUser(username, password).get(0);
		if (user != null) {
			String privilege = user.get("type");
			System.out.println(privilege);
			loggedInUser.setUserId(privilege);
			return Integer.valueOf(privilege);
		} else {
			System.out.println("Validation failed");
			return 0;
		}
	}

	// @Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Login")) {
			String username = l.getUsername().getText();
			String password = l.getPassword().getText();
			int status = login(username, password);
			if(status > 0) {
				l.dispose();
			if(status == 1) {
				System.out.println("Hello there");
				new ClubMember().setVisible(true);
			}
			if(status == 2) {
				
			}
			if(status == 3) {
				m.setVisible(true);
			}
			if(status == 4) {
				
			} }
			else {
				l.getLoginMessage().setText("Login failed. Please check your credentials");
			}
		}

		if (e.getActionCommand().equals("Log Out")) {
			l = new Login();
			l.setVisible(true);
		}

	}
	
	public ClubMember getC() {
		return c;
	}

	public void setC(ClubMember c) {
		this.c = c;
	}

	public ManagerHome getM() {
		return m;
	}

	public void setM(ManagerHome m) {
		this.m = m;
	}

	public Login getL() {
		return l;
	}

	public void setL(Login l) {
		this.l = l;
	}

	LoginController() {
		this.c = new ClubMember();
		this.l = new Login();
		this.m = new ManagerHome();
		//m.setVisible(true);
		//c.setVisible(true);
	}

	public LoginController(ClubMember c) {
		this.c = c;
	}

	public LoginController(Login l) {
		this.l = l;		
	}
	
	public LoginController(ManagerHome m) {
		this.m = m;
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
					//LoginController lc = new LoginController();
					l.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
