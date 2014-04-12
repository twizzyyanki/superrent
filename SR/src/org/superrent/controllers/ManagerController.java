package org.superrent.controllers;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDialog;

import org.superrent.daos.IManagerDao;
import org.superrent.daos.ManagerDaoImpl;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.FailureDialog;
import org.superrent.views.manager.ManagerHome;
import org.superrent.views.manager.SuccessDialog;

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
			managerFrame.getManageRatesPanel().setEnabled(true);
			managerFrame.getManageRatesPanel().setVisible(true);

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
				String regNumber = (String) managerFrame
						.getSearchVehicleListPanel().getSearchtable()
						.getModel().getValueAt(row, 0);
				System.out.println("Add entry into vehicle for sale table"
						+ row + "---" + regNumber);
			}

		} else if (e.getActionCommand().equals("Sell")) {

			int row = managerFrame.getSellVehicleListPanel().getSellTable()
					.getSelectedRow();
			if (row != -1) {
				String regNumber = (String) managerFrame
						.getSellVehicleListPanel().getSellTable().getModel()
						.getValueAt(row, 0);
				System.out
						.println("Delete entry in vehicle and vehicle for sale table"
								+ row + "---" + regNumber);
			}

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

	private void getVehicleForSelling(ManagerHome managerFrame2) {
		// TODO Auto-generated method stub
		managerDao.getVehiclesForSelling(managerFrame);

	}

	public void getVehicle(ManagerHome managerFrame) {

		managerDao.getAllVehicles(managerFrame);

	}

}
