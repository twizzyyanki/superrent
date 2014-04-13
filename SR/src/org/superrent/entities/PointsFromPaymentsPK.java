package org.superrent.entities;

import java.io.Serializable;

/**
 *
 * @author welcome
 */

public class PointsFromPaymentsPK implements Serializable {
   
    private int uid;
    
    private int pid;

    public PointsFromPaymentsPK() {
    }

    public PointsFromPaymentsPK(int uid, int pid) {
        this.uid = uid;
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) uid;
        hash += (int) pid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointsFromPaymentsPK)) {
            return false;
        }
        PointsFromPaymentsPK other = (PointsFromPaymentsPK) object;
        if (this.uid != other.uid) {
            return false;
        }
        if (this.pid != other.pid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.PointsFromPaymentsPK[ uid=" + uid + ", pid=" + pid + " ]";
    }
    
}
