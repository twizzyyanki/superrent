package org.superrent.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.superrent.daos.AddUserDAO;
import org.superrent.daos.ChangePasswordDAO;
import org.superrent.daos.SearchUserDAO;
import org.superrent.daos.UpdateProfileDAO;
import org.superrent.views.clerk.ClerkHome;
import org.superrent.views.superadmin.UpdateProfile;
import org.superrent.views.manager.ManagerHome;
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
	static JPanel oldpanel;
	private UpdateProfile updateProfile;
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
	    
	    if(e.getActionCommand().equals("Update Profile")) {
	    	System.out.println("You are updating system administrator's profile");
	    	updateProfile= new UpdateProfile(this);
			
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(updateProfile);
			sa.getMainPanel().add(sa.getPanelCenter(), BorderLayout.CENTER);
			sa.revalidate();
			sa.repaint();
			
			UpdateProfileDAO nameDAO = new UpdateProfileDAO();
			UpdateProfileDAO phoneDAO = new UpdateProfileDAO();
			UpdateProfileDAO addressDAO = new UpdateProfileDAO();
			String name = nameDAO.getName();
			String phone = String.valueOf(phoneDAO.getPhoneNumber());
			String address = addressDAO.getAddress();
			
			updateProfile.getTextName().setText(name);
			updateProfile.getTextPhone().setText(phone);
			updateProfile.getTextAddress().setText(address);;

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
			final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			final ChangePasswordPanel cpp = (ChangePasswordPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			System.out.println("You have changed your password");
			ChangePasswordDAO checkPassword = new ChangePasswordDAO();
			cpp.getWrongInput().setText("");
			char[] oldPassword = cpp.getCurrentPass().getPassword();
			String oldPass = new String (oldPassword);
			Boolean inDatabase = false;
			Boolean updateSucess = false;
			// checkOldPassword method to check password in DB
			inDatabase = checkPassword.checkOldPassword(oldPass);
			
			if(inDatabase){
				char[] newPassword = cpp.getNewPass().getPassword();
				String newPass = new String (newPassword);
				char[] confirmPassword = cpp.getConfirmNewPass().getPassword();
				String confirmPass = new String (confirmPassword);
				if(Arrays.equals(newPassword, confirmPassword)){
					ChangePasswordDAO setPassword = new ChangePasswordDAO();
					if(setPassword.setNewPassword(newPass)){
						cpp.getWrongInput().setForeground(Color.BLACK);
						cpp.getWrongInput().setText("Update success");
					}
					else{
						
						cpp.getWrongInput().setForeground(Color.RED);
						cpp.getWrongInput().setText("Update fail");
					}
					
				}
				else{
					
					cpp.getWrongInput().setForeground(Color.RED);
					cpp.getWrongInput().setText("Confirm password does not match with new Password");			
				}
				
			}
			else{
				cpp.getWrongInput().setForeground(Color.RED);
				cpp.getWrongInput().setText("Current password does not match");
			}
			

		}
		/**
		 * Run as Manager
		 */
		if(e.getActionCommand().equals("As Manager")) {
			System.out.println("You are now running the program as a Manager");
			ManagerHome m = new ManagerHome();
			m.setLocationRelativeTo(null);
			m.setVisible(true);
		}
		/**
		 * Run as Clerk
		 */
		if(e.getActionCommand().equals("As Clerk")) {
			System.out.println("You are now running the program as a Clerk");
			ClerkHome k = new ClerkHome();
			oldpanel=(JPanel) k.getContentPane();
			k.setLocationRelativeTo(null);
			k.setVisible(true);
		}
		
		/** Update button in the JUpdateProfile panel
		 * 
		 */
		if(e.getActionCommand().equals("Update")) {
			final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			final UpdateProfile updateProfile = (UpdateProfile) layout.getLayoutComponent(BorderLayout.CENTER);
			// check if user enters text in name text area
			if(updateProfile.getTextName().getText()!=null && 
					updateProfile.getTextName().getText().trim().length()!=0){
				// check if text area is "Update Success" to prevent updating 
				if(!updateProfile.getTextName().getText().equals("Update Success")){
					UpdateProfileDAO updateNameDAO = new UpdateProfileDAO();
					if(updateNameDAO.updateName(updateProfile.getTextName().getText())){
						updateProfile.getTextName().setText("Update Success");
					}
					else{
						updateProfile.getTextName().setForeground(Color.RED);
						updateProfile.getTextName().setText("Update fail");
					}
					
				}
				else{
					updateProfile.getTextName().setForeground(Color.black);
					updateProfile.getTextName().setText("");
				}

			}
			
			// check if user enters text in phone text area
			if(updateProfile.getTextPhone().getText()!=null && 
				updateProfile.getTextPhone().getText().trim().length()!=0){		
				
				// check if text area is "Update Success" to prevent updating 
				if(!updateProfile.getTextPhone().getText().equals("Update Success")){
					UpdateProfileDAO updatePhoneDAO = new UpdateProfileDAO();
					int newPhoneNumber = Integer.parseInt(updateProfile.getTextPhone().getText());
					if(updatePhoneDAO.updatePhoneNumber(newPhoneNumber)){
						updateProfile.getTextPhone().setText("Update Success");
					}
					else{
						updateProfile.getTextPhone().setForeground(Color.RED);
						updateProfile.getTextPhone().setText("Update fail");
					}
				}
				else{
					updateProfile.getTextPhone().setForeground(Color.black);
					updateProfile.getTextPhone().setText("");
				}
			}
			
				
			// check if user enters text in address text area
			if(updateProfile.getTextAddress().getText()!=null &&				
				updateProfile.getTextAddress().getText().trim().length()!=0){		
				
					// check if text area is "Update Success" to prevent updating 
					if(!updateProfile.getTextAddress().getText().equals("Update Success")){
						UpdateProfileDAO updateAddressDAO = new UpdateProfileDAO();
						String newAddress = updateProfile.getTextAddress().getText();
						if(updateAddressDAO.updateAddress(newAddress)){
							updateProfile.getTextAddress().setText("Update Success");
						}
						else{
							updateProfile.getTextAddress().setForeground(Color.RED);
							updateProfile.getTextAddress().setText("Update fail");
						}
					}
					else{
						updateProfile.getTextAddress().setForeground(Color.black);
						updateProfile.getTextAddress().setText("");
					}
			}

		}
	}
	
	public SystemAdminController(SystemAdmin sa) {	
		this.sa = sa;		
	}
}
