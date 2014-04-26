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

public class SuperRentInsuranceRate implements Serializable {
    private static final long serialVersionUID = 1L;
  
    protected SuperRentInsuranceRatePK superRentInsuranceRatePK;   
  
    private String category;
    
    private String type;
    
    private double hourlyRate;
    
    private double dailyRate;
   
    private double weeklyRate;
   
    private Date updateData;
   
    private SuperRent superRent;

    public SuperRentInsuranceRate() {
    }

    public SuperRentInsuranceRate(SuperRentInsuranceRatePK superRentInsuranceRatePK) {
        this.superRentInsuranceRatePK = superRentInsuranceRatePK;
    }

    public SuperRentInsuranceRate(SuperRentInsuranceRatePK superRentInsuranceRatePK, double dailyRate, double hourlyRate, double weeklyRate, Date updateData) {
        this.superRentInsuranceRatePK = superRentInsuranceRatePK;
        this.dailyRate = dailyRate;
        this.hourlyRate = hourlyRate;
        this.weeklyRate = weeklyRate;
        this.updateData = updateData;
    }

    public SuperRentInsuranceRate(int branchID, String category, String type) {
        this.superRentInsuranceRatePK = new SuperRentInsuranceRatePK(branchID, category, type);
    }

    public SuperRentInsuranceRatePK getSuperRentInsuranceRatePK() {
        return superRentInsuranceRatePK;
    }

    public void setSuperRentInsuranceRatePK(SuperRentInsuranceRatePK superRentInsuranceRatePK) {
        this.superRentInsuranceRatePK = superRentInsuranceRatePK;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWeeklyRate() {
        return weeklyRate;
    }

    public void setWeeklyRate(double weeklyRate) {
        this.weeklyRate = weeklyRate;
    }

    public Date getUpdateData() {
        return updateData;
    }

    public void setUpdateData(Date updateData) {
        this.updateData = updateData;
    }

    public SuperRent getSuperRent() {
        return superRent;
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

	public void setSuperRent(SuperRent superRent) {
        this.superRent = superRent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (superRentInsuranceRatePK != null ? superRentInsuranceRatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuperRentInsuranceRate)) {
            return false;
        }
        SuperRentInsuranceRate other = (SuperRentInsuranceRate) object;
        if ((this.superRentInsuranceRatePK == null && other.superRentInsuranceRatePK != null) || (this.superRentInsuranceRatePK != null && !this.superRentInsuranceRatePK.equals(other.superRentInsuranceRatePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.SuperRentInsuranceRate[ superRentInsuranceRatePK=" + superRentInsuranceRatePK + " ]";
    }
    
}
