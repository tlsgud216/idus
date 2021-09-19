package com.idus.backend.filter;

import com.idus.backend.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JwtRequestFilter extends BasicAuthenticationFilter {
    private final JwtProperties jwtProperties;

    public JwtRequestFilter(
            AuthenticationManager authenticationManager,
            JwtProperties jwtProperties
    ) {
        super(authenticationManager);
        this.jwtProperties = jwtProperties;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        String header = request.getHeader("Authorization");

        SecurityContextHolder.getContext().setAuthentication(getAuthentication(header));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtProperties.secret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token);

            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(claims.getBody().get("member_id"), null, authorities);
        } catch (Exception e) {
            return null;
        }
    }
}
