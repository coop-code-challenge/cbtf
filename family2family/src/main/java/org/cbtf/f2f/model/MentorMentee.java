package org.cbtf.f2f.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Matt Lievens
 */
@Entity
@IdClass(MentorMentee.PK.class)
public class MentorMentee {

    /**
     * The column name for {@link #mentee}.
     */
    static final String COLUMN_MENTEE_ID = "mentee";

    /**
     * The column name for {@link #mentor}.
     */
    static final String COLUMN_MENTOR_ID = "mentor";

    @ManyToOne
    @Id
    @JoinColumn(name = COLUMN_MENTOR_ID, referencedColumnName = Contact.COLUMN_CONTACT_ID)
    private Contact mentor;

    @ManyToOne
    @Id
    @JoinColumn(name = COLUMN_MENTEE_ID, referencedColumnName = Contact.COLUMN_CONTACT_ID)
    private Contact mentee;

    private Long timeMatched;

    public MentorMentee() {

    }

    public MentorMentee(Contact mentor, Contact mentee, Long timeMatched) {
        this.mentor = mentor;
        this.mentee = mentee;
        this.timeMatched = timeMatched;
    }

    public Contact getMentor() {
        return mentor;
    }

    public void setMentor(Contact mentor) {
        this.mentor = mentor;
    }

    public Contact getMentee() {
        return mentee;
    }

    public void setMentee(Contact mentee) {
        this.mentee = mentee;
    }

    public Long getTimeMatched() {
        return timeMatched;
    }

    public void setTimeMatched(Long timeMatched) {
        this.timeMatched = timeMatched;
    }

    public static class PK implements Serializable {

        private Contact mentor;

        private Contact mentee;

        public PK() {
        }

        public PK(Contact mentor, Contact mentee) {
            this.mentor = mentor;
            this.mentee = mentee;
        }
    }
}
