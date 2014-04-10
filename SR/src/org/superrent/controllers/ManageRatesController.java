package org.superrent.controllers;

import org.superrent.views.*;
import org.superrent.views.manager.ManagerHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;

public class ManageRatesController implements ActionListener {

	private final ManagerHome managerHome;

	public ManageRatesController(ManagerHome m) {
		managerHome = m;		
	}

	public void manageRatesViewDisplay() {
		System.out.println("Manage rates");
		managerHome.setWelcomeUser("Changing me");
	}

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { try { UIManager
	 * .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); }
	 * catch (Throwable e) { e.printStackTrace(); }
	 * 
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * LoginController lc = new LoginController();
	 * lc.loginFrame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } });
	 * 
	 * }
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getActionCommand());

		if (e.getActionCommand().equals("For Sale Vehicles")) {
			manageRatesViewDisplay();
		}

	}

}
