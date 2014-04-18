package org.superrent.controllers;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.superrent.daos.AddUserDAO;
import org.superrent.daos.SearchUserDAO;
import org.superrent.views.superadmin.AddUserPanel;
import org.superrent.views.superadmin.ChangePasswordPanel;
import org.superrent.views.superadmin.SearchUserPanel;
import org.superrent.views.superadmin.SearchVehiclePanel;
import org.superrent.views.superadmin.SystemAdmin;

public class SystemAdminController implements ActionListener {	
	
	private SystemAdmin sa;
	//private Login l;
	private SearchUserPanel sup;
	private AddUserDAO au_dao;
	private SearchUserDAO su_dao;
	//private Login l;
	//private SearchUserPanel sup;
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Switch center panel
		 */
		if(e.getActionCommand().equals("Add User")) {
			AddUserPanel aup = new AddUserPanel(this);
			//System.out.println("You add a user");
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(aup);
			sa.getMainPanel().add(sa.getPanelCenter(), BorderLayout.CENTER);
			sa.revalidate();
			sa.repaint();
			
		/*	JFrame f = new JFrame("New Frame Opened");
			f.setSize(new Dimension(300, 300));
			f.setVisible(true);
		*/
		}
		
		if(e.getActionCommand().equals("Search User")) {
			
			SearchUserPanel sup = new SearchUserPanel(this);
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(sup);
			sa.getMainPanel().add(sa.getPanelCenter(), BorderLayout.CENTER);
			sa.revalidate();
			sa.repaint();
		}
		
	    if(e.getActionCommand().equals("Search Vehicle")) {
			SearchVehiclePanel svp = new SearchVehiclePanel(this);
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(svp);
			sa.getMainPanel().add(sa.getPanelCenter(), BorderLayout.CENTER);
			sa.revalidate();
			sa.repaint();
		}
	    
	    if(e.getActionCommand().equals("comboBoxChanged")) {
			System.out.println("ComboBox is changed");
			final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			final AddUserPanel aup = (AddUserPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			JComboBox jcb = aup.getComboBox();
			int check = jcb.getSelectedIndex();
			System.out.println(check);
			aup.setMembershipNumber(true);
			if (check == 1) {
				System.out.println("You selected club member");
			}
			else {
				System.out.println("You didn't select club member");
				aup.setMembershipNumber(false);
			}
		
		}
	    if(e.getActionCommand().equals("Change Password")) {
			ChangePasswordPanel cpp = new ChangePasswordPanel(this);
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(cpp);
			sa.getMainPanel().add(sa.getPanelCenter(), BorderLayout.CENTER);
			sa.revalidate();
			sa.repaint();
		}
	    
	    
	
	    
		/**
		 * Search a user in the database
		 */
		if(e.getActionCommand().equals("Confirm")) {
			final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			final SearchUserPanel sup = (SearchUserPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			System.out.println("You have made a search");
			System.out.println("You have input "+sup.getInputName()+ " for User Name and "+sup.getInputPhone()+" for Phone Number");
			this.su_dao = new SearchUserDAO(sup.getInputName(),sup.getInputPhone(),sup.getTable(),sup.getScrollPane());
		}
		/**
		 * Add a user in the database
		 */
		if(e.getActionCommand().equals("Add")) {
			final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			final AddUserPanel aup = (AddUserPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			System.out.println("You add a user and the informaiton about the user is as follows");
			System.out.print("User type: "+aup.getInputType()+" ");
			System.out.print("User Name: "+aup.getInputName()+" ");
			System.out.print("Phone Number: "+aup.getInputPhone()+" ");
			System.out.print("Address: "+aup.getInputAddress()+" ");
			System.out.println("Email: "+aup.getInputEmail()+" ");
			this.au_dao = new AddUserDAO(aup.getInputType(),aup.getInputName(),aup.getInputPhone(),aup.getInputAddress(),aup.getInputEmail());
		}
		/**
		 * Search a vehicle in the database
		 */
		if(e.getActionCommand().equals("ConfirmVehicle")) {
			System.out.println("You have made a search for vehicle");
		}
		/**
		 * Change the password of a system administrator 
		 */
		if(e.getActionCommand().equals("ConfirmPassword")) {
			System.out.println("You have changed your password");
		}
	}
	
	public SystemAdminController(SystemAdmin sa) {	
		this.sa = sa;		
	}
}
