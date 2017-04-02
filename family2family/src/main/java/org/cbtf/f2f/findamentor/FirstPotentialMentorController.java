package org.cbtf.f2f.findamentor;

import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.findamentor.model.PotentialMentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@link FirstPotentialMentorController} is responsible for providing a rest endpoint that will
 * return a PotentialMentor given
 */
@RestController
@RequestMapping("${org.cbtf.apiRoot}/users/{userId}/first-potential-mentor")
public class FirstPotentialMentorController {

    private final MentorMatchFinderFactory mentorMatchFinderFactory;

    @Autowired
    public FirstPotentialMentorController(MentorMatchFinderFactory mentorMatchFinderFactory) {
        this.mentorMatchFinderFactory = mentorMatchFinderFactory;
    }

    @GetMapping
    public ResponseEntity<?> findMatch(@PathVariable("userId") String userId) {
        return mentorMatchFinderFactory.getMentorMatchFinderForUserId(userId)
                .findFirstMatchByDiagnosis()
                .map(contact -> new ResponseEntity<>(convertContactToPotentialMentor(contact), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private PotentialMentor convertContactToPotentialMentor(Contact contact) {
        return PotentialMentor.newBuilder()
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .build();
    }
}
