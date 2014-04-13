package org.superrent.entities;

import java.io.Serializable;

public class GeneratedAgreements implements Serializable {
    private static final long serialVersionUID = 1L;
  
    protected GeneratedAgreementsPK generatedAgreementsPK;

    public GeneratedAgreements() {
    }

    public GeneratedAgreements(GeneratedAgreementsPK generatedAgreementsPK) {
        this.generatedAgreementsPK = generatedAgreementsPK;
    }

    public GeneratedAgreements(int confirmationNo, int agreementNo) {
        this.generatedAgreementsPK = new GeneratedAgreementsPK(confirmationNo, agreementNo);
    }

    public GeneratedAgreementsPK getGeneratedAgreementsPK() {
        return generatedAgreementsPK;
    }

    public void setGeneratedAgreementsPK(GeneratedAgreementsPK generatedAgreementsPK) {
        this.generatedAgreementsPK = generatedAgreementsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generatedAgreementsPK != null ? generatedAgreementsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneratedAgreements)) {
            return false;
        }
        GeneratedAgreements other = (GeneratedAgreements) object;
        if ((this.generatedAgreementsPK == null && other.generatedAgreementsPK != null) || (this.generatedAgreementsPK != null && !this.generatedAgreementsPK.equals(other.generatedAgreementsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.GeneratedAgreements[ generatedAgreementsPK=" + generatedAgreementsPK + " ]";
    }
    
}
