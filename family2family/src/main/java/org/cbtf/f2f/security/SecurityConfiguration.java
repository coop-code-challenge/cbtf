package org.cbtf.f2f.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final String LOGIN_URL = "/login";

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint(LOGIN_URL);
    }

    @Bean
    public OpenIDConnectAuthenticationFilter openIdConnectAuthenticationFilter() {
        return new OpenIDConnectAuthenticationFilter(LOGIN_URL);
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/");
        web.ignoring().antMatchers("/login**");
        web.ignoring().antMatchers("/webjars/**");
        web.ignoring().antMatchers("/js/**.jsx");
        web.ignoring().antMatchers("/favicon.ico");
        //TODO remove this when going to prod
        web.ignoring().antMatchers("/console/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Add the OAuth2 Security Filter to actually authenticate the user if necessary
        http.addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                //Add the OpenID Connect Filter immediately after to extract the users information
                .addFilterAfter(openIdConnectAuthenticationFilter(), OAuth2ClientContextFilter.class)
                //On Exceptions, redirect to the auth entry point
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .and()
                //Require authorization on all requests
                .antMatcher("/**").authorizeRequests()
                //Don't require auth to hit: /, /login, /webjars/**
                //TODO add security role and restrictions for admin services
                //Allow authenticated users to hit all other requests
                .anyRequest().authenticated()
                //install the logout module, invalidate the session on logout, and grant access to the after logout url
                .and().logout().invalidateHttpSession(true).logoutSuccessUrl("/").permitAll()
                //TODO-Figure out CSRF -- Leaving disabled opens a security hole.
                //Disable CSRF for now and deal with it later. H2-Console requires CSRF to be disabled
                .and().csrf().disable();
    }
}
