package org.superrent.entities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author welcome
 */

public class RegUser implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private String username;   
    private String password;   
    private Date datecreated;    
    private User uid;

    public RegUser() {
    }

    public RegUser(String username) {
        this.username = username;
    }

    public RegUser(String username, String password, Date datecreated) {
        this.username = username;
        this.password = password;
        this.datecreated = datecreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegUser)) {
            return false;
        }
        RegUser other = (RegUser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.superrent.entities.RegUser[ username=" + username + " ]";
    }
    
}
