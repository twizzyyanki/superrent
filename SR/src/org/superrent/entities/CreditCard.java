package org.superrent.entities;

import java.io.Serializable;

public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Long cardNo;
    
    private String expiryDate;
   
    private RentAgreement agreementNo;

    public CreditCard() {
    }

    public CreditCard(Long cardNo) {
        this.cardNo = cardNo;
    }

    public CreditCard(Long cardNo, String expiryDate) {
        this.cardNo = cardNo;
        this.expiryDate = expiryDate;
    }

    public Long getCardNo() {
        return cardNo;
    }

    public void setCardNo(Long cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public RentAgreement getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(RentAgreement agreementNo) {
        this.agreementNo = agreementNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardNo != null ? cardNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.cardNo == null && other.cardNo != null) || (this.cardNo != null && !this.cardNo.equals(other.cardNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.CreditCard[ cardNo=" + cardNo + " ]";
    }
    
}
