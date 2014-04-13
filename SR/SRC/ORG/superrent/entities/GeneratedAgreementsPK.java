
package org.superrent.entities;

import java.io.Serializable;

/**
 *
 * @author welcome
 */

public class GeneratedAgreementsPK implements Serializable {
    
    private int confirmationNo;
   
    private int agreementNo;

    public GeneratedAgreementsPK() {
    }

    public GeneratedAgreementsPK(int confirmationNo, int agreementNo) {
        this.confirmationNo = confirmationNo;
        this.agreementNo = agreementNo;
    }

    public int getConfirmationNo() {
        return confirmationNo;
    }

    public void setConfirmationNo(int confirmationNo) {
        this.confirmationNo = confirmationNo;
    }

    public int getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(int agreementNo) {
        this.agreementNo = agreementNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) confirmationNo;
        hash += (int) agreementNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneratedAgreementsPK)) {
            return false;
        }
        GeneratedAgreementsPK other = (GeneratedAgreementsPK) object;
        if (this.confirmationNo != other.confirmationNo) {
            return false;
        }
        if (this.agreementNo != other.agreementNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.GeneratedAgreementsPK[ confirmationNo=" + confirmationNo + ", agreementNo=" + agreementNo + " ]";
    }
    
}
