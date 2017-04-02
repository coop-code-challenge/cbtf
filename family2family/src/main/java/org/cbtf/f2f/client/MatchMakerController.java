package org.cbtf.f2f.client;

import org.cbtf.f2f.domain.entity.Users;
import org.cbtf.f2f.domain.repository.UsersRepository;
import org.cbtf.f2f.security.model.UserInfo;
import org.cbtf.f2f.util.LoggedInUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * The server side controller for serving up webpages for the MatchMaker component.
 */
@Controller
public class MatchMakerController {

    private UsersRepository usersRepository;

    @Autowired
    MatchMakerController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping("/find-a-mentor")
    public String getMatchMakerPage() {
        return isUserLoggedIn() ? getLoggedInUserPage() : getSignInPage();
    }

    private boolean isUserLoggedIn() {
        return LoggedInUtil.isUserLoggedIn();
    }

    private String getLoggedInUserPage() {
        return isUserAnAdmin() ? getActualMatchMakerPage() : getExternalUserMainPage();
    }

    private boolean isUserAnAdmin() {
        Optional<Users> user = getUser();
        return user.isPresent() && Boolean.TRUE.equals(user.get().getAdmin());
    }

    private String getActualMatchMakerPage() {
        return "match-maker";
    }

    private String getExternalUserMainPage() {
        return "external-main";
    }

    private Optional<Users> getUser() {
        UserInfo loggedInUser = LoggedInUtil.getLoggedInUser();
        String usersEmail = loggedInUser.getEmail();
        return Optional.ofNullable(usersRepository.findOne(usersEmail));
    }

    private String getSignInPage() {
        return "sign-in";
    }

}
