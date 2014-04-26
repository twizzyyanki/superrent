package org.superrent.controllers;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;

import org.superrent.daos.IManagerDao;
import org.superrent.daos.ManagerDaoImpl;
import org.superrent.entities.AdditionalEquipment;
import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.SuperRent;
import org.superrent.entities.SuperRentInsuranceRate;
import org.superrent.entities.SuperRentRentalRate;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.FailureDialog;
import org.superrent.views.manager.ManagerHome;
import org.superrent.views.manager.SuccessDialog;
import org.superrent.views.manager.VehicleExistsDialog;

public class ManagerController implements ActionListener {

	private final ManagerHome managerFrame;
	IManagerDao managerDao = new ManagerDaoImpl();
	

	public ManagerController(ManagerHome sampleFrame) {

		managerFrame = sampleFrame;

	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());

		if (e.getActionCommand().equals("Add Vehicle")) {
			System.out.println("Getting here");
			disablePanels();

			managerFrame.getAddVehiclePanel().setEnabled(true);
			managerFrame.getAddVehiclePanel().setVisible(true);

		}
		if (e.getActionCommand().equals("Add")) {
			System.out.println("Getting here");

			VehicleVO vehicleVO = new VehicleVO();
			vehicleVO.setRegNo(managerFrame.getAddVehiclePanel()
					.getRegNumberTxt());
			vehicleVO.setCategory((String) managerFrame.getAddVehiclePanel()
					.getCategoryCombox().getSelectedItem());
			vehicleVO.setType((String) managerFrame.getAddVehiclePanel()
					.getTypeCombox().getSelectedItem());
			vehicleVO.setBrand(managerFrame.getAddVehiclePanel().getBrandTxt());
			Date purchaseDate = managerFrame.getAddVehiclePanel().getCalendar()
					.getDate();
			java.sql.Date sqlDate = new java.sql.Date(purchaseDate.getTime());
			vehicleVO.setPurchaseDate(sqlDate);
			boolean result = managerDao.addVehicle(vehicleVO);

			if (result) {

				VehicleExistsDialog dialog = new VehicleExistsDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				dialog.setVisible(true);
				managerFrame.getAddVehiclePanel().clearVehicleScreen();

			} else {

				FailureDialog dialog = new FailureDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				dialog.setVisible(true);

			}

		} else if (e.getActionCommand().equals("Search Vehicle")) {
			disablePanels();
			getVehicle(managerFrame);
			managerFrame.getSearchVehicleListPanel().setEnabled(true);
			managerFrame.getSearchVehicleListPanel().setVisible(true);

		} else if (e.getActionCommand().equals("Change Rates")) {
			disablePanels();
			SuperRent superRent = new SuperRent();
			managerFrame.getManageRatesPanel().setEnabled(true);
			managerFrame.getManageRatesPanel().setVisible(true);
			managerDao.getRentalRate(managerFrame);
			getRentalRates();
			getInsuranceRates();
			getAddnEquipRates();
			managerDao.getInsuranceRates(managerFrame);
			superRent = managerDao.getOtherRates();
			assembleOtherRates(superRent);
			
			managerFrame.getManageRatesPanel().getRentalratePanel().revalidate();

		} else if (e.getActionCommand().equals("Sell Vehicle")) {
			getVehicleForSelling(managerFrame);
			disablePanels();
			managerFrame.getSellVehicleListPanel().setEnabled(true);
			managerFrame.getSellVehicleListPanel().setVisible(true);

		} else if (e.getActionCommand().equals("Search")) {

			System.out.println("inside search button"
					+ (String) managerFrame.getSearchVehicleListPanel()
							.getCategoryCombox().getSelectedItem());
			getVehicle(managerFrame);
		} else if (e.getActionCommand().equals("Add For Sale")) {
			
			
			int row = managerFrame.getSearchVehicleListPanel().getSearchtable()
					.getSelectedRow();
			if (row != -1) {
				managerFrame.getSellingVehicleDialog().setRegNumberTxt(managerFrame.getSearchVehicleListPanel().getSearchtable().getModel().getValueAt(row, 0).toString());
				managerFrame.getSellingVehicleDialog().setCategoryCombox(managerFrame.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 1).toString());
				managerFrame.getSellingVehicleDialog().setTypeCombox(managerFrame.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 2).toString());
				managerFrame.getSellingVehicleDialog().setBrandTxt((managerFrame.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 3).toString()));
				managerFrame.getSellingVehicleDialog().setVisible(true);
				
			}

		} else if (e.getActionCommand().equals("OK")) {
			SellVehicleVO sellVehicleVO = new SellVehicleVO();
			
			sellVehicleVO.setRegNo(managerFrame.getSellingVehicleDialog().getRegNumberTxt());
			sellVehicleVO.setPrice(managerFrame.getSellingVehicleDialog().getPrice());
			
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			sellVehicleVO.setForSaleFrom(sqlDate);
			
			boolean result = managerDao.sellVehicle(sellVehicleVO);
			
			if (result) {

				SuccessDialog dialog = new SuccessDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				getVehicle(managerFrame);
				dialog.setVisible(true);
				managerFrame.getSellingVehicleDialog().dispose();
				

			} else {

				FailureDialog dialog = new FailureDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				dialog.setVisible(true);

			}
			
				
			}
		
		
		else if (e.getActionCommand().equals("Sell")) {
			SellVehicleVO sellVehicleVO = new SellVehicleVO();
			int row = managerFrame.getSellVehicleListPanel().getSellTable()
					.getSelectedRow();
			if (row != -1) {
				sellVehicleVO.setRegNo(managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 0).toString());
				boolean result = managerDao.vehicleSold(sellVehicleVO);
				
				if (result) {

					SuccessDialog dialog = new SuccessDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);
					getVehicle(managerFrame);
					dialog.setVisible(true);
					managerDao.getVehiclesForSelling(managerFrame);
					

				} else {

					FailureDialog dialog = new FailureDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);
					dialog.setVisible(true);

				}
				
			}

		} else if (e.getActionCommand().equals("Update")) {
			VehicleVO vehicleVO = new VehicleVO();
			vehicleVO.setRegNo(managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().getRegNumberTxt());
			
			vehicleVO.setCategory((String)managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().getCategoryCombox().getSelectedItem());
			vehicleVO.setType((String)managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().getTypeCombox().getSelectedItem());
			vehicleVO.setBrand(managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().getBrandTxt());
			Date purchaseDate = managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().getCalendar()
					.getDate();
			java.sql.Date sqlDate = new java.sql.Date(purchaseDate.getTime());
			vehicleVO.setPurchaseDate(sqlDate);
			boolean result = managerDao.updateVehicle(vehicleVO);
			
			if (result) {

				SuccessDialog dialog = new SuccessDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				getVehicle(managerFrame);
				dialog.setVisible(true);
				
				

			} else {

				FailureDialog dialog = new FailureDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				dialog.setVisible(true);

			}
			
			

		} else if (e.getActionCommand().equals("Edit")) {
			
			//EditVehicleInfoDialog.getAddVehiclePanel().setRegNumberTxt(managerFrame.getSearchVehicleListPanel().getSearchtable().getSelectedRow());
			int row =managerFrame.getSearchVehicleListPanel().getSearchtable().getSelectedRow();
			if (row != -1) {
				managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().setRegNumberTxt( (String) managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 0).toString());
				managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().setCategoryCombox(managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 1).toString());
				managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().setTypeCombox(managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 2).toString());
				managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().setBrandTxt(managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 3).toString());
				managerFrame.getEditVehicleInfoDialog().getAddVehiclePanel().setCalendar(managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 4).toString());
				
				managerFrame.getEditVehicleInfoDialog().setVisible(true);
				
			}
			
		}
		
		else if (e.getActionCommand().equals("Change Price")) {
			
			
			
			//EditVehicleInfoDialog.getAddVehiclePanel().setRegNumberTxt(managerFrame.getSearchVehicleListPanel().getSearchtable().getSelectedRow());
			int row =managerFrame.getSellVehicleListPanel().getSellTable().getSelectedRow();
			if (row != -1) {
				managerFrame.getEditForSalePriceDialog().setRegisterNumber((String) managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 0).toString());
				managerFrame.getEditForSalePriceDialog().setPrice((String) managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 1).toString());
				managerFrame.getEditForSalePriceDialog().setVisible(true);
				
			}
			
		} else if (e.getActionCommand().equals("Confirm Change")) {
			SellVehicleVO sellVehicleVO = new SellVehicleVO();
			sellVehicleVO.setRegNo(managerFrame.getEditForSalePriceDialog().getRegisterNumber());
			sellVehicleVO.setPrice(managerFrame.getEditForSalePriceDialog().getPrice());
			
			boolean result = managerDao.updateSellingPrice(sellVehicleVO);
			
			if (result) {

				SuccessDialog dialog = new SuccessDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				getVehicle(managerFrame);
				dialog.setVisible(true);
				managerDao.getVehiclesForSelling(managerFrame);
				managerFrame.getEditForSalePriceDialog().dispose();
				

			} else {

				FailureDialog dialog = new FailureDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				dialog.setVisible(true);

			}
			
			
		}
		
		else if (e.getActionCommand().equals("To-Rent")) {
			
			
			SellVehicleVO sellVehicleVO = new SellVehicleVO();
			//EditVehicleInfoDialog.getAddVehiclePanel().setRegNumberTxt(managerFrame.getSearchVehicleListPanel().getSearchtable().getSelectedRow());
			int row =managerFrame.getSellVehicleListPanel().getSellTable().getSelectedRow();
			if (row != -1) {
				sellVehicleVO.setRegNo((String) managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 0).toString());
				boolean result = managerDao.moveForRent(sellVehicleVO);
				
				if (result) {

					SuccessDialog dialog = new SuccessDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);
					getVehicle(managerFrame);
					dialog.setVisible(true);
					managerDao.getVehiclesForSelling(managerFrame);
					
					

				} else {

					FailureDialog dialog = new FailureDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);
					dialog.setVisible(true);

				}
								
			}
			
			
		}
		
		else if (e.getActionCommand().equals("Save Other Rates")){
			SuperRent superRent = new SuperRent();
			saveOtherRates(superRent);
		}
		
		else if (e.getActionCommand().equals("rentalRateSaveEdit")) {
			
			int row = managerFrame.getManageRatesPanel().getRentalRateTable().getSelectedRow();
			SuperRentRentalRate superRentRentalRate = new SuperRentRentalRate();
			if(row != -1){
				superRentRentalRate.setCategory(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 1).toString());
				superRentRentalRate.setType(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 2).toString());
				superRentRentalRate.setDailyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 3).toString()));
				superRentRentalRate.setWeeklyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 4).toString()));
				superRentRentalRate.setHourlyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 5).toString()));
				superRentRentalRate.setPerKMRate(Double.parseDouble(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 6).toString()));
				superRentRentalRate.setMileageLimit(Double.parseDouble(managerFrame.getManageRatesPanel().getRentalRateTable().getModel().getValueAt(row, 7).toString()));
				boolean result = managerDao.updateRentalRate(superRentRentalRate);
				
				if (result) {

					SuccessDialog dialog = new SuccessDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);		
					dialog.setVisible(true);
					getRentalRates();
					

				} else {

					FailureDialog dialog = new FailureDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);
					dialog.setVisible(true);
					

				}
			}
			
		} else if (e.getActionCommand().equals("SaveInsuranceRate")) {
			
			int row = managerFrame.getManageRatesPanel().getInsuranceTable().getSelectedRow();
			SuperRentInsuranceRate superRentInsuranceRate = new SuperRentInsuranceRate();
			if(row != -1){
				superRentInsuranceRate.setCategory(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 1).toString());
				superRentInsuranceRate.setType(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 2).toString());
				superRentInsuranceRate.setDailyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 3).toString()));
				superRentInsuranceRate.setWeeklyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 4).toString()));
				superRentInsuranceRate.setHourlyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 5).toString()));
				//superRentInsuranceRate.setPerKMRate(Double.parseDouble(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 6).toString()));
				//superRentInsuranceRate.setMileageLimit(Double.parseDouble(managerFrame.getManageRatesPanel().getInsuranceTable().getModel().getValueAt(row, 7).toString()));
				boolean result = managerDao.updateInsuranceRate(superRentInsuranceRate);
				
				if (result) {

					SuccessDialog dialog = new SuccessDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);		
					dialog.setVisible(true);
					getInsuranceRates();
					

				} else {

					FailureDialog dialog = new FailureDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(
							(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
									- dialog.getWidth() / 2, (Toolkit
									.getDefaultToolkit().getScreenSize().height)
									/ 2 - dialog.getHeight() / 2);
					dialog.setVisible(true);
					

				}
			}
			
		}	
		
		 else if (e.getActionCommand().equals("Additional Equipment Save")) {
				
				int row = managerFrame.getManageRatesPanel().getAdditionalEquipmentTable().getSelectedRow();
				AdditionalEquipment additionalEquipment = new AdditionalEquipment();
				if(row != -1){
					additionalEquipment.setCategory(managerFrame.getManageRatesPanel().getAdditionalEquipmentTable().getModel().getValueAt(row, 2).toString());
					
					additionalEquipment.setDailyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getAdditionalEquipmentTable().getModel().getValueAt(row, 4).toString()));
					
					additionalEquipment.setHourlyRate(Double.parseDouble(managerFrame.getManageRatesPanel().getAdditionalEquipmentTable().getModel().getValueAt(row, 3).toString()));
					
					boolean result = managerDao.updateAddnEquipRate(additionalEquipment);
					
					if (result) {

						SuccessDialog dialog = new SuccessDialog();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocation(
								(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
										- dialog.getWidth() / 2, (Toolkit
										.getDefaultToolkit().getScreenSize().height)
										/ 2 - dialog.getHeight() / 2);		
						dialog.setVisible(true);
						getAddnEquipRates();
						

					} else {

						FailureDialog dialog = new FailureDialog();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocation(
								(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
										- dialog.getWidth() / 2, (Toolkit
										.getDefaultToolkit().getScreenSize().height)
										/ 2 - dialog.getHeight() / 2);
						dialog.setVisible(true);
						

					}
				}
				
			}
	}
	public void getInsuranceRates() {
		
		
		managerDao.getInsuranceRates(managerFrame);
		managerFrame.getManageRatesPanel().getSaveInsuranceRateBtn().setEnabled(false);
		managerFrame.getManageRatesPanel().getBtnCancelInsuranceEdit().setEnabled(false);
		managerFrame.getManageRatesPanel().getBtnEditInsuranceRate().setEnabled(true);	
	}

	public void getRentalRates() {
	
		managerDao.getRentalRate(managerFrame);
		managerFrame.getManageRatesPanel().getRentalRateSaveEditBtn().setEnabled(false);
		managerFrame.getManageRatesPanel().getBtnCancelEditRental().setEnabled(false);
		managerFrame.getManageRatesPanel().getBtnEditRentalRate().setEnabled(true);	
	}
	
	public void getAddnEquipRates() {
			
		
		managerDao.getAddnEquipRates(managerFrame);
		managerFrame.getManageRatesPanel().getBtnAddnEquipSaveBtn().setEnabled(false);
		managerFrame.getManageRatesPanel().getBtnAddnEquipCanel().setEnabled(false);
		managerFrame.getManageRatesPanel().getBtnEditSelectedRate().setEnabled(true);	
		
	}

	private void assembleOtherRates(SuperRent superRent) {
		
		managerFrame.getManageRatesPanel().setMembershipTxtField(String.valueOf(superRent.getMembershipFees()));
		managerFrame.getManageRatesPanel().setTaxField(String.valueOf(superRent.getTax()));
		managerFrame.getManageRatesPanel().setMemPointsTxt(String.valueOf(superRent.getMembershipPoints()));
		managerFrame.getManageRatesPanel().setFuelRateTxt(String.valueOf(superRent.getFuelRate()));
		managerFrame.getManageRatesPanel().setClubPointsPerDollarTxt(String.valueOf(superRent.getOneClubPoint()));
		managerFrame.getManageRatesPanel().setMinReedemablePointsTxt(superRent.getReedemablePoints());
		
	}
	
	private void saveOtherRates(SuperRent superRent) {
		
		if(!managerFrame.getManageRatesPanel().getMembershipTxtField().equalsIgnoreCase(null)){
			superRent.setMembershipFees(Double.parseDouble(managerFrame.getManageRatesPanel().getMembershipTxtField()));
		}
		if(!managerFrame.getManageRatesPanel().getTaxField().equalsIgnoreCase(null)){
			superRent.setTax(Double.parseDouble(managerFrame.getManageRatesPanel().getTaxField()));
		}
		if(!managerFrame.getManageRatesPanel().getFuelRateTxt().equalsIgnoreCase(null)){
			superRent.setFuelRate(Double.parseDouble(managerFrame.getManageRatesPanel().getFuelRateTxt()));
		}
		if(!managerFrame.getManageRatesPanel().getClubPointsPerDollarTxt().equalsIgnoreCase(null)){
			superRent.setOneClubPoint(Double.parseDouble(managerFrame.getManageRatesPanel().getClubPointsPerDollarTxt()));
		}
		if(!managerFrame.getManageRatesPanel().getMinReedemablePointsTxt().equalsIgnoreCase(null)){
			superRent.setReedemablePoints(managerFrame.getManageRatesPanel().getMinReedemablePointsTxt().toString());
		}
		if(!managerFrame.getManageRatesPanel().getMemPointsTxt().equalsIgnoreCase(null)){
			superRent.setMembershipPoints(Integer.parseInt(managerFrame.getManageRatesPanel().getMemPointsTxt()));
		}
		
		
		boolean result = managerDao.saveOtherRates(superRent);
		
		if (result) {

			SuccessDialog dialog = new SuccessDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(
					(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
							- dialog.getWidth() / 2, (Toolkit
							.getDefaultToolkit().getScreenSize().height)
							/ 2 - dialog.getHeight() / 2);		
			dialog.setVisible(true);
			assembleOtherRates(superRent);;

		} else {

			FailureDialog dialog = new FailureDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(
					(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
							- dialog.getWidth() / 2, (Toolkit
							.getDefaultToolkit().getScreenSize().height)
							/ 2 - dialog.getHeight() / 2);
			dialog.setVisible(true);
			

		}
	
	}

	private void disablePanels() {

		managerFrame.getAddVehiclePanel().setEnabled(false);
		managerFrame.getAddVehiclePanel().setVisible(false);
		managerFrame.getSellVehicleListPanel().setEnabled(false);
		managerFrame.getSellVehicleListPanel().setVisible(false);
		managerFrame.getSearchVehicleListPanel().setEnabled(false);
		managerFrame.getSearchVehicleListPanel().setVisible(false);
		managerFrame.getManageRatesPanel().setEnabled(false);
		managerFrame.getManageRatesPanel().setVisible(false);

	}

	public void getVehicleForSelling(ManagerHome managerFrame2) {
		// TODO Auto-generated method stub
		managerDao.getVehiclesForSelling(managerFrame);

	}

	public void getVehicle(ManagerHome managerFrame) {

		managerDao.getAllVehicles(managerFrame);

	}

}
