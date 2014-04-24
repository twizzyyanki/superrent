package org.superrent.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;






import org.superrent.views.general.MakeReservationPage;
import org.superrent.views.general.ReservationPanel;
import org.superrent.views.general.ReservationSuccessDialog;
import org.superrent.views.general.SearchVReservationPanel;

import com.sun.media.sound.Toolkit;



public class MakeReservationController implements ActionListener {
	private final MakeReservationPage reservationPage;
	private SearchVReservationPanel  sVRPanel;
	private ReservationPanel reservationPanel;
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
		
		if(e.getActionCommand().equals("Search")){
			String category = (String) sVRPanel.getCategoryCombox().getSelectedItem();
			String type = (String) sVRPanel.getTypeCombox().getSelectedItem();
			String equipment = (String)sVRPanel.getEquipComboBox().getSelectedItem();
		}
		
		if(e.getActionCommand().equals("Clubmember Reserve")){
			ReservationSuccessDialog dialog = new ReservationSuccessDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		
		if(e.getActionCommand().equals("Guest Reserve")){
			ReservationSuccessDialog dialog = new ReservationSuccessDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		
		
	}

}
