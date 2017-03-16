package org.cbtf.f2f.model;

import javax.persistence.*;

/**
 * An open ended category associated with a child (i.e. Physical Challenges, Educational Issues, Treatments, etc...).
 *
 * @author Matt Lievens
 */
@Entity
public class MentorMentee {

    /**
     * The column name for {@link #mentee}.
     */
    static final String COLUMN_MENTEE_ID = "mentee";

    /**
     * The column name for {@link #mentor}.
     */
    static final String COLUMN_MENTOR_ID = "mentor";

    @Id
    @GeneratedValue
    private Integer mentorMenteeId;

    @ManyToOne
    @JoinColumn(name = COLUMN_MENTOR_ID, referencedColumnName = Contact.COLUMN_CONTACT_ID)
    private Contact mentor;

    @ManyToOne
    @JoinColumn(name = COLUMN_MENTEE_ID, referencedColumnName = Contact.COLUMN_CONTACT_ID)
    private Contact mentee;

    private Long timeMatched;

    public Integer getMentorMenteeId() {
        return mentorMenteeId;
    }

    public void setMentorMenteeId(Integer mentorMenteeId) {
        this.mentorMenteeId = mentorMenteeId;
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
}
