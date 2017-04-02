package org.cbtf.f2f.findamentor;

import org.cbtf.f2f.domain.entity.Child;
import org.cbtf.f2f.domain.entity.ChildDiagnosis;
import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.domain.entity.Diagnosis;
import org.cbtf.f2f.domain.repository.ChildRepository;
import org.cbtf.f2f.domain.repository.ContactRepository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The {@link MentorMatchFinder} is responsible for potential mentors for a mentee
 */
class MentorMatchFinder {

    private final ContactRepository contactRepository;
    private final ChildRepository childRepository;

    private Optional<Contact> menteeContact;
    private List<Child> menteeChildren;
    private Set<Integer> menteeChildrenIds;
    private Set<Integer> menteeChildrenDiagnosisIds;
    private Set<Child> nonMenteeChildren;
    private Optional<Child> childWithMatchingDiagnosis;

    MentorMatchFinder(String userId,
                             ContactRepository contactRepository,
                             ChildRepository childRepository) {
        this.contactRepository = contactRepository;
        this.childRepository = childRepository;
        menteeContact = Optional.ofNullable(contactRepository.findFirstByPrimaryEmailIsLike(userId));
    }

    synchronized Optional<Contact> findFirstMatchByDiagnosis() {
        menteeChildren = getAllMenteeChildren();
        menteeChildrenIds = getAllMenteeChildrenIds();
        menteeChildrenDiagnosisIds = getAllMenteeChildrenDiagnoses();
        nonMenteeChildren = getAllNonMenteeChildren();
        childWithMatchingDiagnosis = getChildWithMatchingDiagnosis();
        return getContactForMatchingChild();
    }

    private List<Child> getAllMenteeChildren() {
        return menteeExistsAndHasChildren() ? menteeContact.get().getChildren() : Collections.emptyList();
    }

    private boolean menteeExistsAndHasChildren() {
        return menteeContact.isPresent() && menteeContact.get().getChildren() != null;
    }

    private Set<Integer> getAllMenteeChildrenIds() {
        return menteeChildren.stream().map(Child::getChildId).collect(Collectors.toSet());
    }

    private Set<Integer> getAllMenteeChildrenDiagnoses() {
        return menteeChildren.stream()
                .map(Child::getDiagnoses)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .map(ChildDiagnosis::getDiagnosis)
                .map(Diagnosis::getId)
                .collect(Collectors.toSet());
    }

    private Set<Child> getAllNonMenteeChildren() {
        return StreamSupport.stream(childRepository.findAll().spliterator(), false)
                .filter(child -> !menteeChildrenIds.contains(child.getChildId()))
                .collect(Collectors.toSet());
    }

    private Optional<Child> getChildWithMatchingDiagnosis() {
        return nonMenteeChildren.stream()
                .filter(child -> {
                    Set<ChildDiagnosis> childDiagnoses = child.getDiagnoses();
                    for (ChildDiagnosis childDiagnosis : childDiagnoses) {
                        if (menteeChildrenDiagnosisIds.contains(childDiagnosis.getDiagnosis().getId())) {
                            return true;
                        }
                    }
                    return false;
                })
                .findFirst();
    }

    private Optional<Contact> getContactForMatchingChild() {
        Contact mentorMatch = null;
        if (childWithMatchingDiagnosis.isPresent()) {
            Contact contact = childWithMatchingDiagnosis.get().getContact();
            if (contact != null) {
                mentorMatch = contactRepository.findFirstByPrimaryEmailIsLike(contact.getPrimaryEmail());
            }
        }
        return Optional.ofNullable(mentorMatch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentorMatchFinder that = (MentorMatchFinder) o;
        return Objects.equals(contactRepository, that.contactRepository) &&
                Objects.equals(childRepository, that.childRepository) &&
                Objects.equals(menteeContact, that.menteeContact) &&
                Objects.equals(menteeChildren, that.menteeChildren) &&
                Objects.equals(menteeChildrenIds, that.menteeChildrenIds) &&
                Objects.equals(menteeChildrenDiagnosisIds, that.menteeChildrenDiagnosisIds) &&
                Objects.equals(nonMenteeChildren, that.nonMenteeChildren) &&
                Objects.equals(childWithMatchingDiagnosis, that.childWithMatchingDiagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactRepository, childRepository, menteeContact, menteeChildren, menteeChildrenIds, menteeChildrenDiagnosisIds, nonMenteeChildren, childWithMatchingDiagnosis);
    }
}