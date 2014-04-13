package org.superrent.entities;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author welcome
 */

public class RentAgreement implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer agreementNo;
  
    private String driverLicenseNo;
   
    private double odometer;
   
    private String fuelLevel;
    
    private boolean roadstar;
   
    private String vehicleDescription;
   
    private Date dateCreated;
   
    private CreditCard creditCard;
   
    private Reservation confirmationNo;

    public RentAgreement() {
    }

    public RentAgreement(Integer agreementNo) {
        this.agreementNo = agreementNo;
    }

    public RentAgreement(Integer agreementNo, String driverLicenseNo, double odometer, String fuelLevel, boolean roadstar, String vehicleDescription, Date dateCreated) {
        this.agreementNo = agreementNo;
        this.driverLicenseNo = driverLicenseNo;
        this.odometer = odometer;
        this.fuelLevel = fuelLevel;
        this.roadstar = roadstar;
        this.vehicleDescription = vehicleDescription;
        this.dateCreated = dateCreated;
    }

    public Integer getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(Integer agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public String getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(String fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean getRoadstar() {
        return roadstar;
    }

    public void setRoadstar(boolean roadstar) {
        this.roadstar = roadstar;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Reservation getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(Reservation confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agreementNo != null ? agreementNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RentAgreement)) {
            return false;
        }
        RentAgreement other = (RentAgreement) object;
        if ((this.agreementNo == null && other.agreementNo != null) || (this.agreementNo != null && !this.agreementNo.equals(other.agreementNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.RentAgreement[ agreementNo=" + agreementNo + " ]";
    }

}
