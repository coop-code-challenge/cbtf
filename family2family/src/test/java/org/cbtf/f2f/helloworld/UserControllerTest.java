package org.cbtf.f2f.helloworld;

import org.cbtf.f2f.security.model.UserInfo;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Test
    public void testGetUser() {
        SecurityContext mockSecurityContext = mock(SecurityContext.class);
        Authentication mockAuthentication = mock(Authentication.class);
        UserInfo userInfo = new UserInfo("id", "name", "givenname", "familyname", "gender", "http://picture", "http://link", "bob@nomail.com");
        when(mockSecurityContext.getAuthentication()).thenReturn(mockAuthentication);
        when(mockAuthentication.getPrincipal()).thenReturn(userInfo);
        SecurityContextHolder.setContext(mockSecurityContext);

        UserController controller = new UserController();
        assertEquals(userInfo, controller.getUserInfo());
    }
}