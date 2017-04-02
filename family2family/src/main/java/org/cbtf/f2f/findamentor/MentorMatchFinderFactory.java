package org.cbtf.f2f.findamentor;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.cbtf.f2f.domain.repository.ChildRepository;
import org.cbtf.f2f.domain.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The {@link MentorMatchFinderFactory} is responsible for providing a {@link MentorMatchFinder} for a specific userId
 */
@Component
public class MentorMatchFinderFactory {

    private final ChildRepository childRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public MentorMatchFinderFactory(ChildRepository childRepository,
                             ContactRepository contactRepository) {
        this.childRepository = childRepository;
        this.contactRepository = contactRepository;
    }

    MentorMatchFinder getMentorMatchFinderForUserId(String userId) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(userId), "UserId required");
        return new MentorMatchFinder(userId, contactRepository, childRepository);
    }
}
