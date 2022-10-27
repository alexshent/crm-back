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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
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
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security, SecurityProperties securityProperties) throws Exception {
        security.csrf().disable();
        security.cors();
        security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        security.authorizeRequests().antMatchers(securityProperties.getLoginPath(), securityProperties.getRefreshTokenPath()).permitAll();

        final String employeeControllerUrl = "/api/employee";
        security.authorizeRequests().antMatchers(HttpMethod.GET, employeeControllerUrl)
                .hasAnyAuthority(SecurityProperties.ROLE_USER, SecurityProperties.ROLE_MANAGER, SecurityProperties.ROLE_ADMIN);
        security.authorizeRequests().antMatchers(HttpMethod.POST, employeeControllerUrl)
                .hasAnyAuthority(SecurityProperties.ROLE_MANAGER, SecurityProperties.ROLE_ADMIN);
        security.authorizeRequests().antMatchers(HttpMethod.DELETE, employeeControllerUrl)
                .hasAuthority(SecurityProperties.ROLE_ADMIN);

        final String enumerationControllerUrl = "/api/enumeration";
        security.authorizeRequests().antMatchers(HttpMethod.GET, enumerationControllerUrl)
                .hasAnyAuthority(SecurityProperties.ROLE_USER, SecurityProperties.ROLE_MANAGER, SecurityProperties.ROLE_ADMIN);
        security.authorizeRequests().antMatchers(HttpMethod.POST, enumerationControllerUrl)
                .hasAnyAuthority(SecurityProperties.ROLE_MANAGER, SecurityProperties.ROLE_ADMIN);
        security.authorizeRequests().antMatchers(HttpMethod.DELETE, enumerationControllerUrl)
                .hasAuthority(SecurityProperties.ROLE_ADMIN);

        security.authorizeRequests().anyRequest().authenticated();
        security.apply(new CustomDsl(securityProperties));
        return security.build();
    }
}
