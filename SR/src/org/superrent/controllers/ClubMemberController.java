package org.superrent.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.superrent.views.clubmember.*;
import org.superrent.daos.ChangePasswordDAO;
import org.superrent.daos.ClubMemberDAO;
import org.superrent.daos.UpdateProfileDAO;

/**
 * This class implements the ActionListener interface and 
 * consists the methods to control the behavior of the Java Swing UI, clubMember.
 *@c.pre When the clubMember view is created by the LoginController
 *
 */

public class ClubMemberController implements ActionListener {
	
	private ClubMember clubMemberView;
	private JChangePassword jCPassword;
	private JUpdateProfile jUProfile;
	private JCheckReservation jCheckReservation;
	private ClubMemberDAO clubMemberDAO;
	
	/**
	 *This method will override the method in ActionListener to perform actions when the command is
	 *got by the ActionListener
	 *@c.pre When the users click the buttons in the clubMemberView
	 *@c.post An action will be performed according to the command types
	 *@param e is the command which is received by the ActionListener
	 */
	public void actionPerformed(ActionEvent e) {
	
		ClubMemberDAO clubMemberDAO = new ClubMemberDAO();
		if(e.getActionCommand().equals("View Points")) {
			JViewPoints jV= new JViewPoints(this);
			JLabel pointsLabel;
			String totalPoints="0";		
			
			
			clubMemberView.remove(clubMemberView.getPanelCenter());
			clubMemberView.setCenterPanel(jV);
			clubMemberView.revalidate();
			clubMemberView.repaint();
			pointsLabel = jV.getPoints();
			
			// clubMemberDAO.getPoints() method to get points from DAO
			totalPoints = Double.toString(clubMemberDAO.getPoints());
			pointsLabel.setText(totalPoints);
		}
		
		
		
		if(e.getActionCommand().equals("Change Password")){
			jCPassword = new JChangePassword(this);
			
			clubMemberView.remove(clubMemberView.getPanelCenter());
			clubMemberView.setCenterPanel(jCPassword);
			clubMemberView.revalidate();
			clubMemberView.repaint();
			
		}
		
		
		if(e.getActionCommand().equals("Update Profile")) {
			jUProfile= new JUpdateProfile(this);
			
			clubMemberView.remove(clubMemberView.getPanelCenter());
			clubMemberView.setCenterPanel(jUProfile);
			clubMemberView.revalidate();
			clubMemberView.repaint();
			
			UpdateProfileDAO nameDAO = new UpdateProfileDAO();
			UpdateProfileDAO phoneDAO = new UpdateProfileDAO();
			UpdateProfileDAO addressDAO = new UpdateProfileDAO();
			String name = nameDAO.getName();
			String phone = String.valueOf(phoneDAO.getPhoneNumber());
			String address = addressDAO.getAddress();
			
			jUProfile.getTextName().setText(name);
			jUProfile.getTextPhone().setText(phone);
			jUProfile.getTextAddress().setText(address);;

		}
		
		if(e.getActionCommand().equals("Check Reservation")) {
			jCheckReservation= new JCheckReservation(this);
			
			clubMemberView.remove(clubMemberView.getPanelCenter());
			clubMemberView.setCenterPanel(jCheckReservation);
			clubMemberView.revalidate();
			clubMemberView.repaint();
		}
		
		// confirm button in the JChangePassword panel
		if(e.getActionCommand().equals("Confirm")) {
			ChangePasswordDAO checkPassword = new ChangePasswordDAO();
			jCPassword.getWrongInput().setText("");
			String oldPassword = jCPassword.getTextCurrentPassword().getText();
			Boolean inDatabase = false;
			Boolean updateSucess = false;
			// checkOldPassword method to check password in DB
			inDatabase = checkPassword.checkOldPassword(oldPassword);
			
			if(inDatabase){
				String newPassword = jCPassword.getTextNewPassword().getText();
				String confirmPassword = jCPassword.getTextConfriPassword().getText();
				if(newPassword.equals(confirmPassword)){
					ChangePasswordDAO setPassword = new ChangePasswordDAO();
					if(setPassword.setNewPassword(newPassword)){
						jCPassword.getWrongInput().setForeground(Color.BLACK);
						jCPassword.getWrongInput().setText("Update success");
					}
					else{
						
						jCPassword.getWrongInput().setForeground(Color.RED);
						jCPassword.getWrongInput().setText("Update fail");
					}
					
				}
				else{
					
					jCPassword.getWrongInput().setForeground(Color.RED);
					jCPassword.getWrongInput().setText("Confirm password does not match with new Password");			
				}
				
			}
			else{
				jCPassword.getWrongInput().setForeground(Color.RED);
				jCPassword.getWrongInput().setText("Current password does not match");
			}
			

		}
		
		// Update button in the JUpdateProfile panel
		if(e.getActionCommand().equals("Update")) {
			
			// check if user enters text in name text area
			if(jUProfile.getTextName().getText()!=null && 
			   jUProfile.getTextName().getText().trim().length()!=0){
				// check if text area is "Update Success" to prevent updating 
				if(!jUProfile.getTextName().getText().equals("Update Success")){
					UpdateProfileDAO updateNameDAO = new UpdateProfileDAO();
					if(updateNameDAO.updateName(jUProfile.getTextName().getText())){
						jUProfile.getTextName().setText("Update Success");
					}
					else{
						jUProfile.getTextName().setForeground(Color.RED);
						jUProfile.getTextName().setText("Update fail");
					}
					
				}
				else{
					jUProfile.getTextName().setForeground(Color.black);
					jUProfile.getTextName().setText("");
				}

			}
			
			// check if user enters text in phone text area
			if(jUProfile.getTextPhone().getText()!=null && 
			   jUProfile.getTextPhone().getText().trim().length()!=0){		
				
				// check if text area is "Update Success" to prevent updating 
				if(!jUProfile.getTextPhone().getText().equals("Update Success")){
					UpdateProfileDAO updatePhoneDAO = new UpdateProfileDAO();
					int newPhoneNumber = Integer.parseInt(jUProfile.getTextPhone().getText());
					if(updatePhoneDAO.updatePhoneNumber(newPhoneNumber)){
						jUProfile.getTextPhone().setText("Update Success");
					}
					else{
						jUProfile.getTextPhone().setForeground(Color.RED);
						jUProfile.getTextPhone().setText("Update fail");
					}
				}
				else{
					jUProfile.getTextPhone().setForeground(Color.black);
					jUProfile.getTextPhone().setText("");
				}
			}
			
				
			// check if user enters text in address text area
			if(jUProfile.getTextAddress().getText()!=null &&				
			   jUProfile.getTextAddress().getText().trim().length()!=0){		
				
					// check if text area is "Update Success" to prevent updating 
					if(!jUProfile.getTextAddress().getText().equals("Update Success")){
						UpdateProfileDAO updateAddressDAO = new UpdateProfileDAO();
						String newAddress = jUProfile.getTextAddress().getText();
						if(updateAddressDAO.updateAddress(newAddress)){
							jUProfile.getTextAddress().setText("Update Success");
						}
						else{
							jUProfile.getTextAddress().setForeground(Color.RED);
							jUProfile.getTextAddress().setText("Update fail");
						}
					}
					else{
						jUProfile.getTextAddress().setForeground(Color.black);
						jUProfile.getTextAddress().setText("");
					}
			}

		}
	}
	/**
	 * This is the constructor of this class. It will control the view that is passed by the parameter
	 * @c.pre  The ClubMemberController is invoked by other classes
	 * @c.post The variable , this.clubMemberView, is initialized
	 * @param clubMemberView take ClubMember type parameter and assign it to the variable this.clubMemberView. 
	 */
	public ClubMemberController (ClubMember clubMemberView){
		
		this.clubMemberView = clubMemberView;
	
	}
	
	




}
