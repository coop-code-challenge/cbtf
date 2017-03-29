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
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientControllerTest {

    private static final UserInfo TEST_USER =
            new UserInfo("id", "name", "givenname", "familyname", "gender", "http://picture", "http://link", "bob@nomail.com");

    @Test
    public void testGetUnauthenticatedUserPage() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        SecurityContextHolder.setContext(mockSecurityContext);

        ClientController clientController = new ClientController(null);
        String homePage = clientController.getHomePage();
        assertEquals("sign-in", homePage);
    }

    @Test
    public void testGetAuthenticatedUserPage() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        Authentication mockAuthentication = mock(Authentication.class);
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
        when(mockAuthentication.isAuthenticated()).thenReturn(Boolean.TRUE);
        when(mockAuthentication.getPrincipal()).thenReturn(TEST_USER);
        SecurityContextHolder.setContext(mockSecurityContext);

        final UsersRepository mockUsersRepository = mock(UsersRepository.class);
        when(mockUsersRepository.findOne(anyString())).thenReturn(new Users());

        ClientController clientController = new ClientController(mockUsersRepository);
        String homePage = clientController.getHomePage();
        assertEquals("external-main", homePage);
    }

    @Test
    public void getHomePage_AdminUser() {
        final SecurityContext mockSecurityContext = mock(SecurityContext.class);
        final Authentication mockAuthentication = mock(Authentication.class);
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
        when(mockAuthentication.isAuthenticated()).thenReturn(Boolean.TRUE);
        when(mockAuthentication.getPrincipal()).thenReturn(TEST_USER);
        SecurityContextHolder.setContext(mockSecurityContext);

        final UsersRepository mockUsersRepository = mock(UsersRepository.class);
        final Users adminUser =
                new Users("admin-1", "Admin", "User", true, true, mock(Contact.class));
        when(mockUsersRepository.findOne(anyString())).thenReturn(adminUser);

        final ClientController fixture = new ClientController(mockUsersRepository);
        assertEquals("internal-main", fixture.getHomePage());
    }

}