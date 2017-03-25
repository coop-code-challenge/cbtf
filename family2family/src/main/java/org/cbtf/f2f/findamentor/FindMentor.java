package org.cbtf.f2f.findamentor;

import org.cbtf.f2f.domain.entity.Child;
import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.domain.entity.Users;
import org.cbtf.f2f.domain.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("${org.cbtf.apiRoot}/findmatch")
/**
 * Created by mike on 3/25/2017
 */
public class FindMentor {

    @Autowired
    private UsersRepository userRepo;

    @GetMapping("/{userId}")
    public Users findMatch(@PathVariable("userId") String userId) {
        Users user = userRepo.findOne(userId);
//        Contact userContact = user.getContact();
//
//        List<Child> children = userContact.getChildren();
//
//        for(int i= 0; i < children.size(); i++) {
//
//
//
//        }






        return user;
    }

}
