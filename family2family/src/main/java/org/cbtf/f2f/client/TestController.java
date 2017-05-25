package org.cbtf.f2f.client;

import org.cbtf.f2f.util.LoggedInUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String getAdminPage() {
        if (LoggedInUtil.isUserLoggedIn()) {
            return "test";
        } else {
            //this page should be protected by the security filter, but just in case it gets opened up..
            throw new RuntimeException("Unauthorized access to the admin page.");
        }
    }
}
