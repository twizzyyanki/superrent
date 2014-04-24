package org.superrent.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


import org.superrent.views.general.MakeReservationPage;
import org.superrent.views.general.SearchVReservationPanel;



public class MakeReservationController implements ActionListener {
	private final MakeReservationPage reservationPage;
	private SearchVReservationPanel  sVRPanel;
	public MakeReservationController(MakeReservationPage reservationPage){
		this.reservationPage = reservationPage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Search Vehicle")){
			sVRPanel = new SearchVReservationPanel(this);
			
			reservationPage.remove(reservationPage.getPanelCenter());
			reservationPage.setCenterPanel(sVRPanel);
			reservationPage.revalidate();
			reservationPage.repaint();
			
		}
		
	}

}
