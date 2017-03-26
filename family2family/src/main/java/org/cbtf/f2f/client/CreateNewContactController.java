package org.cbtf.f2f.client;

import org.cbtf.f2f.util.LoggedInUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The server side controller for serving up webpages for the MatchMaker component.
 */
@Controller
public class CreateNewContactController {

    @RequestMapping("/create-new-contact")
    public String getMatchMakerPage() {
        if (LoggedInUtil.isUserLoggedIn()) {
            return "create-new-contact";
        } else {
            //this page should be protected by the security filter, but just in case it gets opened up..
            throw new RuntimeException("Unauthorized access to the contact entry page.");
        }
    }

}
