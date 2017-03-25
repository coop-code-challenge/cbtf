package org.cbtf.f2f.findamentor;

import com.google.common.collect.Sets;
import org.cbtf.f2f.domain.entity.Child;
import org.cbtf.f2f.domain.entity.ChildDiagnosis;
import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.domain.entity.Users;
import org.cbtf.f2f.domain.repository.ChildRepository;
import org.cbtf.f2f.domain.repository.ContactRepository;
import org.cbtf.f2f.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;

import java.util.Set;

@RestController
@RequestMapping("${org.cbtf.apiRoot}/findmatch")
/**
 * Created by mike on 3/25/2017
 */
public class FindMentor {

    @Autowired
    private UsersRepository userRepo;

    @Autowired
    private ContactRepository contactRepo;

    @Autowired
    private ChildRepository  childRepo;


    @GetMapping("/{userId}")
    public Users findMatch(@PathVariable("userId") String userId) {
        Contact userContact = contactRepo.findFirstByPrimaryEmailIsLike(userId);
        List<Child> children = userContact.getChildren();
        Set<ChildDiagnosis> allDiags = new HashSet<>();

        for (Child aChildren : children) {
            Set<ChildDiagnosis> diags = aChildren.getDiagnoses();
            allDiags.addAll(diags);
        }

        Iterable<Child> allChildren = childRepo.findAll();

        Child temp = null;

        for(Child child : allChildren) {
           Set<ChildDiagnosis> intersectionSet = Sets.intersection(allDiags, child.getDiagnoses());
           if(intersectionSet.size() > 0) {

               temp = child;

               break;
           }
        }

        if(temp == null) {

            return null;
        }
        else {
            Contact match = match = temp.getContact();
            Users userOfMatch = userRepo.findOne(match.getPrimaryEmail());
            return userOfMatch;
        }
    }
}