/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superrent.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author welcome
 */

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer confirmationNo;
    
    private Date pickDate;
    
    private Date dropDate;
    
    private Date date;
    
    private double charges;
    
    private Collection<MakeReservation> makeReservationCollection;
   
    private Collection<RentAgreement> rentAgreementCollection;
  
    private Collection<RequireAdditionalEquipment> requireAdditionalEquipmentCollection;

    public Reservation() {
    }

    public Reservation(Integer confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public Reservation(Integer confirmationNo, Date pickDate, Date dropDate, Date date, double charges) {
        this.confirmationNo = confirmationNo;
        this.pickDate = pickDate;
        this.dropDate = dropDate;
        this.date = date;
        this.charges = charges;
    }

    public Integer getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(Integer confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public Date getDropDate() {
        return dropDate;
    }

    public void setDropDate(Date dropDate) {
        this.dropDate = dropDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public Collection<MakeReservation> getMakeReservationCollection() {
        return makeReservationCollection;
    }

    public void setMakeReservationCollection(Collection<MakeReservation> makeReservationCollection) {
        this.makeReservationCollection = makeReservationCollection;
    }

    public Collection<RentAgreement> getRentAgreementCollection() {
        return rentAgreementCollection;
    }

    public void setRentAgreementCollection(Collection<RentAgreement> rentAgreementCollection) {
        this.rentAgreementCollection = rentAgreementCollection;
    }

    public Collection<RequireAdditionalEquipment> getRequireAdditionalEquipmentCollection() {
        return requireAdditionalEquipmentCollection;
    }

    public void setRequireAdditionalEquipmentCollection(Collection<RequireAdditionalEquipment> requireAdditionalEquipmentCollection) {
        this.requireAdditionalEquipmentCollection = requireAdditionalEquipmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (confirmationNo != null ? confirmationNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.confirmationNo == null && other.confirmationNo != null) || (this.confirmationNo != null && !this.confirmationNo.equals(other.confirmationNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.Reservation[ confirmationNo=" + confirmationNo + " ]";
    }
    
}
