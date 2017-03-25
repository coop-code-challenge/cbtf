package org.cbtf.f2f.domain.entity;

import javax.persistence.*;

/**
 * The details for a {@link Category}.
 *
 * @author Phil Endsley
 */
@Entity
public class Subcategory {

    /**
     * The column name for {@link #subcategoryId}.
     */
    static final String COLUMN_SUBCATEGORY = "subcategory_id";

    /**
     * The field name for {@link #category}.
     */
    static final String FIELD_CATEGORY = "category";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_SUBCATEGORY)
    private Integer subcategoryId;

    private String description;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = Category.COLUMN_CATEGORY_ID)
    private Category category;

    public Subcategory() {

    }

    public Subcategory(String description, Boolean active, Category category) {
        this.description = description;
        this.active = active;
        this.category = category;
    }

    /**
     * @return The unique identifier for a category detail.
     */
    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    /**
     * @return The category detail's description.
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return {@code true} if this category detail can be used.
     */
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return The {@link Category} this detail falls under.
     */
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

