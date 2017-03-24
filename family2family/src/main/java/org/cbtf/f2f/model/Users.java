package org.cbtf.f2f.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Matt Lievens.
 */
@Entity
public class Users {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Boolean admin;

    private Boolean active;

    @OneToOne
    @JoinColumn(name = Contact.COLUMN_PRIMARY_EMAIL)
    private Contact contact;

    public Users() {

    }

    public Users(String id, String firstName, String lastName, Boolean admin, Boolean active, Contact contact) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.active = active;
        this.contact = contact;
    }

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

    public Contact getContact() {
        return contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
