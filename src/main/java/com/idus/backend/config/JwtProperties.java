package com.idus.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt-security")
public class JwtProperties {
    public String secret = "idsu-java-backend-developer-order-application-github-by-kimsinhyoung";
    Integer expire_date = 1000 * 60 * 60 * 24 * 7;
}
