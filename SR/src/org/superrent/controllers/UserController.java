package org.superrent.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import org.superrent.views.general.AddUserSample;

public class UserController implements ActionListener{
	
	private AddUserSample aus;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserSample ul = new AddUserSample();
					UserController lc = new UserController(ul);
					lc.aus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Add User")) {
			//add user
			System.out.println("Trying to add a user");
		}
	}
	
	public UserController(AddUserSample aus) {
		this.aus = aus;
	}

}
