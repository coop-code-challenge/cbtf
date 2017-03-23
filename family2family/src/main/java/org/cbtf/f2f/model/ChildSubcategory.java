package org.cbtf.f2f.model;

import javax.persistence.*;

/**
 * A note related to a child for a category.
 *
 * @author Matt Lievens
 */
@Entity
public class ChildSubcategory {

    /**
     * The field name for {@link #subcategory}.
     */
    static final String FIELD_SUBCATEGORY = "subcategory";

    /**
     * The field name for {@link #child}.
     */
    static final String FIELD_CHILD = "child";

    @Id
    @GeneratedValue
    private Integer childCategoryId;

    @ManyToOne
    @JoinColumn(name = Subcategory.COLUMN_SUBCATEGORY)
    private Subcategory subcategory;

    @ManyToOne
    @JoinColumn(name = Child.COLUMN_CHILD_ID)
    private Child child;

    private String note;

    public Integer getCategoryNoteId() {
        return childCategoryId;
    }

    public void setChildCategoryId(Integer childCategoryId) {
        this.childCategoryId = childCategoryId;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
