package org.cbtf.f2f.findamentor;

import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.domain.entity.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${org.cbtf.apiRoot}/findmatch")
/**
 * Created by mike on 3/25/2017
 */
public class FindMentor {

    @GetMapping("/{userId}")
    public Users findMatch(String userId) {
        Contact tempContact = new Contact();
        Users temp = new Users("id1234","john", "schreiber", false, true, tempContact );

        return temp;
    }



}
