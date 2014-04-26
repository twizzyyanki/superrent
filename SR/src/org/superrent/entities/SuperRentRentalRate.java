/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superrent.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author welcome
 */

public class SuperRentRentalRate implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected SuperRentRentalRatePK superRentRentalRatePK;
   
    private double dailyRate;
    
    private String category;
    
    private String type;
   
    private double weeklyRate;
   
    private double hourlyRate;
   
    private double perKMRate;
   
    private double mileageLimit;
   
    private Date updateData;
   
    private SuperRent superRent;

    public SuperRentRentalRate() {
    }

    public SuperRentRentalRate(SuperRentRentalRatePK superRentRentalRatePK) {
        this.superRentRentalRatePK = superRentRentalRatePK;
    }

    public SuperRentRentalRate(SuperRentRentalRatePK superRentRentalRatePK, double dailyRate, double weeklyRate, double hourlyRate, double perKMRate, double mileageLimit, Date updateData) {
        this.superRentRentalRatePK = superRentRentalRatePK;
        this.dailyRate = dailyRate;
        this.weeklyRate = weeklyRate;
        this.hourlyRate = hourlyRate;
        this.perKMRate = perKMRate;
        this.mileageLimit = mileageLimit;
        this.updateData = updateData;
    }

    public SuperRentRentalRate(int branchID, String category, String type) {
        this.superRentRentalRatePK = new SuperRentRentalRatePK(branchID, category, type);
    }

    public SuperRentRentalRatePK getSuperRentRentalRatePK() {
        return superRentRentalRatePK;
    }

    public void setSuperRentRentalRatePK(SuperRentRentalRatePK superRentRentalRatePK) {
        this.superRentRentalRatePK = superRentRentalRatePK;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getWeeklyRate() {
        return weeklyRate;
    }

    public void setWeeklyRate(double weeklyRate) {
        this.weeklyRate = weeklyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getPerKMRate() {
        return perKMRate;
    }

    public void setPerKMRate(double perKMRate) {
        this.perKMRate = perKMRate;
    }

    public double getMileageLimit() {
        return mileageLimit;
    }

    public void setMileageLimit(double mileageLimit) {
        this.mileageLimit = mileageLimit;
    }

    public Date getUpdateData() {
        return updateData;
    }

    public void setUpdateData(Date date) {
        this.updateData = date;
    }

    public SuperRent getSuperRent() {
        return superRent;
    }

    public void setSuperRent(SuperRent superRent) {
        this.superRent = superRent;
    }

    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (superRentRentalRatePK != null ? superRentRentalRatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuperRentRentalRate)) {
            return false;
        }
        SuperRentRentalRate other = (SuperRentRentalRate) object;
        if ((this.superRentRentalRatePK == null && other.superRentRentalRatePK != null) || (this.superRentRentalRatePK != null && !this.superRentRentalRatePK.equals(other.superRentRentalRatePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.SuperRentRentalRate[ superRentRentalRatePK=" + superRentRentalRatePK + " ]";
    }

	
    
}
