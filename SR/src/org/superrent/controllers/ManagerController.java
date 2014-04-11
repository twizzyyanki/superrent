package org.superrent.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.superrent.daos.IManagerDao;
import org.superrent.daos.ManagerDaoImpl;
import org.superrent.views.manager.ManagerHome;

public class ManagerController implements ActionListener {

	private final ManagerHome managerFrame;
	IManagerDao managerDao = new ManagerDaoImpl();

	public ManagerController(ManagerHome sampleFrame) {

		managerFrame = sampleFrame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());

		    if (e.getActionCommand().equals("Add Vehicle")) {
		    	System.out.println("Getting here");
				managerFrame.getSellVehicleListPanel().setEnabled(false);
		    	managerFrame.getSellVehicleListPanel().setVisible(false);
		    	managerFrame.getManageRatesPanel().setEnabled(false);
		    	managerFrame.getManageRatesPanel().setVisible(false);
		    	managerFrame.getSearchVehicleListPanel().setEnabled(false);
		    	managerFrame.getSearchVehicleListPanel().setVisible(false);
		    	
		    	String str = managerFrame.getAddVehiclePanel().getRegNumberTxt();
				System.out.println("add this register number to vehicle table" + str);
		    	managerFrame.getAddVehiclePanel().setEnabled(true);
				managerFrame.getAddVehiclePanel().setVisible(true);

			}
		    else if(e.getActionCommand().equals("Search Vehicle")) {
		    	
		    	getVehicle(managerFrame);
		    	
		    	managerFrame.getAddVehiclePanel().setEnabled(false);
				managerFrame.getAddVehiclePanel().setVisible(false);
				managerFrame.getSellVehicleListPanel().setEnabled(false);
		    	managerFrame.getSellVehicleListPanel().setVisible(false);
		    	managerFrame.getManageRatesPanel().setEnabled(false);
		    	managerFrame.getManageRatesPanel().setVisible(false);
		    	
		    	managerFrame.getSearchVehicleListPanel().setEnabled(true);
		    	managerFrame.getSearchVehicleListPanel().setVisible(true);

			}
		    else if(e.getActionCommand().equals("Change Rates")) {
		    	
		    	managerFrame.getAddVehiclePanel().setEnabled(false);
				managerFrame.getAddVehiclePanel().setVisible(false);
				managerFrame.getSellVehicleListPanel().setEnabled(false);
		    	managerFrame.getSellVehicleListPanel().setVisible(false);
		    	
		    	managerFrame.getSearchVehicleListPanel().setEnabled(false);
		    	managerFrame.getSearchVehicleListPanel().setVisible(false);
		    	managerFrame.getManageRatesPanel().setEnabled(true);
		    	managerFrame.getManageRatesPanel().setVisible(true);

			}
		    else if(e.getActionCommand().equals("Sell Vehicle")) {
		    	getVehicleForSelling(managerFrame);
		    	//disablePanels();
		    	managerFrame.getAddVehiclePanel().setEnabled(false);
				managerFrame.getAddVehiclePanel().setVisible(false);
				
		    	managerFrame.getManageRatesPanel().setEnabled(false);
		    	managerFrame.getManageRatesPanel().setVisible(false);
		    	managerFrame.getSearchVehicleListPanel().setEnabled(false);
		    	managerFrame.getSearchVehicleListPanel().setVisible(false);
		    	
		    	
		    	
		    	managerFrame.getSellVehicleListPanel().setEnabled(true);
		    	managerFrame.getSellVehicleListPanel().setVisible(true);

			}
		    else if(e.getActionCommand().equals("Search")){
		    	
		    	System.out.println("inside search button" + (String)managerFrame.getSearchVehicleListPanel().getCategoryCombox().getSelectedItem());
		    	/*if(managerFrame.getComboBox_1().getSelectedItem().toString().equalsIgnoreCase(null)){
		    		managerFrame.getComboBox_1().setSelectedItem("");
		    	}*/  
		    	getVehicle(managerFrame);
		    }
		    else if(e.getActionCommand().equals("Add For Sale")) {
		    	//getVehicleForSelling(managerFrame);
		    	//disablePanels();
		    	
		    	int row = managerFrame.getSearchVehicleListPanel().getSearchtable().getSelectedRow();
				if(row != -1){
					String regNumber = (String) managerFrame.getSearchVehicleListPanel().getSearchtable().getModel().getValueAt(row, 0);
					System.out.println("Add entry into vehicle for sale table" + row + "---" +regNumber);
				}

		    	
			}
		    else if(e.getActionCommand().equals("Sell")) {
		    	//getVehicleForSelling(managerFrame);
		    	//disablePanels();
		    	int row = managerFrame.getSellVehicleListPanel().getSellTable().getSelectedRow();
				if(row != -1){
					String regNumber = (String) managerFrame.getSellVehicleListPanel().getSellTable().getModel().getValueAt(row, 0);
					System.out.println("Delete entry in vehicle and vehicle for sale table" + row + "---" +regNumber);
				}

			}


		

	}


	/*private void disablePanels() {
		
		managerFrame.getAddVehiclePanel().setEnabled(false);
		managerFrame.getAddVehiclePanel().setVisible(false);
		managerFrame.getSellVehicleListPanel().setEnabled(false);
    	managerFrame.getSellVehicleListPanel().setVisible(false);    	
    	managerFrame.getSearchVehicleListPanel().setEnabled(false);
    	managerFrame.getSearchVehicleListPanel().setVisible(false);
    	managerFrame.getManageRatesPanel().setEnabled(false);
    	managerFrame.getManageRatesPanel().setVisible(false);
		
	}*/

	private void getVehicleForSelling(ManagerHome managerFrame2) {
		// TODO Auto-generated method stub
		managerDao.getVehiclesForSelling(managerFrame);
		
	}

	public void getVehicle(ManagerHome managerFrame) {
		
		
		managerDao.getAllVehicles(managerFrame);
        
		
	}

}
