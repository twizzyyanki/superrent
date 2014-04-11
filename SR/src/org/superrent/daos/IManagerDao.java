package org.superrent.daos;

import org.superrent.views.manager.ManagerHome;


public interface IManagerDao {

	public void getAllVehicles(ManagerHome managerFrame);
	
	public void getVehiclesForSelling(ManagerHome managerFrame);
}
