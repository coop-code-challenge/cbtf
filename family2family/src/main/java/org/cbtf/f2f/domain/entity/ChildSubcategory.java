package org.cbtf.f2f.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A note related to a child for a category.
 *
 * @author Matt Lievens
 */
@Entity
@IdClass(ChildSubcategory.PK.class)
public class ChildSubcategory {

    /**
     * The field name for {@link #child}.
     */
    static final String FIELD_CHILD = "child";

    @ManyToOne
    @Id
    @JoinColumn(name = Subcategory.COLUMN_SUBCATEGORY)
    private Subcategory subcategory;

    @ManyToOne
    @Id
    @JoinColumn(name = Child.COLUMN_CHILD_ID)
    private Child child;

    public ChildSubcategory() {

    }

    public ChildSubcategory(Subcategory subcategory, Child child) {
        this.subcategory = subcategory;
        this.child = child;
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


    public static class PK implements Serializable {

        private Subcategory subcategory;

        private Child child;

        public PK() {
        }

        public PK(Subcategory subcategory, Child child) {
            this.subcategory = subcategory;
            this.child = child;
        }

        public Subcategory getSubcategory() {
            return subcategory;
        }

        public Child getChild() {
            return child;
        }
    }
}
