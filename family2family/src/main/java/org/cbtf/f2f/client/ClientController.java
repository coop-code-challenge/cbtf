package org.cbtf.f2f.client;

import org.cbtf.f2f.domain.entity.Users;
import org.cbtf.f2f.domain.repository.UsersRepository;
import org.cbtf.f2f.security.model.UserInfo;
import org.cbtf.f2f.util.LoggedInUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The {@link ClientController} relies on the ThymeLeaf "View Technology" to perform server side rendering of the
 * html files and serve them back to the client.
 */
@Controller
public class ClientController {

    private final UsersRepository usersRepository;

    @Autowired
    public ClientController(final UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Returns the name of the html file to be served up at the url path. The @RequestMapping will cause the same
     * file to be served no matter which HTTP method is used.
     * @return the file name to render and return when '/' is requested.
     */
    @RequestMapping("/")
    public String getHomePage() {
        if (LoggedInUtil.isUserLoggedIn()) {
            UserInfo googleUser = LoggedInUtil.getLoggedInUser();
            Users appUser = usersRepository.findOne(googleUser.getEmail());
            if (appUser == null) {
                return "request-auth";
            }
            else if (appUser.getAdmin()) {
                return "internal-main";
            }
            else {
                return "external-main";
            }
        } else {
            return "sign-in";
        }
    }
}
