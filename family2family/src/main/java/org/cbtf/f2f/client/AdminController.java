package org.cbtf.f2f.client;

import org.cbtf.f2f.util.LoggedInUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The server side controller for serving up webpages for the Admin component.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String getAdminPage() {
        if (LoggedInUtil.isUserLoggedIn()) {
            return "admin";
        } else {
            //this page should be protected by the security filter, but just in case it gets opened up..
            throw new RuntimeException("Unauthorized access to the admin page.");
        }
    }

}
