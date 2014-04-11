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
