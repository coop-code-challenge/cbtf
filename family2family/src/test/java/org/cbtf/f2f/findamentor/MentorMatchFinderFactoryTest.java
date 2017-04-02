package org.cbtf.f2f.findamentor;

import org.cbtf.f2f.domain.repository.ChildRepository;
import org.cbtf.f2f.domain.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MentorMatchFinderFactoryTest {

    private MentorMatchFinderFactory mentorMatchFinderFactory;
    private MentorMatchFinder validMentorMatchFinder;

    @Before
    public void setup() {
        ChildRepository mockChildRepository = mock(ChildRepository.class);
        ContactRepository mockContactRepository = mock(ContactRepository.class);
        validMentorMatchFinder = new MentorMatchFinder("validUser", mockContactRepository, mockChildRepository);
        mentorMatchFinderFactory = new MentorMatchFinderFactory(mockChildRepository, mockContactRepository);
    }

    @Test (expected = IllegalArgumentException.class)
    public void nullUserId_ThrowsException() {
        mentorMatchFinderFactory.getMentorMatchFinderForUserId(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void blankUserId_ThrowsException() {
        mentorMatchFinderFactory.getMentorMatchFinderForUserId("");
    }

    @Test
    public void normalUserId_ReturnsFinder() {
        MentorMatchFinder mentorMatchFinderForUserId = mentorMatchFinderFactory.getMentorMatchFinderForUserId("validUser");
        assertEquals(validMentorMatchFinder, mentorMatchFinderForUserId);
    }
}