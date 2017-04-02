package org.cbtf.f2f.findamentor.model;

import com.google.common.base.Preconditions;

/**
 * A {@link PotentialMentor} represents a possible mentor for a given mentee.
 */
public class PotentialMentor {

    private String firstName;
    private String lastName;

    private PotentialMentor(Builder builder) {
        this.firstName = Preconditions.checkNotNull(builder.firstName);
        this.lastName = Preconditions.checkNotNull(builder.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder fromPrototype(PotentialMentor prototype) {
            firstName = prototype.firstName;
            lastName = prototype.lastName;
            return this;
        }

        public PotentialMentor build() {
            return new PotentialMentor(this);
        }
    }
}
