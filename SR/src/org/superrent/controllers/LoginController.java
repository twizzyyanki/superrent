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
import org.superrent.daos.UserDAO;
import org.superrent.entities.User;
import org.superrent.views.clubmember.ClubMember;
import org.superrent.views.general.Login;

public class LoginController implements ActionListener {

	private ClubMember c;
	private Login l;
	
	public void login(String username, String password) {
		Map<String, String> user = UserDAO.loginUser(username, password).get(0);	
		if(user.size() > 0) {
		
		String privilege = user.get("type");
		System.out.println( privilege);
		} else {
			System.out.println("Validation failed");
		}			
		
	}
	
		
	//@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Login")) {
			String username = l.getUsername().getText();
			String password = l.getPassword().getText();
			login(username, password);			
		}
		
		if(e.getActionCommand().equals("Log Out")) {
			
			l = new Login();
			l.setVisible(true);
		}
		
	}	
		public LoginController(ClubMember c) {	
			this.c = c;				
		}
		
		public LoginController(Login l) {
			this.l = l;
		}
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 try {
	            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login l = new Login();
					//LoginController lc = new LoginController(l);
					l.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
