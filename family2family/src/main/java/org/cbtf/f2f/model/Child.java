package org.cbtf.f2f.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Matt Lievens
 */

@Entity
public class Child {

    /**
     * The column name for {@link #childId}.
     */
    static final String COLUMN_CHILD_ID = "child_id";

    /**
     * The field name for {@link #contact}.
     */
    static final String FIELD_CONTACT = "contact";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_CHILD_ID)
    private Integer childId;

    private String first;

    private String last;

    private Long dateOfBirth;

    private Long dateOfDeath;

    private Boolean bereaved;

    @ManyToOne
    @JoinColumn(name = Contact.COLUMN_CONTACT_ID)
    private Contact contact;

    @OneToMany(mappedBy = CategoryNote.FIELD_CHILD)
    private Set<CategoryNote> categoryNotes;

    @OneToMany(mappedBy = ChildDiagnosis.COLUMN_CHILD_ID)
    private Set<ChildDiagnosis> diagnoses;

    @OneToMany(mappedBy = ChildSubcategory.FIELD_CHILD)
    private Set<ChildSubcategory> subCategories;

    public Child() {

    }

    public Child(String first, String last, Long dateOfBirth, Long dateOfDeath, Boolean bereaved, Contact contact,
                 Set<CategoryNote> categoryNotes, Set<ChildDiagnosis> diagnoses, Set<ChildSubcategory> subCategories) {
        this.first = first;
        this.last = last;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.bereaved = bereaved;
        this.contact = contact;
        this.categoryNotes = categoryNotes;
        this.diagnoses = diagnoses;
        this.subCategories = subCategories;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Long dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Boolean getBereaved() {
        return bereaved;
    }

    public void setBereaved(Boolean bereaved) {
        this.bereaved = bereaved;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Set<CategoryNote> getCategoryNotes() {
        return categoryNotes;
    }

    public Set<ChildDiagnosis> getDiagnoses() {
        return diagnoses;
    }

    public Set<ChildSubcategory> getSubCategories() {
        return subCategories;
    }
}
