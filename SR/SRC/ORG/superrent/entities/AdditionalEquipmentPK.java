
package org.superrent.entities;

import java.io.Serializable;

/**
 *
 * @author welcome
 */
public class AdditionalEquipmentPK implements Serializable {
    
    private int branchID;
   
    private String equipmentName;
    
    private String category;

    public AdditionalEquipmentPK() {
    }

    public AdditionalEquipmentPK(int branchID, String equipmentName, String category) {
        this.branchID = branchID;
        this.equipmentName = equipmentName;
        this.category = category;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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
        hash += (int) branchID;
        hash += (equipmentName != null ? equipmentName.hashCode() : 0);
        hash += (category != null ? category.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdditionalEquipmentPK)) {
            return false;
        }
        AdditionalEquipmentPK other = (AdditionalEquipmentPK) object;
        if (this.branchID != other.branchID) {
            return false;
        }
        if ((this.equipmentName == null && other.equipmentName != null) || (this.equipmentName != null && !this.equipmentName.equals(other.equipmentName))) {
            return false;
        }
        if ((this.category == null && other.category != null) || (this.category != null && !this.category.equals(other.category))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.AdditionalEquipmentPK[ branchID=" + branchID + ", equipmentName=" + equipmentName + ", category=" + category + " ]";
    }
    
}
