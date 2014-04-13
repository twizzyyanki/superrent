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

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer uid;
   
    private String name;
    
    private String email;
    
    private long phoneNumber;
   
    private Date dateCreated;
    
    private int type;
    
    private String address;
   
    private ClubMember clubMember;
   
    private Collection<MakeReservation> makeReservationCollection;
    
    private RegUser regUser;

    public User() {
    }

    public User(Integer uid) {
        this.uid = uid;
    }

    public User(Integer uid, String name, String email, long phoneNumber, Date dateCreated, int type, String address) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateCreated;
        this.type = type;
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClubMember getClubMember() {
        return clubMember;
    }

    public void setClubMember(ClubMember clubMember) {
        this.clubMember = clubMember;
    }

    public Collection<MakeReservation> getMakeReservationCollection() {
        return makeReservationCollection;
    }

    public void setMakeReservationCollection(Collection<MakeReservation> makeReservationCollection) {
        this.makeReservationCollection = makeReservationCollection;
    }

    public RegUser getRegUser() {
        return regUser;
    }

    public void setRegUser(RegUser regUser) {
        this.regUser = regUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superrent.User[ uid=" + uid + " ]";
    }
    
}
