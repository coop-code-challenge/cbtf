package org.cbtf.f2f.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Justin West
 *
 * This entity contains a diagnosis.
 */
@Entity
public class Diagnosis {

    /**
     * The column name for {@link #id}.
     */
    static final String COLUMN_DIAGNOSIS_ID = "diagnosis_Id";

    @Id
    @GeneratedValue
    @Column(name = COLUMN_DIAGNOSIS_ID)
    private Integer id;

    private String description;

    public Diagnosis(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = ChildDiagnosis.COLUMN_DIAGNOSIS_ID)
    private List<ChildDiagnosis> diagnoses;

    public Diagnosis() {

    }

    public Diagnosis(String description, List<ChildDiagnosis> diagnoses) {
        this.description = description;
        this.diagnoses = diagnoses;
    }

    /**
     * Generated Id.
     * @return Integer id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method may not be necessary since it is a generated ID.
     * @param id Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the name of the diagnosis.
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the name of the diagnosis.
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public List<ChildDiagnosis> getDiagnoses() {
        return diagnoses;
    }
}
