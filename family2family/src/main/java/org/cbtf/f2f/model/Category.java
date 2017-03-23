package org.cbtf.f2f.model;

import javax.persistence.*;
import java.util.List;

/**
 * An open ended category associated with a child (i.e. Physical Challenges, Educational Issues, Treatments, etc...).
 *
 * @author Phil Endsley
 */
@Entity
public class Category {

    /**
     * The column name for {@link #categoryId}.
     */
    static final String COLUMN_CATEGORY_ID = "categoryId";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_CATEGORY_ID)
    private Integer categoryId;

    private String description;

    private Boolean active;

    @OneToMany(mappedBy = Subcategory.FIELD_CATEGORY)
    private List<Subcategory> subCategories;

    @OneToMany(mappedBy = CategoryNote.FIELD_CATEGORY)
    private List<CategoryNote> categoryNotes;

    /**
     * @return The unique identifier for a category.
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return The category's description.
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return {@code true} if this category can be used.
     */
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return All {@link Subcategory} for this category.
     */
    public List<Subcategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Subcategory> subCategories) {
        this.subCategories = subCategories;
    }
}
