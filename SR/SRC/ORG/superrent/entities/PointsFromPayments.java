package org.superrent.entities;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author welcome
 */

public class PointsFromPayments implements Serializable {
    private static final long serialVersionUID = 1L;
   
    protected PointsFromPaymentsPK pointsFromPaymentsPK;
    
    private double points;
    
    private Date date;
   
    private Payments payments;

    public PointsFromPayments() {
    }

    public PointsFromPayments(PointsFromPaymentsPK pointsFromPaymentsPK) {
        this.pointsFromPaymentsPK = pointsFromPaymentsPK;
    }

    public PointsFromPayments(PointsFromPaymentsPK pointsFromPaymentsPK, double points, Date date) {
        this.pointsFromPaymentsPK = pointsFromPaymentsPK;
        this.points = points;
        this.date = date;
    }

    public PointsFromPayments(int uid, int pid) {
        this.pointsFromPaymentsPK = new PointsFromPaymentsPK(uid, pid);
    }

    public PointsFromPaymentsPK getPointsFromPaymentsPK() {
        return pointsFromPaymentsPK;
    }

    public void setPointsFromPaymentsPK(PointsFromPaymentsPK pointsFromPaymentsPK) {
        this.pointsFromPaymentsPK = pointsFromPaymentsPK;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pointsFromPaymentsPK != null ? pointsFromPaymentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointsFromPayments)) {
            return false;
        }
        PointsFromPayments other = (PointsFromPayments) object;
        if ((this.pointsFromPaymentsPK == null && other.pointsFromPaymentsPK != null) || (this.pointsFromPaymentsPK != null && !this.pointsFromPaymentsPK.equals(other.pointsFromPaymentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.PointsFromPayments[ pointsFromPaymentsPK=" + pointsFromPaymentsPK + " ]";
    }
    
}
