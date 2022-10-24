package ua.alexshent.crm.security;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SecurityProperties {
    private final String secret;
    private final String loginPath;
    private final String refreshTokenPath;
    private final String accessTokenLifetime;
    private final String refreshTokenLifetime;

    public SecurityProperties(Environment environment) {
        secret = environment.getProperty("ua.alexshent.crm.security.secret");
        loginPath = environment.getProperty("ua.alexshent.crm.security.loginPath");
        refreshTokenPath = environment.getProperty("ua.alexshent.crm.security.refreshTokenPath");
        accessTokenLifetime = environment.getProperty("ua.alexshent.crm.security.accessTokenLifetime");
        refreshTokenLifetime = environment.getProperty("ua.alexshent.crm.security.refreshTokenLifetime");
    }

    public String getSecret() {
        return secret;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public String getRefreshTokenPath() {
        return refreshTokenPath;
    }

    public String getAccessTokenLifetime() {
        return accessTokenLifetime;
    }

    public String getRefreshTokenLifetime() {
        return refreshTokenLifetime;
    }
}
