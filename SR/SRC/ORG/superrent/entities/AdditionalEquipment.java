package org.superrent.entities;

import java.io.Serializable;

public class AdditionalEquipment implements Serializable {
    private static final long serialVersionUID = 1L;
   
    protected AdditionalEquipmentPK additionalEquipmentPK;
    
    private double hourlyRate;
   
    private double dailyRate;
    
    private String updateData;

    public AdditionalEquipment() {
    }

    public AdditionalEquipment(AdditionalEquipmentPK additionalEquipmentPK) {
        this.additionalEquipmentPK = additionalEquipmentPK;
    }

    public AdditionalEquipment(AdditionalEquipmentPK additionalEquipmentPK, double hourlyRate, double dailyRate, String updateData) {
        this.additionalEquipmentPK = additionalEquipmentPK;
        this.hourlyRate = hourlyRate;
        this.dailyRate = dailyRate;
        this.updateData = updateData;
    }

    public AdditionalEquipment(int branchID, String equipmentName, String category) {
        this.additionalEquipmentPK = new AdditionalEquipmentPK(branchID, equipmentName, category);
    }

    public AdditionalEquipmentPK getAdditionalEquipmentPK() {
        return additionalEquipmentPK;
    }

    public void setAdditionalEquipmentPK(AdditionalEquipmentPK additionalEquipmentPK) {
        this.additionalEquipmentPK = additionalEquipmentPK;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getUpdateData() {
        return updateData;
    }

    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (additionalEquipmentPK != null ? additionalEquipmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdditionalEquipment)) {
            return false;
        }
        AdditionalEquipment other = (AdditionalEquipment) object;
        if ((this.additionalEquipmentPK == null && other.additionalEquipmentPK != null) || (this.additionalEquipmentPK != null && !this.additionalEquipmentPK.equals(other.additionalEquipmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.AdditionalEquipment[ additionalEquipmentPK=" + additionalEquipmentPK + " ]";
    }
    
}
