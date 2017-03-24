package org.cbtf.f2f.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Matt Lievens
 */
@Entity
@IdClass(ChildDiagnosis.PK.class)
public class ChildDiagnosis {

    /**
     * The column name for {@link #child}.
     */
    static final String COLUMN_CHILD_ID = "child";

    /**
     * The column name for {@link #diagnosis}.
     */
    static final String COLUMN_DIAGNOSIS_ID = "diagnosis";

    @ManyToOne
    @Id
    @JoinColumn(name = Diagnosis.COLUMN_DIAGNOSIS_ID)
    private Diagnosis diagnosis;

    @ManyToOne
    @Id
    @JoinColumn(name = Child.COLUMN_CHILD_ID)
    private Child child;

    private Integer ageOfDiagnosis;

    public ChildDiagnosis() {

    }

    public ChildDiagnosis(Diagnosis diagnosis, Child child, Integer ageOfDiagnosis) {
        this.diagnosis = diagnosis;
        this.child = child;
        this.ageOfDiagnosis = ageOfDiagnosis;
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

    public static class PK implements Serializable {

        private Diagnosis diagnosis;

        private Child child;

        public PK() {
        }

        public PK(Diagnosis diagnosis, Child child) {
            this.diagnosis = diagnosis;
            this.child = child;
        }
    }

}
