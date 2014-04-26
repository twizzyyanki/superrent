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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.validation.api.Problem;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
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
import org.superrent.views.superadmin.SystemAdmin;


public class SystemAdminController implements ActionListener, DocumentListener {	
	
	private SystemAdmin sa;
	//private Login l;
	private SearchUserPanel sup = new SearchUserPanel(this);
	private AddUserPanel aup;
	private AddUserDAO au_dao;
	private SearchUserDAO su_dao;
	static JPanel oldpanel;
	private String text;
	private UpdateProfile updateProfile;
	boolean firstTime = true;
	//private Login l;
	//private SearchUserPanel sup;
	
	//@Override
	public void actionPerformed(ActionEvent e) {
		
		/**
		 * Switch center panel
		 */
		
		
		if(e.getActionCommand().equals("Add User")) {
			
			
			
			aup = new AddUserPanel(this);
			//new ValidateAddUser(aup);
			//System.out.println("You add a user");
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(aup.getXpanel());
			sa.getMainPanel().add(sa.getPanelCenter(), BorderLayout.CENTER);
			sa.revalidate();
			sa.repaint();
			
		/*	JFrame f = new JFrame("New Frame Opened");
			f.setSize(new Dimension(300, 300));
			f.setVisible(true);
		*/
		}
		
		if(e.getActionCommand().equals("Search User")) {
			sa.setSup(new SearchUserPanel(this));
			sup = sa.getSup();
			//sup.getBtnConfirm().setEnabled(false);
			sa.remove(sa.getPanelCenter());
			sa.setPanelCenter(sup.getValidationPanel());
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
			//final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			//final AddUserPanel aup = (AddUserPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			JComboBox jcb = aup.getComboBox();
			int check = jcb.getSelectedIndex();
			System.out.println(check);
			aup.setUserName(true);
			aup.setMembershipNumber(true);
			aup.getValidateAUR().setRunVUR(false);
			aup.getValidateAUC().setRunVUC(false);
			if (check == 1) {
				//aup.getGroup().add(aup.getTextFieldMembershipNum(), StringValidators.REQUIRE_NON_EMPTY_STRING);
				//aup.getGroup().add(aup.getTextFieldUserName(), StringValidators.REQUIRE_NON_EMPTY_STRING);
				System.out.println("You selected club member");
				aup.getValidateAUR().setRunVUR(true);
				aup.getValidateAUC().setRunVUC(true);
				//aup.getTextFieldUserName().setText("test");
				//aup.getTextFieldUserName().setText(null);
				
				text = aup.getTextFieldUserName().getText();
				aup.getTextFieldUserName().setText("test");
				aup.getTextFieldUserName().setText(null);
				aup.getTextFieldUserName().setText(text);
				
				text = aup.getTextFieldMembershipNum().getText();
				aup.getTextFieldMembershipNum().setText("test");
				aup.getTextFieldMembershipNum().setText(null);
				aup.getTextFieldMembershipNum().setText(text);
			}
			else if (check == 0) {
				System.out.println("You selected a customer");
				aup.setUserName(false);
				aup.setMembershipNumber(false);
				aup.getValidateAUR().setRunVUR(false);
				aup.getValidateAUC().setRunVUC(false);
				
				text = aup.getTextFieldEmail().getText();
				aup.getTextFieldEmail().setText("test");
				aup.getTextFieldEmail().setText(null);
				aup.getTextFieldEmail().setText(text);
			}
			else {
				//aup.getGroup().add(aup.getTextFieldUserName(), StringValidators.REQUIRE_NON_EMPTY_STRING);
				System.out.println("You selected a manager or clerk");
				aup.setMembershipNumber(false);
				aup.getValidateAUR().setRunVUR(true);
				aup.getValidateAUC().setRunVUC(false);
				
				text = aup.getTextFieldUserName().getText();
				aup.getTextFieldUserName().setText("test");
				aup.getTextFieldUserName().setText(null);
				aup.getTextFieldUserName().setText(text);
				
				text = aup.getTextFieldEmail().getText();
				aup.getTextFieldEmail().setText("test");
				aup.getTextFieldEmail().setText(null);
				aup.getTextFieldEmail().setText(text);
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
		    sup = sa.getSup();
			System.out.println("You have made a search");
			System.out.println("You have input "+sup.getInputName()+ " for User Name and "+sup.getInputPhone()+" for Phone Number");
			this.su_dao = new SearchUserDAO(sup);
		}
		/**
		 * Add a user in the database
		 */
		if(e.getActionCommand().equals("Add")) {
			//final BorderLayout layout = (BorderLayout)sa.getContentPane().getLayout();
			//final AddUserPanel aup = (AddUserPanel) layout.getLayoutComponent(BorderLayout.CENTER);
			System.out.println("You add a user and the informaiton about the user is as follows");
			System.out.print("User type: "+aup.getInputType()+" ");
			System.out.print("User Name: "+aup.getInputName()+" ");
			System.out.print("Phone Number: "+aup.getInputPhone()+" ");
			System.out.print("Address: "+aup.getInputAddress()+" ");
			System.out.println("Email: "+aup.getInputEmail()+" ");
			this.au_dao = new AddUserDAO(aup);
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
					String newPhoneNumber = updateProfile.getTextPhone().getText();
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

	public void changedUpdate(DocumentEvent arg0) {
		checkValidation();
		
	}

	public void insertUpdate(DocumentEvent arg0) {
		checkValidation();
		
	}

	public void removeUpdate(DocumentEvent arg0) {
		checkValidation();
	}
	
	private void checkValidation() {
		/* If the system enters the system for the first time */
		if (firstTime){
			sup = sa.getSup();
		}
		firstTime = false;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println(sup.getGroup());
				Problem validateAll = sup.getGroup().performValidation();
				// System.out.println("validate all is  " + validateAll);
				if (validateAll == null) {
					sup.getBtnConfirm().setEnabled(true);
					sup.revalidate();
					sup.repaint();
					// System.out.println("Getting here");
				} else {
					if (validateAll.isFatal()) {
						sup.getBtnConfirm().setEnabled(false);
					}
				}

			}
		});
	}
}
