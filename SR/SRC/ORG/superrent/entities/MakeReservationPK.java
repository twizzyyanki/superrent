package org.superrent.entities;

import java.io.Serializable;

/**
 *
 * @author welcome
 */

public class MakeReservationPK implements Serializable {
   
    private int uid;
    
    private int confirmationNo;
    
    private int regNo;

    public MakeReservationPK() {
    }

    public MakeReservationPK(int uid, int confirmationNo, int regNo) {
        this.uid = uid;
        this.confirmationNo = confirmationNo;
        this.regNo = regNo;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(int confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) uid;
        hash += (int) confirmationNo;
        hash += (int) regNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MakeReservationPK)) {
            return false;
        }
        MakeReservationPK other = (MakeReservationPK) object;
        if (this.uid != other.uid) {
            return false;
        }
        if (this.confirmationNo != other.confirmationNo) {
            return false;
        }
        if (this.regNo != other.regNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.MakeReservationPK[ uid=" + uid + ", confirmationNo=" + confirmationNo + ", regNo=" + regNo + " ]";
    }
    
}
