package org.cbtf.f2f.client;

import org.cbtf.f2f.domain.entity.Contact;
import org.cbtf.f2f.domain.entity.Users;
import org.cbtf.f2f.domain.repository.UsersRepository;
import org.cbtf.f2f.security.model.UserInfo;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MatchMakerControllerTest {

    private static final UserInfo TEST_USER =
            new UserInfo("id", "name", "givenname", "familyname", "gender", "http://picture", "http://link", "bob@nomail.com");

    @Test
    public void getMatchMakerPage_NotSignedIn_ReturnsSignIn() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        SecurityContextHolder.setContext(mockSecurityContext);

        MatchMakerController matchMakerController = new MatchMakerController(null);
        String matchMakerPage = matchMakerController.getMatchMakerPage();
        assertEquals("sign-in", matchMakerPage);
    }

    @Test
    public void getMatchMakerPage_SignedIn_NotAnAdmin_ReturnsExternalMain() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        Authentication mockAuthentication = mock(Authentication.class);
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
        when(mockAuthentication.isAuthenticated()).thenReturn(Boolean.TRUE);
        when(mockAuthentication.getPrincipal()).thenReturn(TEST_USER);
        SecurityContextHolder.setContext(mockSecurityContext);

        final UsersRepository mockUsersRepository = mock(UsersRepository.class);
        when(mockUsersRepository.findOne(TEST_USER.getEmail())).thenReturn(new Users());

        MatchMakerController matchMakerController = new MatchMakerController(mockUsersRepository);
        String matchMakerPage = matchMakerController.getMatchMakerPage();
        assertEquals("external-main", matchMakerPage);
    }

    @Test
    public void getMatchMakerPage_SignedIn_Admin_ReturnsMatchMaker() {
        final SecurityContext mockSecurityContext = mock(SecurityContext.class);
        final Authentication mockAuthentication = mock(Authentication.class);
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
        when(mockAuthentication.isAuthenticated()).thenReturn(Boolean.TRUE);
        when(mockAuthentication.getPrincipal()).thenReturn(TEST_USER);
        SecurityContextHolder.setContext(mockSecurityContext);

        final Users adminUser =
                new Users("admin-1", "Admin", "User", true, true, mock(Contact.class));
        final UsersRepository mockUsersRepository = mock(UsersRepository.class);
        when(mockUsersRepository.findOne(TEST_USER.getEmail())).thenReturn(adminUser);

        MatchMakerController matchMakerController = new MatchMakerController(mockUsersRepository);
        String matchMakerPage = matchMakerController.getMatchMakerPage();
        assertEquals("match-maker", matchMakerPage);
    }
}
