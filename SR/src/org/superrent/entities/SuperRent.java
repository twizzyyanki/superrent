/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superrent.entities;

import java.io.Serializable;
import java.util.Collection;
/**
 *
 * @author welcome
 */

public class SuperRent implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer branchID;
 
    private String location;
   
    private double tax;
    
    private double membershipFees;
    
    private Integer membershipPoints;
    
    private double fuelRate;
   
    private Collection<Vehicle> vehicleCollection;
   
    private Collection<Vehicle> vehicleCollection1;
    
    private Collection<SuperRentRentalRate> superRentRentalRateCollection;
   
    private Collection<RequireAdditionalEquipment> requireAdditionalEquipmentCollection;
   
    private Collection<SuperRentInsuranceRate> superRentInsuranceRateCollection;

    public SuperRent() {
    }

    public SuperRent(Integer branchID) {
        this.branchID = branchID;
    }

    public SuperRent(Integer branchID, String location, double tax, double membershipFees) {
        this.branchID = branchID;
        this.location = location;
        this.tax = tax;
        this.membershipFees = membershipFees;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getMembershipFees() {
        return membershipFees;
    }

    public void setMembershipFees(double membershipFees) {
        this.membershipFees = membershipFees;
    }

    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }

    public Collection<Vehicle> getVehicleCollection1() {
        return vehicleCollection1;
    }

    public void setVehicleCollection1(Collection<Vehicle> vehicleCollection1) {
        this.vehicleCollection1 = vehicleCollection1;
    }

    public Collection<SuperRentRentalRate> getSuperRentRentalRateCollection() {
        return superRentRentalRateCollection;
    }

    public void setSuperRentRentalRateCollection(Collection<SuperRentRentalRate> superRentRentalRateCollection) {
        this.superRentRentalRateCollection = superRentRentalRateCollection;
    }

    public Collection<RequireAdditionalEquipment> getRequireAdditionalEquipmentCollection() {
        return requireAdditionalEquipmentCollection;
    }

    public void setRequireAdditionalEquipmentCollection(Collection<RequireAdditionalEquipment> requireAdditionalEquipmentCollection) {
        this.requireAdditionalEquipmentCollection = requireAdditionalEquipmentCollection;
    }

    public Collection<SuperRentInsuranceRate> getSuperRentInsuranceRateCollection() {
        return superRentInsuranceRateCollection;
    }

    public void setSuperRentInsuranceRateCollection(Collection<SuperRentInsuranceRate> superRentInsuranceRateCollection) {
        this.superRentInsuranceRateCollection = superRentInsuranceRateCollection;
    }

    public Integer getMembershipPoints() {
		return membershipPoints;
	}

	public void setMembershipPoints(Integer membershipPoints) {
		this.membershipPoints = membershipPoints;
	}

	public double getFuelRate() {
		return fuelRate;
	}

	public void setFuelRate(double fuelRate) {
		this.fuelRate = fuelRate;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (branchID != null ? branchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuperRent)) {
            return false;
        }
        SuperRent other = (SuperRent) object;
        if ((this.branchID == null && other.branchID != null) || (this.branchID != null && !this.branchID.equals(other.branchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.SuperRent[ branchID=" + branchID + " ]";
    }
    
}
