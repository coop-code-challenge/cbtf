package org.cbtf.f2f.model;

import javax.persistence.*;

/**
 * An open ended category associated with a child (i.e. Physical Challenges, Educational Issues, Treatments, etc...).
 *
 * @author Matt Lievens
 */
@Entity
public class ChildDiagnosis {

    /**
     * The column name for {@link #child}.
     */
    static final String COLUMN_CHILD_ID = "child";

    /**
     * The column name for {@link #diagnosis}.
     */
    static final String COLUMN_DIAGNOSIS_ID = "diagnosis";

    @Id
    @GeneratedValue
    private Integer childDiagnosisId;

    @ManyToOne
    @JoinColumn(name = Diagnosis.COLUMN_DIAGNOSIS_ID)
    private Diagnosis diagnosis;

    @ManyToOne
    @JoinColumn(name = Child.COLUMN_CHILD_ID)
    private Child child;

    private Integer ageOfDiagnosis;

    public Integer getChildDiagnosisId() {
        return childDiagnosisId;
    }

    public void setChildDiagnosisId(Integer childDiagnosisId) {
        this.childDiagnosisId = childDiagnosisId;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Integer getAgeOfDiagnosis() {
        return ageOfDiagnosis;
    }

    public void setAgeOfDiagnosis(Integer ageOfDiagnosis) {
        this.ageOfDiagnosis = ageOfDiagnosis;
    }
}
