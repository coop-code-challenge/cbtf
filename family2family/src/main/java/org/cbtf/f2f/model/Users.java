package org.cbtf.f2f.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Matt Lievens.
 */
@Entity
public class Users {
    @Id
    private String id;

    private Boolean admin;

    private Boolean active;

    public String getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = userId;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
