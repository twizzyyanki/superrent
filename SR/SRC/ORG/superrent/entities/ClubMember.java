package org.superrent.entities;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author welcome
 */

public class ClubMember implements Serializable {
    private static final long serialVersionUID = 1L;
  
    private Integer membershipNo;
   
    private double points;
    
    private Date datecreated;
   
    private User uid;

    public ClubMember() {
    }

    public ClubMember(Integer membershipNo) {
        this.membershipNo = membershipNo;
    }

    public ClubMember(Integer membershipNo, double points, Date datecreated) {
        this.membershipNo = membershipNo;
        this.points = points;
        this.datecreated = datecreated;
    }

    public Integer getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(Integer membershipNo) {
        this.membershipNo = membershipNo;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membershipNo != null ? membershipNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClubMember)) {
            return false;
        }
        ClubMember other = (ClubMember) object;
        if ((this.membershipNo == null && other.membershipNo != null) || (this.membershipNo != null && !this.membershipNo.equals(other.membershipNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.ClubMember[ membershipNo=" + membershipNo + " ]";
    }
    
}
