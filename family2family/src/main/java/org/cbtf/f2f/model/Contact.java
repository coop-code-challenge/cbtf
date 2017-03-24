package org.cbtf.f2f.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Matt Lievens.
 */
@Entity
public class Contact {

    /**
     * The column name for {@link #contactId}.
     */
    static final String COLUMN_CONTACT_ID = "contact_Id";

    /**
     * The column name for {@link #primaryEmail}.
     */
    static final String COLUMN_PRIMARY_EMAIL = "primary_Email";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_CONTACT_ID)
    private Integer contactId;

    private String firstName;

    private String lastName;

    private Boolean mentor;

    private Boolean mentee;

    private Boolean doNotContact;

    private String primaryPhoneNumber;

    private Boolean primaryPhoneNumberVisibleToMatch;

    private String secondaryPhoneNumber;

    private Boolean secondaryPhoneNumberVisibleToMatch;

    private String city;

    private String state;

    @Column(name = COLUMN_PRIMARY_EMAIL)
    private String primaryEmail;

    private Boolean primaryEmailVisibleToMatch;

    private String secondaryEmail;

    private Boolean secondaryEmailVisibleToMatch;

    private String contactNote;

    private String adminNote;

    @OneToMany(mappedBy = Child.FIELD_CONTACT)
    private List<Child> children;

    @OneToMany(mappedBy = MentorMentee.COLUMN_MENTEE_ID)
    private List<MentorMentee> mentees;

    @OneToMany(mappedBy = MentorMentee.COLUMN_MENTOR_ID)
    private List<MentorMentee> mentors;

    public Contact() {

    }

    public Contact(String firstName, String lastName, Boolean mentor, Boolean mentee, Boolean doNotContact,
                   String primaryPhoneNumber, Boolean primaryPhoneNumberVisibleToMatch, String secondaryPhoneNumber,
                   Boolean secondaryPhoneNumberVisibleToMatch, String city, String state, String primaryEmail,
                   Boolean primaryEmailVisibleToMatch, String secondaryEmail, Boolean secondaryEmailVisibleToMatch,
                   String contactNote, String adminNote, List<Child> children, List<MentorMentee> mentees,
                   List<MentorMentee> mentors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mentor = mentor;
        this.mentee = mentee;
        this.doNotContact = doNotContact;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.primaryPhoneNumberVisibleToMatch = primaryPhoneNumberVisibleToMatch;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.secondaryPhoneNumberVisibleToMatch = secondaryPhoneNumberVisibleToMatch;
        this.city = city;
        this.state = state;
        this.primaryEmail = primaryEmail;
        this.primaryEmailVisibleToMatch = primaryEmailVisibleToMatch;
        this.secondaryEmail = secondaryEmail;
        this.secondaryEmailVisibleToMatch = secondaryEmailVisibleToMatch;
        this.contactNote = contactNote;
        this.adminNote = adminNote;
        this.children = children;
        this.mentees = mentees;
        this.mentors = mentors;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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

    public Boolean getMentor() {
        return mentor;
    }

    public void setMentor(Boolean mentor) {
        this.mentor = mentor;
    }

    public Boolean getMentee() {
        return mentee;
    }

    public void setMentee(Boolean mentee) {
        this.mentee = mentee;
    }

    public Boolean getDoNotContact() {
        return doNotContact;
    }

    public void setDoNotContact(Boolean doNotContact) {
        this.doNotContact = doNotContact;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public Boolean getPrimaryPhoneNumberVisibleToMatch() {
        return primaryPhoneNumberVisibleToMatch;
    }

    public void setPrimaryPhoneNumberVisibleToMatch(Boolean primaryPhoneNumberVisibleToMatch) {
        this.primaryPhoneNumberVisibleToMatch = primaryPhoneNumberVisibleToMatch;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }

    public Boolean getSecondaryPhoneNumberVisibleToMatch() {
        return secondaryPhoneNumberVisibleToMatch;
    }

    public void setSecondaryPhoneNumberVisibleToMatch(Boolean secondaryPhoneNumberVisibleToMatch) {
        this.secondaryPhoneNumberVisibleToMatch = secondaryPhoneNumberVisibleToMatch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public Boolean getPrimaryEmailVisibleToMatch() {
        return primaryEmailVisibleToMatch;
    }

    public void setPrimaryEmailVisibleToMatch(Boolean primaryEmailVisibleToMatch) {
        this.primaryEmailVisibleToMatch = primaryEmailVisibleToMatch;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public Boolean getSecondaryEmailVisibleToMatch() {
        return secondaryEmailVisibleToMatch;
    }

    public void setSecondaryEmailVisibleToMatch(Boolean secondaryEmailVisibleToMatch) {
        this.secondaryEmailVisibleToMatch = secondaryEmailVisibleToMatch;
    }

    public String getContactNote() {
        return contactNote;
    }

    public void setContactNote(String contactNote) {
        this.contactNote = contactNote;
    }

    public String getAdminNote() {
        return adminNote;
    }

    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<MentorMentee> getMentees() {
        return mentees;
    }

    public List<MentorMentee> getMentors() {
        return mentors;
    }
}
