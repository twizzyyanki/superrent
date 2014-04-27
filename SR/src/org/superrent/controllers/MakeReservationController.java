package org.superrent.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;





import javax.swing.table.DefaultTableModel;

import org.superrent.daos.ReservationDao;
import org.superrent.entities.MakeReservation;
import org.superrent.entities.Reservation;
import org.superrent.entities.User;
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
	private double charge;
	private Reservation reservation;
	private MakeReservation makeReservation;
	private java.util.Date pickupDate;
	private java.util.Date dropDate;
	private String regNo;
	private Vector carTypeList;
	private Vector truckTypeList;
	
	
	public MakeReservationController(MakeReservationPage reservationPage){
		this.reservationPage = reservationPage;
		ReservationDao carTypeDao = new ReservationDao();
		carTypeList = carTypeDao.searchCarType();
		System.out.println(carTypeList);
		ReservationDao truckTypeDao = new ReservationDao();
		truckTypeList = truckTypeDao.searchTruckType();
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
			
			//"Insert into MakeReservation (uid, confirmationNo, date, regNo, status) 
			//"INSERT INTO Reservation (pickDate, dropDate, creationDate,charges,status)
			reservation = new Reservation();
			makeReservation = new MakeReservation();
			reservation.setPickDate(pickupDate);
			reservation.setDropDate(dropDate);
			reservation.setCharges(charge);
			makeReservation.setRegNo(regNo);
		}
		
		// Search the vehicle
		if(e.getActionCommand().equals("Search")){
			DefaultTableModel model = (DefaultTableModel) sVRPanel.getSearchTable().getModel();
			model.setRowCount(0);
			sVRPanel.getLblSearchInfo().setForeground(Color.black);
			sVRPanel.getLblSearchInfo().setText("");
			
			// check Date field is valid or not 
			if(sVRPanel.getDateChooserPick().getDate()!=null && sVRPanel.getDateChooserReturn().getDate()!=null){
				
				
				pickupDate = sVRPanel.getDateChooserPick().getDate();
				dropDate = sVRPanel.getDateChooserReturn().getDate();
				Date pickHour = (Date)sVRPanel.getSpinnerPickUp().getValue();
				Date dropHour = (Date)sVRPanel.getSpinnerDrop().getValue();

				pickupDate = dateCombine(pickupDate, pickHour);
				dropDate = dateCombine(dropDate, dropHour);
				
				
				if(validateTime(pickupDate, dropDate)){
					String category = (String) sVRPanel.getCategoryCombox().getSelectedItem();
					String type = (String) sVRPanel.getTypeCombox().getSelectedItem();
					
					// Need DAO to search available vehicles
					// SET Jtable according to DAO's return value
					ReservationDao searchVehicle = new ReservationDao();
					searchVehicle.searchVehiclesForReservation(pickupDate, dropDate, type, 
							                                   category, sVRPanel.getSearchTable(), sVRPanel.getScrollPane() );
					//String equipment = (String)sVRPanel.getEquipComboBox().getSelectedItem();		
				}
				else{
					sVRPanel.getLblSearchInfo().setForeground(Color.RED);
					sVRPanel.getLblSearchInfo().setText("Pick up time cannot be latter than return time");
				}

				
	
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
			String username = reservationPanel.getUserIDTextField().getText();
			String password = reservationPanel.getPasswordField().getText();
			
			if(username.trim().length()!=0 &&
			   password.trim().length()!=0){
				
				password = org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
				
				ReservationDao checkClubMemberDao = new ReservationDao();
				boolean clubExist = false;
				Integer uid;
				//Need DAO TO CHECK IF USER ID EXIST IF YES clubExist set to TRUE
				if((uid=checkClubMemberDao.getUid(username, password))!=null){
					clubExist = true;
				}
				
				if(clubExist){
					//Need DAO to store this reservation as club Member
					makeReservation.setUid(uid);
					ReservationDao makeReservationDao = new ReservationDao();
					ReservationDao getCinfrmationNoDao = new ReservationDao();
					
					makeReservationDao.makeReservation(reservation);
					makeReservation.setConfirmationNo((int)getCinfrmationNoDao.getConfirmationFromReservation());
					makeReservationDao.makeReservation(makeReservation);
					
					//open ReservationSuccess Dialog
					dialog = new ReservationSuccessDialog(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
					reservationPage.dispose();
					
					//Need DAO to get confirmation No.
					String confirmaionNo = makeReservation.getConfirmationNo().toString();
					dialog.getLblGetCoNo().setText(confirmaionNo);
					
					//Need DAO to get location
					String location = "Vancouver";
					dialog.getLblGetLocation().setText(location);
					
					//Need DAO to get pickUpDate
					String pickUpDate = reservation.getPickDate().toString();
					dialog.getLblGetPickUpDate().setText(pickUpDate);
					
					//Need DAO to get ReturnDate
					String returnDate = reservation.getDropDate().toString();
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
			String name = reservationPanel.getNameTextField().getText();
			String phone =  reservationPanel.getPhoneTextField().getText();
			String address = reservationPanel.getAddressTextArea().getText();
			String email =  reservationPanel.getEmailTextField().getText();
			
			if(name.trim().length()!=0 && 
			   phone.trim().length()!=0 &&
			   address.trim().length()!=0 &&
			   email.trim().length()!=0){
				
				//Validate all fields
				boolean valid = false;
				valid = ValidateFields(phone);				
				
				// Need to DAO to store user's information and this reservation
				if(valid){
					User guestUser = new User();
					guestUser.setName(name);
					guestUser.setPhoneNumber(Integer.parseInt(phone));
					guestUser.setEmail(email);
					guestUser.setAddress(address);
					
					
					ReservationDao getUID = new ReservationDao();
					int uid = getUID.getUid(guestUser);
					makeReservation.setUid(uid);
					ReservationDao makeReservationDao = new ReservationDao();
					ReservationDao getCinfrmationNoDao = new ReservationDao();
					
					makeReservationDao.makeReservation(reservation);
					makeReservation.setConfirmationNo((int)getCinfrmationNoDao.getConfirmationFromReservation());
					makeReservationDao.makeReservation(makeReservation);
					
					dialog = new ReservationSuccessDialog(this);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
					reservationPage.dispose();
					
					//Need DAO to get confirmation No.
					long confirmaionNo = makeReservation.getConfirmationNo();
					dialog.getLblGetCoNo().setText(String.valueOf(confirmaionNo));
					
					//Need DAO to get location
					String location = "Vancouver";
					dialog.getLblGetLocation().setText(location);
					
					//Need DAO to get pickUpDate
					String pickUpDate = reservation.getPickDate().toString();
					dialog.getLblGetPickUpDate().setText(pickUpDate);
					
					//Need DAO to get ReturnDate
					String returnDate = reservation.getDropDate().toString();
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
			loginPageLogin.setLocationRelativeTo(null);
			loginPageLogin.setVisible(true);
			reservationPage.dispose();
			
		}
		
		if(e.getActionCommand().equals("OK")){
			Login loginPageLogin = new Login();
			loginPageLogin.setLocationRelativeTo(null);
			loginPageLogin.setVisible(true);
			dialog.dispose();
			reservationPage.dispose();
		}
		
		if(e.getActionCommand().equals("Confirm to cancel")){
			cancelReservationPanel.getLblCancelInfo().setForeground(Color.black);
			cancelReservationPanel.getLblCancelInfo().setText("");
			String confirmationNo = cancelReservationPanel.getConfirmationNoTextField().getText();
			
			
			if(confirmationNo.trim().length()!=0){
				Boolean successCancel = false;
				//check to see if confirmationNo is int
				successCancel = ValidateFields(confirmationNo);
				ReservationDao checkExistConf = new ReservationDao();
				//Need DAO to cancel reservation
				if(successCancel && checkExistConf.checkExistConfirmatioNo(Integer.parseInt(confirmationNo))){
					ReservationDao cancelReservationDao = new ReservationDao();
					successCancel = cancelReservationDao.cancelReservation(Integer.parseInt(confirmationNo));
				}else{
					successCancel = false;
				}
				
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
		
		if(e.getSource() == sVRPanel.getCategoryCombox()){
			sVRPanel.getSearchTable().clearSelection();
			String item = (String)sVRPanel.getCategoryCombox().getSelectedItem();
			if(item.equalsIgnoreCase("CAR")){
				sVRPanel.getTypeCombox().setModel(new DefaultComboBoxModel(carTypeList));
				
				sVRPanel.getEquipComboBox().setModel(new DefaultComboBoxModel<String>(new String[] { "None","Child seat"}));
				
			}
			else if(item.equalsIgnoreCase("TRUCK")){
				sVRPanel.getTypeCombox().setModel(new DefaultComboBoxModel(truckTypeList));
				
			}
			else if(item.equalsIgnoreCase("ALL")){
				sVRPanel.getTypeCombox().setModel(new DefaultComboBoxModel<String>(new String[] {"ALL", "ECONOMY","COMPACT","MID-SIZE",
						  													"STANDARD", "FULL-SIZE", "PREMIUM","LUXURY", "SUV",
						  													"VAN", "24-FOOT", "15-FOOT", "12-FOOT", "BOX TRUCK", 
						  													"CARGO VAN"}));
				
			
			}
		}
		
		//calculated estimated cost for vehicle and equipment
/*		if(e.getSource() == sVRPanel.getEquipComboBox()){
			
		}*/
		
	}


	// @Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(!e.getValueIsAdjusting()){
			
			if(sVRPanel.getSearchTable().getSelectedRow()!=-1){
				sVRPanel.getBtnReserve().setEnabled(true);
				int i = sVRPanel.getSearchTable().getSelectedRow();	
				regNo = sVRPanel.getSearchTable().getValueAt(i, 3).toString();
				sVRPanel.getEquipComboBox().setEnabled(true);
				//NEED DAO to calculate estimated cost and return to charge
				ReservationDao calculatePriceDao = new ReservationDao();	
				charge = calculatePriceDao.calculateCharges(regNo, 
															pickupDate, dropDate);
				String scharge = String.format("%.2f", charge);  
				sVRPanel.getLblAmount().setText(scharge);
				
				if(sVRPanel.getSearchTable().getValueAt(i, 0).toString().equals("Car")){
					sVRPanel.getEquipComboBox().setModel(new DefaultComboBoxModel<String>(new String[] { "None","Child seat"}));
				}
				else if(sVRPanel.getSearchTable().getValueAt(i, 0).toString().equals("Truck")){
					sVRPanel.getEquipComboBox().setModel(new DefaultComboBoxModel<String>(new String[] { "None"}));
				}
				
			}else{
				charge = 0;
				sVRPanel.getLblAmount().setText(String.valueOf(charge));
			}


			
			
		}
		
	}

	public boolean ValidateFields(String anyIntegerType){
		boolean valid = false;
		try{
			Integer.parseInt(anyIntegerType);
			valid = true;
		}
		catch(NumberFormatException e){
			valid = false;
		}
		finally{
			return valid;
		}
		
	}

	public boolean validateTime(Date pick, Date drop){
		boolean valid = false;
		if(pick.compareTo(drop)==1){
			valid = false;
		}
		else{
			valid = true;
		}
		
		return  valid;
	}

	public static Date dateCombine(Date date, Date hour){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  cal.set(Calendar.HOUR_OF_DAY, hour.getHours());
		  cal.set(Calendar.MINUTE, 0);
		  cal.set(Calendar.SECOND,0);
		  Date dateF = cal.getTime();
		  return dateF;
	}
	
	
}
