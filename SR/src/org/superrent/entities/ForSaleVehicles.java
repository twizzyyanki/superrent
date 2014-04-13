package org.superrent.entities;

import java.io.Serializable;
import java.util.Date;

public class ForSaleVehicles implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer regNo;
   
    private double price;
    
    private Date soldDate;
    
    private Date dateMadeAvailableForSale;
    
    private Vehicle vehicle;

    public ForSaleVehicles() {
    }

    public ForSaleVehicles(Integer regNo) {
        this.regNo = regNo;
    }

    public ForSaleVehicles(Integer regNo, double price, Date dateMadeAvailableForSale) {
        this.regNo = regNo;
        this.price = price;
        this.dateMadeAvailableForSale = dateMadeAvailableForSale;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public Date getDateMadeAvailableForSale() {
        return dateMadeAvailableForSale;
    }

    public void setDateMadeAvailableForSale(Date dateMadeAvailableForSale) {
        this.dateMadeAvailableForSale = dateMadeAvailableForSale;
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
        hash += (regNo != null ? regNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForSaleVehicles)) {
            return false;
        }
        ForSaleVehicles other = (ForSaleVehicles) object;
        if ((this.regNo == null && other.regNo != null) || (this.regNo != null && !this.regNo.equals(other.regNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.ForSaleVehicles[ regNo=" + regNo + " ]";
    }
    
}
