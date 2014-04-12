package org.superrent.daos;

import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.ManagerHome;


public interface IManagerDao {

	public void getAllVehicles(ManagerHome managerFrame);
	
	public void getVehiclesForSelling(ManagerHome managerFrame);
	
	public void addVehicle(VehicleVO vehicleVO);
	
	public void updateVehicle(VehicleVO vehicleVO);
	
	public void sellVehicle(SellVehicleVO sellVehicleVO);
}
