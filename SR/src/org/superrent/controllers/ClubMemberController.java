package org.superrent.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;

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

public class ClubMemberController implements ActionListener
{	
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
			UpdateProfileDAO emailDao = new UpdateProfileDAO();
			String name = nameDAO.getName();
			String phone = String.valueOf(phoneDAO.getPhoneNumber());
			String address = addressDAO.getAddress();
			String email = emailDao.getEmail();
			
			jUProfile.getTextName().setText(name);
			jUProfile.getTextPhone().setText(phone);
			jUProfile.getTextAddress().setText(address);
			jUProfile.getTxtEmail().setText(email);

		}
		
		if(e.getActionCommand().equals("Check Reservation")) {
			jCheckReservation= new JCheckReservation(this);
			
			clubMemberView.remove(clubMemberView.getPanelCenter());
			clubMemberView.setCenterPanel(jCheckReservation);
			clubMemberView.revalidate();
			clubMemberView.repaint();
		
		}
		
		//search button in Check Reservation view
		if(e.getActionCommand().equals("Search")) {
			
			// change jDateChooser to util.Data and
			// change util.Date to sql.Date
			jCheckReservation.getErrorInfo().setForeground(Color.black);
			jCheckReservation.getErrorInfo().setText("");
			
			if(jCheckReservation.getFromDate().getDate() != null && jCheckReservation.getToDate().getDate() != null ){
				
				if(validateTime(jCheckReservation.getFromDate().getDate(), jCheckReservation.getToDate().getDate())){
					java.util.Date utilFromDate = jCheckReservation.getFromDate().getDate();
					java.sql.Date dateFromDate = new java.sql.Date(utilFromDate.getTime());
					java.util.Date utilToDate = jCheckReservation.getToDate().getDate();
					java.sql.Date dateToDate = new java.sql.Date(utilToDate.getTime());
					
					ClubMemberDAO reocrdsDAO = new ClubMemberDAO();
					reocrdsDAO.getReservation(dateFromDate, dateToDate, jCheckReservation.getTable(), 
											  jCheckReservation.getScrollPane());
				}
				else{
					jCheckReservation.getErrorInfo().setForeground(Color.RED);
					jCheckReservation.getErrorInfo().setText("date fields are invalid");
				}

				
			}
			else{
				jCheckReservation.getErrorInfo().setForeground(Color.RED);
				jCheckReservation.getErrorInfo().setText("date fields cannot be empty");
			}
			
		}
		
		// confirm button in the JChangePassword panel
		if(e.getActionCommand().equals("Confirm")) 
		{
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
			else
			{
				jCPassword.getWrongInput().setForeground(Color.RED);
				jCPassword.getWrongInput().setText("Current password does not match");
			}
		}
		
		// Update button in the JUpdateProfile panel
		if(e.getActionCommand().equals("Update")) {
			int nameSuccess = 1;
			int phoneSuccess = 1;
			int addressSucess = 1;
			int emailSuccess = 1;
			String updateInfosString="";
			jUProfile.getTextPhone().setForeground(Color.black);
			jUProfile.getUpdateInfo().setText("");
			
			// check if user enters text in name text area
			if(jUProfile.getTextName().getText()!=null && 
			   jUProfile.getTextName().getText().trim().length()!=0){
				// check if text area is "Update Success" to prevent updating 
				if(!jUProfile.getTextName().getText().equals("Update Success")){
					UpdateProfileDAO updateNameDAO = new UpdateProfileDAO();
					if(updateNameDAO.updateName(jUProfile.getTextName().getText())){
						nameSuccess = 1;
						updateInfosString = updateInfosString + "Update name success<br>";
					}
					else {
						nameSuccess = 0;
						updateInfosString = updateInfosString + "Update name fail<br>";
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
					String newPhoneNumber = jUProfile.getTextPhone().getText();
					if(updatePhoneDAO.updatePhoneNumber(newPhoneNumber)){
						phoneSuccess = 1;
						updateInfosString = updateInfosString + "Update phone number success<br>";
						
					}
					else{
						phoneSuccess = 0;
						updateInfosString = updateInfosString + "phone number is not vaild<br>";
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
							addressSucess = 1;
							updateInfosString = updateInfosString + "Update address success<br>";
						}
						else{
							addressSucess = 0;
							updateInfosString = updateInfosString + "Address is not valid<br>";
						}
					}
					else{
						jUProfile.getTextAddress().setForeground(Color.black);
						jUProfile.getTextAddress().setText("");
					}
			}
			
			// check if user enters text in email text area
			if(jUProfile.getTxtEmail().getText()!=null &&				
			   jUProfile.getTxtEmail().getText().trim().length()!=0){		
				
					// check if text area is "Update Success" to prevent updating 
					if(!jUProfile.getTxtEmail().getText().equals("Update Success")){
						UpdateProfileDAO updateEmailDAO = new UpdateProfileDAO();
						String email = jUProfile.getTxtEmail().getText();
						if(updateEmailDAO.updatemail(email)){
							emailSuccess = 1;
							updateInfosString = updateInfosString + "Update email success<br>";
						}
						else{
							addressSucess = 0;
							updateInfosString = updateInfosString + "Email is not valid<br>";
						}
					}
					else{
						jUProfile.getTextAddress().setForeground(Color.black);
						jUProfile.getTextAddress().setText("");
					}
			}
			
			if(nameSuccess+phoneSuccess+addressSucess!=4){
				
				updateInfosString = "<html>"+ updateInfosString + "</html>";
				jUProfile.getUpdateInfo().setText(updateInfosString);
			}
			else
			{
				updateInfosString = "<html>"+ updateInfosString + "</html>";
				jUProfile.getUpdateInfo().setText(updateInfosString);
			}
		}
	}
	/**
	 * This is the constructor of this class. It will control the view that is passed by the parameter
	 * @c.pre  The ClubMemberController is invoked by other classes
	 * @c.post The variable , this.clubMemberView, is initialized
	 * @param clubMemberView take ClubMember type parameter and assign it to the variable this.clubMemberView. 
	 */
	public ClubMemberController (ClubMember clubMemberView)
	{	
		this.clubMemberView = clubMemberView;
	}

	/**
	 * To check if pick up time is earlier then drop time
	 * @param pick
	 * @param drop
	 * @return true if valid
	 */
	public boolean validateTime(Date pick, Date drop){
		boolean valid = false;
		Date date = new Date();
		System.out.println(date);
		if(pick.compareTo(date)==-1 || drop.compareTo(date)==-1){
			valid = false;
			
		}
		else if(pick.compareTo(drop)==1){
			valid = false;
		}
		else{
			valid = true;
		}
		return valid;
	}
}
