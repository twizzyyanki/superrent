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

public class RequireAdditionalEquipmentPK implements Serializable {
   
    private int confirmationNo;
    
    private int branchID;
   
    private String category;

    public RequireAdditionalEquipmentPK() {
    }

    public RequireAdditionalEquipmentPK(int confirmationNo, int branchID, String category) {
        this.confirmationNo = confirmationNo;
        this.branchID = branchID;
        this.category = category;
    }

    public int getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(int confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) confirmationNo;
        hash += (int) branchID;
        hash += (category != null ? category.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequireAdditionalEquipmentPK)) {
            return false;
        }
        RequireAdditionalEquipmentPK other = (RequireAdditionalEquipmentPK) object;
        if (this.confirmationNo != other.confirmationNo) {
            return false;
        }
        if (this.branchID != other.branchID) {
            return false;
        }
        if ((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.RequireAdditionalEquipmentPK[ confirmationNo=" + confirmationNo + ", branchID=" + branchID + ", category=" + category + " ]";
    }
    
}
