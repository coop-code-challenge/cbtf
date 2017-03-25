package org.cbtf.f2f.client;

import org.cbtf.f2f.util.LoggedInUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@link ClientController} relies on the ThymeLeaf "View Technology" to perform server side rendering of the
 * html files and serve them back to the client.
 */
@Controller
public class ClientController {

    /**
     * Returns the name of the html file to be served up at the url path. The @RequestMapping will cause the same
     * file to be served no matter which HTTP method is used.
     * @return the file name to render and return when '/' is requested.
     */
    @RequestMapping("/")
    public String getHomePage() {
        if (LoggedInUtil.isUserLoggedIn()) {
            return "external-main";
        } else {
            return "sign-in";
        }
    }
}
