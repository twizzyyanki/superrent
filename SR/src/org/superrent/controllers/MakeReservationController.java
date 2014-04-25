package org.superrent.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import org.superrent.views.general.Login;
import org.superrent.views.general.MakeReservationPage;
import org.superrent.views.general.ReservationPanel;
import org.superrent.views.general.ReservationSuccessDialog;
import org.superrent.views.general.SearchVReservationPanel;





public class MakeReservationController implements ActionListener,ListSelectionListener {
	private final MakeReservationPage reservationPage;
	private SearchVReservationPanel  sVRPanel;
	private ReservationPanel reservationPanel;
	private ReservationSuccessDialog dialog;
	
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
			}
			else{
				sVRPanel.getLblSearchInfo().setForeground(Color.RED);
				sVRPanel.getLblSearchInfo().setText("Date field is invalid or empty");
			}

			
			String category = (String) sVRPanel.getCategoryCombox().getSelectedItem();
			String type = (String) sVRPanel.getTypeCombox().getSelectedItem();
			String equipment = (String)sVRPanel.getEquipComboBox().getSelectedItem();
			
			
		}
		
		if(e.getActionCommand().equals("Clubmember Reserve")){
			dialog = new ReservationSuccessDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			reservationPage.dispose();
		}
		
		if(e.getActionCommand().equals("Guest Reserve")){
			dialog = new ReservationSuccessDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			reservationPage.dispose();
			reservationPage.dispose();
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
		
	}


	// @Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()){
			sVRPanel.getBtnReserve().setEnabled(true);
			int i = sVRPanel.getSearchTable().getSelectedRow();
			System.out.println(sVRPanel.getSearchTable().getValueAt(i, 0));
		}
		
	}
	
	

}
