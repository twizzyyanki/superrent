package org.superrent.daos;

import org.superrent.entities.AdditionalEquipment;
import org.superrent.entities.SellVehicleVO;
import org.superrent.entities.SuperRent;
import org.superrent.entities.SuperRentInsuranceRate;
import org.superrent.entities.SuperRentRentalRate;
import org.superrent.entities.VehicleVO;
import org.superrent.views.manager.ManagerHome;


public interface IManagerDao {

	public void getAllVehicles(ManagerHome managerFrame);
	
	public void getVehiclesForSelling(ManagerHome managerFrame);
	
	public boolean addVehicle(VehicleVO vehicleVO);
	
	public boolean updateVehicle(VehicleVO vehicleVO);
	
	public boolean sellVehicle(SellVehicleVO sellVehicleVO);
	
	public boolean vehicleSold(SellVehicleVO sellVehicleVO);

	public boolean updateSellingPrice(SellVehicleVO sellVehicleVO);

	boolean moveForRent(SellVehicleVO sellVehicleVO);

	public void getRentalRate(ManagerHome managerFrame);

	public void getInsuranceRates(ManagerHome managerFrame);
	
	public boolean otherRates();

	public SuperRent getOtherRates();

	public boolean saveOtherRates(SuperRent superRent);

	public boolean updateRentalRate(SuperRentRentalRate superRentRentalRate);

	public boolean updateInsuranceRate(
			SuperRentInsuranceRate superRentInsuranceRate);

	public void getAddnEquipRates(ManagerHome managerFrame);

	public boolean updateAddnEquipRate(AdditionalEquipment additionalEquipment);

	}
