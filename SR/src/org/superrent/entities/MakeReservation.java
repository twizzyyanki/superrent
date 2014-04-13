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
    
    private Date date;
   
    private User user;
    
    private Reservation reservation;
   
    private Vehicle vehicle;

    public MakeReservation() {
    }

    public MakeReservation(MakeReservationPK makeReservationPK) {
        this.makeReservationPK = makeReservationPK;
    }

    public MakeReservation(MakeReservationPK makeReservationPK, Date date) {
        this.makeReservationPK = makeReservationPK;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
