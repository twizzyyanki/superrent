package org.superrent.entities;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author welcome
 */

public class MakeReservation implements Serializable {
    private static final long serialVersionUID = 1L;
   
    protected MakeReservationPK makeReservationPK;   
    
    private Date lastUpdatedDate;
   
    private Integer uid;
    
    private Integer confirmationNo;
    
	private String regNo;
    
    private Integer status;
    
    
    public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

    public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MakeReservation() {
    }

    public MakeReservation(MakeReservationPK makeReservationPK) {
        this.makeReservationPK = makeReservationPK;
    }

    public MakeReservation(MakeReservationPK makeReservationPK, Date date) {
        this.makeReservationPK = makeReservationPK;
        this.lastUpdatedDate = date;
    }

    public MakeReservation(int uid, int confirmationNo, int regNo) {
        this.makeReservationPK = new MakeReservationPK(uid, confirmationNo, regNo);
    }

    public MakeReservationPK getMakeReservationPK() {
        return makeReservationPK;
    }

    public void setMakeReservationPK(MakeReservationPK makeReservationPK) {
        this.makeReservationPK = makeReservationPK;
    }

    public Integer getConfirmationNo() {
		return confirmationNo;
	}

	public void setConfirmationNo(Integer confirmationNo) {
		this.confirmationNo = confirmationNo;
	}

	public Date getDate() {
        return lastUpdatedDate;
    }

    public void setDate(Date date) {
        this.lastUpdatedDate = date;
    }

   

    public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (makeReservationPK != null ? makeReservationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MakeReservation)) {
            return false;
        }
        MakeReservation other = (MakeReservation) object;
        if ((this.makeReservationPK == null && other.makeReservationPK != null) || (this.makeReservationPK != null && !this.makeReservationPK.equals(other.makeReservationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.MakeReservation[ makeReservationPK=" + makeReservationPK + " ]";
    }
    
}
