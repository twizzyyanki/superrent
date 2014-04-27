/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superrent.entities;

import java.io.Serializable;

/**
 *
 * @author welcome
 */

public class RequireAdditionalEquipment implements Serializable {
    private static final long serialVersionUID = 1L;
  
    protected RequireAdditionalEquipmentPK requireAdditionalEquipmentPK;
    
    private String equipmentName;
    
    private int quantity;
    
    private Reservation reservation;
    
    private SuperRent superRent;

    public RequireAdditionalEquipment() {
    }

    public RequireAdditionalEquipment(RequireAdditionalEquipmentPK requireAdditionalEquipmentPK) {
        this.requireAdditionalEquipmentPK = requireAdditionalEquipmentPK;
    }

    public RequireAdditionalEquipment(RequireAdditionalEquipmentPK requireAdditionalEquipmentPK, String equipmentName) {
        this.requireAdditionalEquipmentPK = requireAdditionalEquipmentPK;
        this.equipmentName = equipmentName;
    }

    public RequireAdditionalEquipment(int confirmationNo, int branchID, String category) {
        this.requireAdditionalEquipmentPK = new RequireAdditionalEquipmentPK(confirmationNo, branchID, category);
    }

    public RequireAdditionalEquipmentPK getRequireAdditionalEquipmentPK() {
        return requireAdditionalEquipmentPK;
    }

    public void setRequireAdditionalEquipmentPK(RequireAdditionalEquipmentPK requireAdditionalEquipmentPK) {
        this.requireAdditionalEquipmentPK = requireAdditionalEquipmentPK;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public SuperRent getSuperRent() {
        return superRent;
    }

    public void setSuperRent(SuperRent superRent) {
        this.superRent = superRent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requireAdditionalEquipmentPK != null ? requireAdditionalEquipmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequireAdditionalEquipment)) {
            return false;
        }
        RequireAdditionalEquipment other = (RequireAdditionalEquipment) object;
        if ((this.requireAdditionalEquipmentPK == null && other.requireAdditionalEquipmentPK != null) || (this.requireAdditionalEquipmentPK != null && !this.requireAdditionalEquipmentPK.equals(other.requireAdditionalEquipmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.RequireAdditionalEquipment[ requireAdditionalEquipmentPK=" + requireAdditionalEquipmentPK + " ]";
    }

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
    
}
