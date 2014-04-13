package org.superrent.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author welcome
 */
public class Payments implements Serializable {
    private static final long serialVersionUID = 1L;
  
    private Integer receiptID;
    
    private int uid;
   
    private String description;
    
    private Date paymentDate;
    
    private double amount;
    
    private int type;
    
    private Collection<PointsFromPayments> pointsFromPaymentsCollection;

    public Payments() {
    }

    public Payments(Integer receiptID) {
        this.receiptID = receiptID;
    }

    public Payments(Integer receiptID, int uid, String description, Date paymentDate, double amount, int type) {
        this.receiptID = receiptID;
        this.uid = uid;
        this.description = description;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.type = type;
    }

    public Integer getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(Integer receiptID) {
        this.receiptID = receiptID;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Collection<PointsFromPayments> getPointsFromPaymentsCollection() {
        return pointsFromPaymentsCollection;
    }

    public void setPointsFromPaymentsCollection(Collection<PointsFromPayments> pointsFromPaymentsCollection) {
        this.pointsFromPaymentsCollection = pointsFromPaymentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptID != null ? receiptID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.receiptID == null && other.receiptID != null) || (this.receiptID != null && !this.receiptID.equals(other.receiptID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.Payments[ receiptID=" + receiptID + " ]";
    }
    
}
