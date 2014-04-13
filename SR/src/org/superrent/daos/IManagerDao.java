package org.superrent.daos;

import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.ManagerHome;


public interface IManagerDao {

	public void getAllVehicles(ManagerHome managerFrame);
	
	public void getVehiclesForSelling(ManagerHome managerFrame);
	
	public boolean addVehicle(VehicleVO vehicleVO);
	
	public boolean updateVehicle(VehicleVO vehicleVO);
	
	public boolean sellVehicle(SellVehicleVO sellVehicleVO);
}
