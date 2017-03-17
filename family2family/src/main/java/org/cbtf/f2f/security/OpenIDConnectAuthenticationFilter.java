package org.cbtf.f2f.security;

import org.cbtf.f2f.security.model.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * The {@link OpenIDConnectAuthenticationFilter} is responsible for extracting the users information from an
 * authenticated OAuth2 scenario.
 */
public class OpenIDConnectAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final AuthenticationManager AUTHENTICATION_MANAGER = authentication -> authentication;

    @Resource
    private OAuth2RestOperations restTemplate;

    OpenIDConnectAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(AUTHENTICATION_MANAGER);
    }

    /**
     * If the user has authentication with google, the restTemplate will have the AccessToken issued by the OAuth2
     * Provider embedded inside.
     *
     * We are currently polling google to get the user's info on each request. We can swap to make use of the id_token
     * property of the access token to pull the same info, but it requires decoding (and verifying!!) a JWT
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        //TODO Swap to pull the UserInfo from restTemplate.getAccessToken().getAdditionalInformation().get("id_token");
        final ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.getForEntity("https://www.googleapis.com/oauth2/v2/userinfo", UserInfo.class);
        UserInfo userInfo = userInfoResponseEntity.getBody();
        //TODO This is where we can verify the user has access to the application as well as set the granted authorities to indicate admin vs non admin
        return new PreAuthenticatedAuthenticationToken(userInfo, Optional.empty(), AuthorityUtils.NO_AUTHORITIES);
    }
}