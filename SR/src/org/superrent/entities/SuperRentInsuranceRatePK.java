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

public class SuperRentInsuranceRatePK implements Serializable {
    
    private int branchID;
   
    private String category;
    
    private String type;

    public SuperRentInsuranceRatePK() {
    }

    public SuperRentInsuranceRatePK(int branchID, String category, String type) {
        this.branchID = branchID;
        this.category = category;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) branchID;
        hash += (category != null ? category.hashCode() : 0);
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuperRentInsuranceRatePK)) {
            return false;
        }
        SuperRentInsuranceRatePK other = (SuperRentInsuranceRatePK) object;
        if (this.branchID != other.branchID) {
            return false;
        }
        if ((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
            return false;
        }
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.SuperRentInsuranceRatePK[ branchID=" + branchID + ", category=" + category + ", type=" + type + " ]";
    }
    
}
