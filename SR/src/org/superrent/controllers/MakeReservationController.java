package org.superrent.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;






import org.superrent.views.general.Login;
import org.superrent.views.general.MakeReservationPage;
import org.superrent.views.general.ReservationPanel;
import org.superrent.views.general.ReservationSuccessDialog;
import org.superrent.views.general.SearchVReservationPanel;
import org.superrent.views.general.cancelReservationPanel;





public class MakeReservationController implements ActionListener,ListSelectionListener{
	private final MakeReservationPage reservationPage;
	private SearchVReservationPanel  sVRPanel;
	private ReservationPanel reservationPanel;
	private cancelReservationPanel cancelReservationPanel;
	private ReservationSuccessDialog dialog;
	// charge for the reservation
	private String charge;
	
	public MakeReservationController(MakeReservationPage reservationPage){
		this.reservationPage = reservationPage;
		
	}


	// @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Home Page")){
			sVRPanel = new SearchVReservationPanel(this);
			reservationPage.remove(reservationPage.getPanelCenter());
			reservationPage.setCenterPanel(sVRPanel);
			reservationPage.revalidate();
			reservationPage.repaint();
			
		}
		
		if(e.getActionCommand().equals("Cancel Reservation")){
			cancelReservationPanel = new cancelReservationPanel(this);
			reservationPage.remove(reservationPage.getPanelCenter());
			reservationPage.setCenterPanel(cancelReservationPanel);
			reservationPage.revalidate();
			reservationPage.repaint();
			
		}
		
		if(e.getActionCommand().equals("Reserve")){
			reservationPanel = new ReservationPanel(this);
			reservationPage.remove(reservationPage.getPanelCenter());
			reservationPage.setCenterPanel(reservationPanel);
			reservationPage.revalidate();
			reservationPage.repaint();
			
		}
		
		// Search the vehicle
		if(e.getActionCommand().equals("Search")){
			
			sVRPanel.getLblSearchInfo().setForeground(Color.black);
			sVRPanel.getLblSearchInfo().setText("");
			
			// check Date field is valid or not 
			if(sVRPanel.getDateChooserPick().getDate()!=null && sVRPanel.getDateChooserReturn().getDate()!=null){
				java.util.Date utilPickUpDate = sVRPanel.getDateChooserPick().getDate();
				java.sql.Date datePickUpDate = new java.sql.Date(utilPickUpDate.getTime());
				java.util.Date utilReturnDate = sVRPanel.getDateChooserReturn().getDate();
				java.sql.Date dateReturnDate = new java.sql.Date(utilReturnDate.getTime());
						
				String category = (String) sVRPanel.getCategoryCombox().getSelectedItem();
				String type = (String) sVRPanel.getTypeCombox().getSelectedItem();
				String equipment = (String)sVRPanel.getEquipComboBox().getSelectedItem();
				
				// Need DAO to search available vehicles
				// SET Jtable according to DAO's return value
			}
			else{
				sVRPanel.getLblSearchInfo().setForeground(Color.RED);
				sVRPanel.getLblSearchInfo().setText("Date field is invalid or empty");
			}


			
			
		}
		
		//Reserve as club member
		if(e.getActionCommand().equals("Clubmember Reserve")){
			reservationPanel.getLblClubInfo().setForeground(Color.black);
			reservationPanel.getLblClubInfo().setText("");
			
			if(reservationPanel.getUserIDTextField().getText().trim().length()!=0 &&
			   reservationPanel.getPasswordField().getText().trim().length()!=0){
				//Need DAO TO CHECK IF USER ID EXIST IF YES clubExist set to TRUE
				boolean clubExist = false;
				if(clubExist){
					//Need DAO to store this reservation as clubmember
					
					dialog = new ReservationSuccessDialog(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					reservationPage.dispose();
					
					//Need DAO to get confirmation No.
					String confirmaionNo = "123";
					dialog.getLblGetCoNo().setText(confirmaionNo);
					
					//Need DAO to get location
					String location = "Vancouver";
					dialog.getLblGetLocation().setText(location);
					
					//Need DAO to get pickUpDate
					String pickUpDate = "2014/05/18";
					dialog.getLblGetPickUpDate().setText(pickUpDate);
					
					//Need DAO to get ReturnDate
					String returnDate = "2014/05/18";
					dialog.getLblGetReturnDate().setText(returnDate);
					
				}
				else{
					reservationPanel.getLblClubInfo().setForeground(Color.RED);
					reservationPanel.getLblClubInfo().setText("User ID or Password is invalid");					
				}

			}
			else{
				reservationPanel.getLblClubInfo().setForeground(Color.RED);
				reservationPanel.getLblClubInfo().setText("User ID and Password cannot be empty");
			}
			
			
		}
		
		if(e.getActionCommand().equals("Guest Reserve")){
			reservationPanel.getLblGuestInfo().setForeground(Color.black);
			reservationPanel.getLblGuestInfo().setText("");
			
			if(reservationPanel.getNameTextField().getText().trim().length()!=0 && 
			   reservationPanel.getPhoneTextField().getText().trim().length()!=0 &&
			   reservationPanel.getAddressTextArea().getText().trim().length()!=0 &&
			   reservationPanel.getEmailTextField().getText().trim().length()!=0){
				
				//Validate all fields
				boolean valid = false;
				valid = ValidateFields(reservationPanel.getPhoneTextField().getText());				
				
				// Need to DAO to store user's information and thie reservation
				if(valid){
					dialog = new ReservationSuccessDialog(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					reservationPage.dispose();
					
					//Need DAO to get confirmation No.
					String confirmaionNo = "123";
					dialog.getLblGetCoNo().setText(confirmaionNo);
					
					//Need DAO to get location
					String location = "Vancouver";
					dialog.getLblGetLocation().setText(location);
					
					//Need DAO to get pickUpDate
					String pickUpDate = "2014/05/18";
					dialog.getLblGetPickUpDate().setText(pickUpDate);
					
					//Need DAO to get ReturnDate
					String returnDate = "2014/05/18";
					dialog.getLblGetReturnDate().setText(returnDate);
					
				}
				else{
					reservationPanel.getLblGuestInfo().setForeground(Color.RED);
					reservationPanel.getLblGuestInfo().setText("Phone is invalid");					
				}

			}
			else{
				reservationPanel.getLblGuestInfo().setForeground(Color.RED);
				reservationPanel.getLblGuestInfo().setText("Name,address,phone and email cannot be empty");
			}
			
		}
		
		if(e.getActionCommand().equals("Login Page")){
			Login loginPageLogin = new Login();
			loginPageLogin.setVisible(true);
			reservationPage.dispose();
			
		}
		
		if(e.getActionCommand().equals("OK")){
			Login loginPageLogin = new Login();
			loginPageLogin.setVisible(true);
			dialog.dispose();
			reservationPage.dispose();
		}
		
		if(e.getActionCommand().equals("Confirm to cancel")){
			cancelReservationPanel.getLblCancelInfo().setForeground(Color.black);
			cancelReservationPanel.getLblCancelInfo().setText("");
			
			if(cancelReservationPanel.getConfirmationNoTextField().getText().trim().length()!=0){
				String confirmationNo = cancelReservationPanel.getConfirmationNoTextField().getText();
				//Need DAO to cancel reservation
				Boolean successCancel = false;
				if(successCancel){
					cancelReservationPanel.getLblCancelInfo().setText("You success cancel the reservation");
				}
				else{
					cancelReservationPanel.getLblCancelInfo().setForeground(Color.red);
					cancelReservationPanel.getLblCancelInfo().setText("Your confirmation No. is not right");
				}
			}
			else{
				cancelReservationPanel.getLblCancelInfo().setForeground(Color.red);
				cancelReservationPanel.getLblCancelInfo().setText("confirmation No. cannot be empty");
			}
		}
		
		//calcuated estimated cost for vehicle and equipment
/*		if(e.getSource() == sVRPanel.getEquipComboBox()){
			
		}*/
		
	}


	// @Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()){
			sVRPanel.getBtnReserve().setEnabled(true);
			int i = sVRPanel.getSearchTable().getSelectedRow();
			System.out.println(sVRPanel.getSearchTable().getValueAt(i, 0));
			sVRPanel.getEquipComboBox().setEnabled(true);
			
			//NEED DAO to calculate estimated cost and return to charge
			charge = "20";
			sVRPanel.getLblAmount().setText(charge);
			
			
		}
		
	}

	public boolean ValidateFields(String phone){
		boolean valid = false;
		try{
			Integer.parseInt(phone);
			valid = true;
		}
		catch(NumberFormatException e){
			valid = false;
		}
		finally{
			return valid;
		}
		
	}

}
