package org.superrent.controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JDialog;

import org.superrent.daos.ChangePasswordDAO;
import org.superrent.daos.IManagerDao;
import org.superrent.daos.ManagerDaoImpl;
import org.superrent.daos.UpdateProfileDAO;
import org.superrent.entities.AdditionalEquipment;
import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.SuperRent;
import org.superrent.entities.SuperRentInsuranceRate;
import org.superrent.entities.SuperRentRentalRate;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.FailureDialog;
import org.superrent.views.manager.ManagerHome;
import org.superrent.views.manager.SuccessDialog;
import org.superrent.views.manager.UpdateProfileForManager;
import org.superrent.views.manager.VehicleExistsDialog;
import org.superrent.views.superadmin.UpdateProfile;

public class ManagerController implements ActionListener {

	private final ManagerHome managerFrame;
	IManagerDao managerDao = new ManagerDaoImpl();
	

	public ManagerController(ManagerHome sampleFrame) {

		managerFrame = sampleFrame;

	}

	// @Override
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());

		if (e.getActionCommand().equals("Add Vehicle")) {
			System.out.println("Getting here");
			disablePanels();

			managerFrame.getAddVehiclePanel().setEnabled(true);
			managerFrame.getAddVehiclePanel().setVisible(true);

		}
		else if(e.getActionCommand().equals("change Password")){
			
			disablePanels();
			managerFrame.getChangePasswordPanel().setEnabled(true);
			managerFrame.getChangePasswordPanel().setVisible(true);
			
		}
		else if(e.getActionCommand().equals("ConfirmPassword")){
			ChangePasswordDAO checkPassword = new ChangePasswordDAO();
			managerFrame.getChangePasswordPanel().getWrongInput().setText("");
			char[] oldPassword = managerFrame.getChangePasswordPanel().getCurrentPass().getPassword();
			String oldPass = new String (oldPassword);
			Boolean inDatabase = false;
			//Boolean updateSucess = false;
			// checkOldPassword method to check password in DB
			inDatabase = checkPassword.checkOldPassword(oldPass);
			
			if(inDatabase){
				char[] newPassword = managerFrame.getChangePasswordPanel().getNewPass().getPassword();
				String newPass = new String (newPassword);
				char[] confirmPassword = managerFrame.getChangePasswordPanel().getConfirmNewPass().getPassword();
				//String confirmPass = new String (confirmPassword);
				if(Arrays.equals(newPassword, confirmPassword)){
					ChangePasswordDAO setPassword = new ChangePasswordDAO();
					if(setPassword.setNewPassword(newPass)){
						managerFrame.getChangePasswordPanel().getWrongInput().setForeground(Color.BLACK);
						managerFrame.getChangePasswordPanel().getWrongInput().setText("Update success");
					}
					else{
						
						managerFrame.getChangePasswordPanel().getWrongInput().setForeground(Color.RED);
						managerFrame.getChangePasswordPanel().getWrongInput().setText("Update fail");
					}
					
				}
				else{
					
					managerFrame.getChangePasswordPanel().getWrongInput().setForeground(Color.RED);
					managerFrame.getChangePasswordPanel().getWrongInput().setText("Confirm password does not match with new Password");			
				}
				
			}
			else{
				managerFrame.getChangePasswordPanel().getWrongInput().setForeground(Color.RED);
				managerFrame.getChangePasswordPanel().getWrongInput().setText("Current password does not match");
			}
			

			
		}
		else if(e.getActionCommand().equals("Reports")){			
				
				disablePanels();
				managerFrame.getReportsPanel().setEnabled(true);
				managerFrame.getReportsPanel().setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Edit Profile Details")){			
			
			disablePanels();
			
			UpdateProfileDAO nameDAO = new UpdateProfileDAO();
			UpdateProfileDAO phoneDAO = new UpdateProfileDAO();
			UpdateProfileDAO addressDAO = new UpdateProfileDAO();
			UpdateProfileDAO emailDao = new UpdateProfileDAO();
			String name = nameDAO.getName();
			String phone = String.valueOf(phoneDAO.getPhoneNumber());
			String address = addressDAO.getAddress();
			String email = emailDao.getEmail();
			
			managerFrame.getUpdateProfileForManager().getTextName().setText(name);
			managerFrame.getUpdateProfileForManager().getTextPhone().setText(phone);
			managerFrame.getUpdateProfileForManager().getTextAddress().setText(address);
			managerFrame.getUpdateProfileForManager().getTxtEmail().setText(email);
			
			managerFrame.getUpdateProfileForManager().setEnabled(true);
			managerFrame.getUpdateProfileForManager().setVisible(true);

		
	}
		else if (e.getActionCommand().equals("Clerk View")){
			
			//disablePanels();
			managerFrame.setEnabled(false);
			managerFrame.setVisible(false);
			
			managerFrame.getClerkHome().setEnabled(true);
			managerFrame.getClerkHome().setVisible(true);
			managerFrame.getClerkHome().getBtnLogout().setVisible(false);
			managerFrame.getClerkHome().setLocation(
					(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
							- managerFrame.getClerkHome().getWidth() / 2, (Toolkit
							.getDefaultToolkit().getScreenSize().height)
							/ 2 - managerFrame.getClerkHome().getHeight() / 2);
			
			managerFrame.getClerkHome().addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                	managerFrame.setEnabled(true);
        			managerFrame.setVisible(true);
                    
                }
            });
		}
		
		else if (e.getActionCommand().equals("Save")) {
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

				SuccessDialog dialog = new SuccessDialog();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- dialog.getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - dialog.getHeight() / 2);
				dialog.setVisible(true);
				managerFrame.getAddVehiclePanel().clearVehicleScreen();

			} else {

				VehicleExistsDialog dialog = new VehicleExistsDialog();
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
				managerFrame.getSellingVehicleDialog().setCategoryCombox(managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
						.getValueAt(row, 1).toString());
				managerFrame.getSellingVehicleDialog().setTypeCombox(managerFrame
						.getSearchVehicleListPanel().getSearchtable().getModel()
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
				managerFrame.getEditVehicleInfoDialog().dispose();
				
				

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
				
				managerFrame.getEditVehicleInfoDialog().setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- managerFrame.getEditVehicleInfoDialog().getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - managerFrame.getEditVehicleInfoDialog().getHeight() / 2);
				
				managerFrame.getEditVehicleInfoDialog().setVisible(true);
				
			}
			
		}
		
		else if (e.getActionCommand().equals("Change Price")) {
			
			int row =managerFrame.getSellVehicleListPanel().getSellTable().getSelectedRow();
			if (row != -1) {
				managerFrame.getEditForSalePriceDialog().setRegisterNumber((String) managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 0).toString());
				managerFrame.getEditForSalePriceDialog().setPrice((String) managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 1).toString());
				managerFrame.getEditForSalePriceDialog().setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width) / 2
								- managerFrame.getEditForSalePriceDialog().getWidth() / 2, (Toolkit
								.getDefaultToolkit().getScreenSize().height)
								/ 2 - managerFrame.getEditForSalePriceDialog().getHeight() / 2);
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
		 	else if (e.getActionCommand().equals("Update")){

				
				// check if user enters text in name text area
				int nameSuccess = 1;
				int phoneSuccess = 1;
				int addressSucess = 1;
				int emailSuccess = 1;
				String updateInfosString="";
				managerFrame.getUpdateProfileForManager().getTextPhone().setForeground(Color.black);
				managerFrame.getUpdateProfileForManager().getUpdateInfo().setText("");
				
				// check if user enters text in name text area
				if(managerFrame.getUpdateProfileForManager().getTextName().getText()!=null && 
						managerFrame.getUpdateProfileForManager().getTextName().getText().trim().length()!=0){
					// check if text area is "Update Success" to prevent updating 
					if(!managerFrame.getUpdateProfileForManager().getTextName().getText().equals("Update Success")){
						UpdateProfileDAO updateNameDAO = new UpdateProfileDAO();
						if(updateNameDAO.updateName(managerFrame.getUpdateProfileForManager().getTextName().getText())){
							nameSuccess = 1;
							updateInfosString = updateInfosString + "Update name success<br>";
						}
						else {
							nameSuccess = 0;
							updateInfosString = updateInfosString + "Update name fail<br>";
						}
						
					}
					else{
						managerFrame.getUpdateProfileForManager().getTextName().setForeground(Color.black);
						managerFrame.getUpdateProfileForManager().getTextName().setText("");
					}

				}
				
				// check if user enters text in phone text area
				if(managerFrame.getUpdateProfileForManager().getTextPhone().getText()!=null && 
						managerFrame.getUpdateProfileForManager().getTextPhone().getText().trim().length()!=0){		
					
					// check if text area is "Update Success" to prevent updating 
					if(!managerFrame.getUpdateProfileForManager().getTextPhone().getText().equals("Update Success")){
						UpdateProfileDAO updatePhoneDAO = new UpdateProfileDAO();
						String newPhoneNumber = managerFrame.getUpdateProfileForManager().getTextPhone().getText();
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
						managerFrame.getUpdateProfileForManager().getTextPhone().setForeground(Color.black);
						managerFrame.getUpdateProfileForManager().getTextPhone().setText("");
					}
				}
				
					
				// check if user enters text in address text area
				if(managerFrame.getUpdateProfileForManager().getTextAddress().getText()!=null &&				
						managerFrame.getUpdateProfileForManager().getTextAddress().getText().trim().length()!=0){		
					
						// check if text area is "Update Success" to prevent updating 
						if(!managerFrame.getUpdateProfileForManager().getTextAddress().getText().equals("Update Success")){
							UpdateProfileDAO updateAddressDAO = new UpdateProfileDAO();
							String newAddress = managerFrame.getUpdateProfileForManager().getTextAddress().getText();
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
							managerFrame.getUpdateProfileForManager().getTextAddress().setForeground(Color.black);
							managerFrame.getUpdateProfileForManager().getTextAddress().setText("");
						}
				}
				
				// check if user enters text in email text area
				if(managerFrame.getUpdateProfileForManager().getTxtEmail().getText()!=null &&				
						managerFrame.getUpdateProfileForManager().getTxtEmail().getText().trim().length()!=0){		
					
						// check if text area is "Update Success" to prevent updating 
						if(!managerFrame.getUpdateProfileForManager().getTxtEmail().getText().equals("Update Success")){
							UpdateProfileDAO updateEmailDAO = new UpdateProfileDAO();
							String email = managerFrame.getUpdateProfileForManager().getTxtEmail().getText();
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
							managerFrame.getUpdateProfileForManager().getTextAddress().setForeground(Color.black);
							managerFrame.getUpdateProfileForManager().getTextAddress().setText("");
						}
				}
				
				if(nameSuccess+phoneSuccess+addressSucess!=4){
					
					updateInfosString = "<html>"+ updateInfosString + "</html>";
					managerFrame.getUpdateProfileForManager().getUpdateInfo().setText(updateInfosString);
				}
				else
				{
					updateInfosString = "<html>"+ updateInfosString + "</html>";
					managerFrame.getUpdateProfileForManager().getUpdateInfo().setText(updateInfosString);
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
	
	/**
	 * @param superRent
	 */
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

	/**
	 * 
	 */
	private void disablePanels() {

		managerFrame.getAddVehiclePanel().setEnabled(false);
		managerFrame.getAddVehiclePanel().setVisible(false);
		managerFrame.getSellVehicleListPanel().setEnabled(false);
		managerFrame.getSellVehicleListPanel().setVisible(false);
		managerFrame.getSearchVehicleListPanel().setEnabled(false);
		managerFrame.getSearchVehicleListPanel().setVisible(false);
		managerFrame.getManageRatesPanel().setEnabled(false);
		managerFrame.getManageRatesPanel().setVisible(false);
		managerFrame.getReportsPanel().setEnabled(false);
		managerFrame.getReportsPanel().setVisible(false);
		managerFrame.getChangePasswordPanel().setEnabled(false);
		managerFrame.getChangePasswordPanel().setVisible(false);
		managerFrame.getUpdateProfileForManager().setEnabled(false);
		managerFrame.getUpdateProfileForManager().setVisible(false);
	}

	/**
	 * @param managerFrame2
	 */
	public void getVehicleForSelling(ManagerHome managerFrame2) {
		// TODO Auto-generated method stub
		managerDao.getVehiclesForSelling(managerFrame);

	}

	/**
	 * @param managerFrame
	 */
	public void getVehicle(ManagerHome managerFrame) {

		managerDao.getAllVehicles(managerFrame);

	}

}
