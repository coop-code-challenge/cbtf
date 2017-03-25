package org.cbtf.f2f.domain.converter;

import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.domain.entity.MentorMentee;
import org.cbtf.f2f.domain.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.regex.Pattern;

@Component
public class MentorMenteePKConverter implements BackendIdConverter {
    private static final Pattern DELIMITER = Pattern.compile("\\|");

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        String[] keyParts = DELIMITER.split(id);
        Integer mentorId = Integer.valueOf(keyParts[0]);
        Integer menteeId = Integer.valueOf(keyParts[1]);
        Contact mentor = contactRepository.findOne(mentorId);
        Contact mentee = contactRepository.findOne(menteeId);

        return new MentorMentee.PK(mentor, mentee);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        MentorMentee.PK mentorMenteePK = (MentorMentee.PK) id;
        return mentorMenteePK.getMentor().getContactId() + "|" + mentorMenteePK.getMentee().getContactId();
    }

    @Override
    public boolean supports(Class<?> delimiter){
        return MentorMentee.class.equals(delimiter);
    }
}
