package ua.alexshent.crm.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

    SecurityProperties securityProperties;

    public CustomDsl(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManager authenticationManager = httpSecurity.getSharedObject(AuthenticationManager.class);
        httpSecurity.addFilter(new CustomAuthenticationFilter(authenticationManager, securityProperties));
        httpSecurity.addFilterBefore(new CustomAuthorizationFilter(securityProperties), UsernamePasswordAuthenticationFilter.class);
    }
}
