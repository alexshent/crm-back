package ua.alexshent.crm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.alexshent.crm.service.UserService;

// https://www.rfc-editor.org/rfc/rfc7519
// https://jwt.io/
// https://www.youtube.com/watch?v=VVn9OG9nfH0

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity security, BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService)
            throws Exception {
        return security
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security, SecurityProperties securityProperties) throws Exception {
        security.csrf().disable();
        security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        security.authorizeRequests().antMatchers(securityProperties.getLoginPath(), securityProperties.getRefreshTokenPath()).permitAll();
        security.authorizeRequests().antMatchers(HttpMethod.GET, "/api/employee/*").hasAnyAuthority("user");
        security.authorizeRequests().anyRequest().authenticated();
        security.apply(new CustomDsl(securityProperties));
        return security.build();
    }
}
