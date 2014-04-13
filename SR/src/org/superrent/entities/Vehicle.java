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

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer regNo;
    
    private String category;
    
    private String type;
    
    private String brand;
    
    private Date purchaseDate;
   
    private boolean status;
   
    private Collection<SuperRent> superRentCollection;
    
    private Collection<SuperRent> superRentCollection1;
   
    private ForSaleVehicles forSaleVehicles;
   
    private Collection<MakeReservation> makeReservationCollection;

    public Vehicle() {
    }

    public Vehicle(Integer regNo) {
        this.regNo = regNo;
    }

    public Vehicle(Integer regNo, String category, String type, String brand, Date purchaseDate, boolean status) {
        this.regNo = regNo;
        this.category = category;
        this.type = type;
        this.brand = brand;
        this.purchaseDate = purchaseDate;
        this.status = status;
    }

    public Integer getRegNo() {
        return regNo;
    }

    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<SuperRent> getSuperRentCollection() {
        return superRentCollection;
    }

    public void setSuperRentCollection(Collection<SuperRent> superRentCollection) {
        this.superRentCollection = superRentCollection;
    }

    public Collection<SuperRent> getSuperRentCollection1() {
        return superRentCollection1;
    }

    public void setSuperRentCollection1(Collection<SuperRent> superRentCollection1) {
        this.superRentCollection1 = superRentCollection1;
    }

    public ForSaleVehicles getForSaleVehicles() {
        return forSaleVehicles;
    }

    public void setForSaleVehicles(ForSaleVehicles forSaleVehicles) {
        this.forSaleVehicles = forSaleVehicles;
    }

    public Collection<MakeReservation> getMakeReservationCollection() {
        return makeReservationCollection;
    }

    public void setMakeReservationCollection(Collection<MakeReservation> makeReservationCollection) {
        this.makeReservationCollection = makeReservationCollection;
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
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.regNo == null && other.regNo != null) || (this.regNo != null && !this.regNo.equals(other.regNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.Vehicle[ regNo=" + regNo + " ]";
    }
    
}
