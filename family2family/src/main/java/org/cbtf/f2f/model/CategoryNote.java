package org.cbtf.f2f.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * A note related to a child for a category.
 *
 * @author Matt Lievens
 */
@Entity
@IdClass(CategoryNote.PK.class)
public class CategoryNote {

    /**
     * The field name for {@link #category}.
     */
    static final String FIELD_CATEGORY = "category";

    /**
     * The field name for {@link #child}.
     */
    static final String FIELD_CHILD = "child";

    @ManyToOne
    @Id
    @JoinColumn(name = Category.COLUMN_CATEGORY_ID)
    private Category category;

    @ManyToOne
    @Id
    @JoinColumn(name = Child.COLUMN_CHILD_ID)
    private Child child;

    private String note;

    public CategoryNote() {

    }

    public CategoryNote(Category category, Child child, String note) {
        this.category = category;
        this.child = child;
        this.note = note;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public static class PK implements Serializable {

        private Category category;

        private Child child;

        public PK() {
        }

        public PK(Category category, Child child) {
            this.category = category;
            this.child = child;
        }
    }

}
