package org.cbtf.f2f.security;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.List;

/**
 * The {@link OAuth2Client} holds the information needed to connect to Google's OAuth2 APIs
 */
@Configuration
@EnableOAuth2Client
public class OAuth2Client {

    private static final List<String> OAUTH_2_SCOPES = Lists.newArrayList("openid", "email");

    @Value("${google.oauth2.clientId}")
    private String clientId;

    @Value("${google.oauth2.clientSecret}")
    private String clientSecret;

    @Value("${google.oauth2.authorizationUri}")
    private String authorizationUri;

    @Value("${google.oauth2.accessTokenUri}")
    private String accessTokenUri;
    
    @Bean
    public OAuth2ProtectedResourceDetails googleOAuth2Details() {
        AuthorizationCodeResourceDetails googleOAuth2Details = new AuthorizationCodeResourceDetails();
        googleOAuth2Details.setAuthenticationScheme(AuthenticationScheme.form);
        googleOAuth2Details.setClientAuthenticationScheme(AuthenticationScheme.form);
        googleOAuth2Details.setClientId(clientId);
        googleOAuth2Details.setClientSecret(clientSecret);
        googleOAuth2Details.setUserAuthorizationUri(authorizationUri);
        googleOAuth2Details.setAccessTokenUri(accessTokenUri);
        googleOAuth2Details.setScope(OAUTH_2_SCOPES);
        return googleOAuth2Details;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public OAuth2RestOperations googleOAuth2RestTemplate(OAuth2ClientContext oAuth2ClientContext) {
        return new OAuth2RestTemplate(googleOAuth2Details(), oAuth2ClientContext);
    }
}
