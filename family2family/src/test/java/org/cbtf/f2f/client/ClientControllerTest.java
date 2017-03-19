package org.cbtf.f2f.client;

import junit.framework.TestCase;
import org.cbtf.f2f.security.model.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientControllerTest extends TestCase {
    public void testGetUnauthenticatedUserPage() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        UserInfo userInfo = new UserInfo("id", "name", "givenname", "familyname", "gender", "http://picture", "http://link", "bob@nomail.com");
        SecurityContextHolder.setContext(mockSecurityContext);

        ClientController clientController = new ClientController();
        String homePage = clientController.getHomePage();
        assertEquals("sign-in", homePage);
    }

    public void testGetAuthenticatedUserPage() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        Authentication mockAuthentication = mock(Authentication.class);
        UserInfo userInfo = new UserInfo("id", "name", "givenname", "familyname", "gender", "http://picture", "http://link", "bob@nomail.com");
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
        when(mockAuthentication.isAuthenticated()).thenReturn(Boolean.TRUE);
        SecurityContextHolder.setContext(mockSecurityContext);

        ClientController clientController = new ClientController();
        String homePage = clientController.getHomePage();
        assertEquals("main", homePage);
    }
}