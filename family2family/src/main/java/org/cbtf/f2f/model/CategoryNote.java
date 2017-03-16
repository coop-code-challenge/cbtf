package org.cbtf.f2f.model;

import javax.persistence.*;
import java.util.List;

/**
 * A note related to a child for a category.
 *
 * @author Matt Lievens
 */
@Entity
public class CategoryNote {

    /**
     * The field name for {@link #category}.
     */
    static final String FIELD_CATEGORY = "category";

    /**
     * The field name for {@link #child}.
     */
    static final String FIELD_CHILD = "child";

    @Id
    @GeneratedValue
    private Integer categoryNoteId;

    @ManyToOne
    @JoinColumn(name = Category.COLUMN_CATEGORY_ID)
    private Category category;

    @ManyToOne
    @JoinColumn(name = Child.COLUMN_CHILD_ID)
    private Child child;

    private String note;

    public Integer getCategoryNoteId() {
        return categoryNoteId;
    }

    public void setCategoryNoteId(Integer categoryNoteId) {
        this.categoryNoteId = categoryNoteId;
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
}
